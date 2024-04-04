package ess.dao;

import java.util.List;

import ess.model.Event;

public interface EventDao {
	void addEvent(Event event);
	
	List<Event> getAllEventDetails();
	
	void deleteEvent(Integer id);
}
