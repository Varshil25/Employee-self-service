package ess.dao;

import java.util.List;

import ess.model.LeaveApplication;
import ess.model.TourLeave;

public interface LeaveApplicationDao {

	void addLeave(LeaveApplication leaveApplication);

	List<LeaveApplication> getAllLeaveApplications();

	void deleteLeave(Integer id);

	void updateLeave(LeaveApplication leaveApplication);

	LeaveApplication getLeaveById(Integer id);

	List<LeaveApplication> findByUserId(int id);

	
}
