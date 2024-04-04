package ess.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ess.model.LeaveApplication;
import ess.model.TourLeave;
import ess.model.Training;

@Repository
public class LeaveApplicationDaoImpl implements LeaveApplicationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void addLeave(LeaveApplication leaveApplication) {
		Session session = sessionFactory.getCurrentSession();
		session.save(leaveApplication);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LeaveApplication> getAllLeaveApplications() {
		return sessionFactory.getCurrentSession().createQuery("from LeaveApplication").list();
	}

	@Override
	public void deleteLeave(Integer id) {
		LeaveApplication leaveApplication = this.hibernateTemplate.load(LeaveApplication.class, id);
		if (leaveApplication != null) {
			hibernateTemplate.delete(leaveApplication);
		}
	}

	@Override
	public void updateLeave(LeaveApplication leaveApplication) {
		hibernateTemplate.update(leaveApplication);
	}

	@Override
	public LeaveApplication getLeaveById(Integer id) {
		return this.hibernateTemplate.get(LeaveApplication.class, id);
	}

	@Override
	public List<LeaveApplication> findByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<LeaveApplication> query = builder.createQuery(LeaveApplication.class);
		Root<LeaveApplication> root = query.from(LeaveApplication.class);
		query.select(root).where(builder.equal(root.get("id"), id));
		return session.createQuery(query).getResultList();
	}

}
