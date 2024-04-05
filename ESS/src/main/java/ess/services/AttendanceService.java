package ess.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import ess.dao.AttendanceDao;
import ess.model.Attendance;

@Service
public class AttendanceService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private AttendanceDao attendanceDao;

	@Transactional
	public void saveAttendance(Attendance attendance) {
		this.attendanceDao.saveAttendance(attendance);
	}
}
