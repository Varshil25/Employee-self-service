package ess.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ess.model.Event;
import ess.model.Training;

@Repository
public class EventDaoImpl implements EventDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEvent(Event event) {
		Session session = sessionFactory.getCurrentSession();
		session.save(event);
	}

	@Override
	public List<Event> getAllEventDetails() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Event").list();
	}

	@Override
	public void deleteEvent(Integer id) {
		Event event = this.hibernateTemplate.load(Event.class, id);
		if (event != null) {
			hibernateTemplate.delete(event);
		}
	}


}
