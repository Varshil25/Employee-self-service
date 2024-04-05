package ess.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ess.model.Attendance;
import ess.model.PunchType;
import ess.model.User;
import ess.services.AttendanceService;
import ess.services.UserService;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@Autowired
	private UserService userService;

	@GetMapping("/dashboard")
	public String homeemp(Model model) {
		model.addAttribute("title", "Employee punchIn & punchOut");
		return "mainattendancepage";
	}

	@GetMapping("/in")
	public String punchIn(Model model, Principal principal) {
		String username = principal.getName();
		User user = userService.findByUserName(username);

		Attendance attendance = new Attendance();
		attendance.setUser(user);
		attendance.setUserName(user.getName());
		attendance.setPunchTime(LocalDateTime.now());
		attendance.setType(PunchType.In);

		attendanceService.saveAttendance(attendance);

		return "mainattendancepage";
	}

}
