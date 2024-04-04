package ess.dao;

import java.util.List;

import ess.model.Holiday;

public interface HolidayDao {
	void addHoliday(Holiday holiday);
	
	List<Holiday> getAllHolidayDetails();
	
	public void deleteHoliday(Integer id);
}
