package ess.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ess.model.Attendance;
import ess.model.AttendanceRecord;
import ess.services.AttendanceRecordServices;
import ess.services.AttendanceServices;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceServices attendanceServices;

	@Autowired
	private AttendanceRecordServices attendanceRecordServices;

	@RequestMapping("/dashboard")
	public String dashBoardPage() {
		return "empHome";
	}

	@RequestMapping("/getAttendance/{userId}")
	String getAttendence(@PathVariable("userId") int userId, Model model) {
		System.out.println(userId);
		model.addAttribute("userId", userId);
		return "GetMonth";
	}

	@RequestMapping(value = "/getAttendance/ShowAttendance/{userId}", method = RequestMethod.GET)
	public String showAttendance(@PathVariable("userId") int userId, HttpSession session, HttpServletRequest request,
			@RequestParam("month") String month, Model model) {
		// Parse the month parameter to extract the year and month
		String[] parts = month.split("-");
		int year = Integer.parseInt(parts[0]);
		int monthValue = Integer.parseInt(parts[1]);

		// Create a LocalDate object for the first day of the specified month
		LocalDate date = YearMonth.of(year, monthValue).atDay(1);
		System.out.println("Month: " + monthValue + ", Year: " + year);

		// Retrieve attendance data for the specified employee ID and month
		List<Attendance> attendanceList = attendanceServices.getAttendanceByMonth(userId, date);
		System.out.println(attendanceList);
		// Add the retrieved attendance data to the model
		model.addAttribute("attendanceList", attendanceList);
		model.addAttribute("userId", userId);
		model.addAttribute("month", month);

		// Return the name of the view
		return "ShowAttendance";
	}

	@RequestMapping(value = "/daily-attendance", method = RequestMethod.GET)
	public String showdailyAttendnace(HttpSession session, HttpServletRequest request, Model model) {
		model.addAttribute("title", "Attendnace handle");
		List<Attendance> attendanceList = attendanceServices.getAllAttendancesDetails();
		model.addAttribute("attendanceList", attendanceList);
		return "ShowAttendance";
	}

	@RequestMapping(value = "/daily-attendance-id", method = RequestMethod.GET)
	public String showdailyAttendnaceById(HttpSession session, HttpServletRequest request, Model model) {
		model.addAttribute("title", "Attendance handle");
		int userId = (int) session.getAttribute("userId");
		List<Attendance> attendanceList = attendanceServices.getAllAttendancesByUserId(userId);
		model.addAttribute("attendanceList", attendanceList);
		return "ShowAttendance";
	}

	@RequestMapping("/startSession/{userId}")
	public String startSession(@PathVariable("userId") int userId, Model model, HttpSession session,
			HttpServletRequest request) {
		// Retrieve attendance for the employee for today
		Attendance attend = attendanceServices.getAttendance(userId, LocalDate.now());
		if (attend != null) {
			// If attendance record already exists, update it
			attend.setFirstIn(LocalTime.now());
		} else {
			// If attendance record doesn't exist, create a new one
			attend = new Attendance();
			attend.setUserid(userId);
			attend.setDate(LocalDate.now());
			attend.setShift("DG-Normal");
			attend.setFirstIn(LocalTime.now());
		}

		// Save or update the attendance
		try {
			attendanceServices.save(attend);
		} catch (Exception e) {
			// Handle the case when saving attendance fails
			// You can log the error or handle it in any other appropriate way
			// For simplicity, just return an error view here
			return "errorView";
		}

		// Create a new attendance record
		AttendanceRecord rec = new AttendanceRecord();
		rec.setType("In");
		rec.setDate(LocalDate.now());
		LocalTime time = LocalTime.now();
		int hours = time.getHour();
		int minutes = time.getMinute();
		rec.setTime(LocalTime.of(hours, minutes));

		// Associate the attendance record with the attendance
		rec.setAttendance(attend);

		// Save the attendance record
		try {
			attendanceRecordServices.saveRecord(rec);
		} catch (Exception e) {
			// Handle the case when saving the attendance record fails
			// You can log the error or handle it in any other appropriate way
			// For simplicity, just return an error view here
			return "errorView";
		}

		// Retrieve employee information and add it to the model
		session = request.getSession(false); // Use false to prevent creating a new session if it doesn't
												// exist

		if (session != null) {
			userId = (int) session.getAttribute("userId");
		} else {
			System.out.println("Session not found");
		}

		// Return the view name
		return "empHome";
	}

	@RequestMapping("/endSession/{userId}")
	String endSession(@PathVariable("userId") int userId, Model model, HttpSession session,
			HttpServletRequest request) {
		// Create a new attendance record
		AttendanceRecord rec = new AttendanceRecord();
		rec.setType("Out");
		rec.setDate(LocalDate.now());
		LocalTime time = LocalTime.now();
		int hours = time.getHour();
		int minutes = time.getMinute();
		rec.setTime(LocalTime.of(hours, minutes));

		// Retrieve attendance for the employee for today within the transactional
		// context
		Attendance attend = attendanceServices.getAttendance(userId, LocalDate.now());
		List<AttendanceRecord> record = attend.getAttendanceRecords();
		LocalTime lastLoginTime = record.get(record.size() - 1).getTime();
		Duration duration = Duration.between(lastLoginTime, LocalTime.of(hours, minutes));
		LocalTime currentWork = LocalTime.of((int) duration.toHours(), (int) duration.toMinutes());
		if (attend.getNetWork() != null) {
			attend.setNetWork(
					attend.getNetWork().plusHours(currentWork.getHour()).plusMinutes(currentWork.getMinute()));
		} else {
			attend.setNetWork(currentWork);
		}
		if (attend.getNetWork().compareTo(LocalTime.of(3, 0)) >= 0) {
			attend.setFirstHalf("PR");
			if (attend.getNetWork().compareTo(LocalTime.of(6, 0)) >= 0) {
				attend.setSecondHalf("PR");
			} else {
				attend.setSecondHalf("AB");
			}
		} else {
			attend.setFirstHalf("AB");
			attend.setSecondHalf("AB");
		}
		// Set the last out time in the attendance
		attend.setLastout(LocalTime.now());

		// Add the attendance record to the attendance
		rec.setAttendance(attend);

		// Save the attendance record
		attendanceRecordServices.saveRecord(rec);

		// Save or update the attendance within the same transactional context
		try {
			attendanceServices.save(attend);
		} catch (Exception e) {
			// Handle the case when saving attendance fails
			// You can log the error or handle it in any other appropriate way
			// For simplicity, just return an error view here
			return "errorView";
		}

		session = request.getSession(false); // Use false to prevent creating a new session if it doesn't
		// exist

		if (session != null) {
			userId = (int) session.getAttribute("userId");
		} else {
			System.out.println("Session not found");
		}

		// Return the view name
		return "empHome";
	}
}
