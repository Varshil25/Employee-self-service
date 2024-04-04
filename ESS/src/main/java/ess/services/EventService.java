package ess.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import ess.dao.EventDao;
import ess.model.Event;

@Service
public class EventService {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private EventDao eventDao;
	
	@Transactional
	public void addEvent(Event event) {
		this.hibernateTemplate.saveOrUpdate(event);
	}
	
	@Transactional
	public List<Event> getAllEventDetails(){
		return eventDao.getAllEventDetails();
	}
	
	@Transactional
	public void deleteEvent(Integer id) {
		eventDao.deleteEvent(id);
	}
}
