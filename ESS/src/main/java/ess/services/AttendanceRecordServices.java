package ess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ess.dao.AttendanceRecordDao;
import ess.model.AttendanceRecord;

import org.springframework.dao.DataAccessException;

@Service
public class AttendanceRecordServices {
	@Autowired
	private AttendanceRecordDao attendanceRecordDao;

	public void saveRecord(AttendanceRecord rec) throws DataAccessException {
		try {
			attendanceRecordDao.addAttendanceRecord(rec);
		} catch (DataAccessException ex) {
			// Handle or log the exception appropriately
			throw ex; // Re-throwing the exception to propagate it to the caller
		}
	}
}
