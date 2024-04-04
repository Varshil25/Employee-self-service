package ess.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ess.model.Holiday;

@Repository
public class HolidayDaoimpl implements HolidayDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void addHoliday(Holiday holiday) {
		Session session = sessionFactory.getCurrentSession();
		session.save(holiday);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Holiday> getAllHolidayDetails() {

		return sessionFactory.getCurrentSession().createQuery("from Holiday").list();
	}

	@Override
	public void deleteHoliday(Integer id) {
		Holiday holiday = this.hibernateTemplate.load(Holiday.class, id);
		if (holiday != null) {
			hibernateTemplate.delete(holiday);
		}
		
	}

}
