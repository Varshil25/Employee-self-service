package ess.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import ess.dao.HolidayDao;
import ess.model.Holiday;

@Service
public class HolidayService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private HolidayDao holidayDao;

	@Transactional
	public void addHoliday(Holiday holiday) {
		this.hibernateTemplate.saveOrUpdate(holiday);
	}

	@Transactional
	public List<Holiday> getAllHolidayDetails(){
		return holidayDao.getAllHolidayDetails();
	}
	
	@Transactional
	public void deleteHoliday(Integer id) {
		holidayDao.deleteHoliday(id);
	}
}
