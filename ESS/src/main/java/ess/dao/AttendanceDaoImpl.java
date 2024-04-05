package ess.dao;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ess.model.Attendance;
import ess.model.PunchType;
import ess.model.User;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveAttendance(Attendance attendance) {
		Session session = sessionFactory.getCurrentSession();
		session.save(attendance);
	}

}
