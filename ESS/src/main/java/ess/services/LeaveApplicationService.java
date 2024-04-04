package ess.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import ess.dao.LeaveApplicationDao;
import ess.model.LeaveApplication;
import ess.model.TourLeave;
import ess.model.Training;

@Service
public class LeaveApplicationService {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private LeaveApplicationDao leaveApplicationDao;

	@Transactional
	public void addLeave(LeaveApplication leaveApplication) {
		this.hibernateTemplate.saveOrUpdate(leaveApplication);
	}

	@Transactional
	public List<LeaveApplication> getAllLeaveApplications() {
		return leaveApplicationDao.getAllLeaveApplications();
	}

	@Transactional
	public void deleteLeave(Integer id) {
		leaveApplicationDao.deleteLeave(id);
	}

	public void updateLeave(LeaveApplication leaveApplication) {
		leaveApplicationDao.updateLeave(leaveApplication);
	}

	public LeaveApplication getLeaveById(Integer id) {
		return leaveApplicationDao.getLeaveById(id);
	}

	@Transactional
	public void addTourLeave(TourLeave tourLeave) {
		this.hibernateTemplate.saveOrUpdate(tourLeave);
	}

	@Transactional
	public void deleteTourLeave(Integer id) {
		leaveApplicationDao.deleteLeave(id);
	}

	@Transactional
	public List<LeaveApplication> findByUserId(int id) {
		return leaveApplicationDao.findByUserId(id);
	}
}
