package ess.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ess.dao.AttendanceDao;
import ess.model.Attendance;
import ess.model.Event;

@Service
public class AttendanceServices {
	@Autowired
	private AttendanceDao attendanceDao;

	public void save(Attendance attend) {
		attendanceDao.addAttendance(attend);
	}

	public Attendance getAttendance(int userId, LocalDate date) {
		return attendanceDao.getAttendance(userId, date);
	}

	public List<Attendance> getAttendanceByMonth(int userId, LocalDate startDate) {
		return attendanceDao.getAttendanceByMonth(userId, startDate);
	}

	@Transactional
	public List<Attendance> getAllAttendancesDetails() {
		return attendanceDao.getAllAttendancesDetails();
	}

	@Transactional
	public List<Attendance> getAllAttendancesByUserId(int userId) {
		return attendanceDao.getAllAttendancesByUserId(userId);
	}

}
