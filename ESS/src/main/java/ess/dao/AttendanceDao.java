package ess.dao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ess.model.Attendance;
import ess.model.Event;

@Repository
public class AttendanceDao {
	@Autowired
	private HibernateTemplate ht;

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addAttendance(Attendance attend) {
		this.ht.saveOrUpdate(attend);
	}

	public Attendance getAttendance(int userId, LocalDate date) {
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Attendance> attendanceList = (List<Attendance>) this.ht.findByNamedParam(
				"FROM Attendance WHERE userId = :userId AND date = :date", new String[] { "userId", "date" },
				new Object[] { userId, date });

		return attendanceList.isEmpty() ? null : attendanceList.get(0);
	}

	public List<Attendance> getAttendanceByMonth(int userId, LocalDate date) {
		int month = date.getMonthValue();
		int year = date.getYear();

		String hqlQuery = "FROM Attendance WHERE userid = :userId " + "AND MONTH(date) = :month AND YEAR(date) = :year";

		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Attendance> attendanceList = (List<Attendance>) this.ht.findByNamedParam(hqlQuery,
				new String[] { "userId", "month", "year" }, new Object[] { userId, month, year });

		return attendanceList;
	}

	public List<Attendance> getAllAttendancesByUserId(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Attendance> query = currentSession.createQuery("from Attendance where userId=:userId", Attendance.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	public List<Attendance> getAllAttendancesDetails() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Attendance").list();
	}

}
