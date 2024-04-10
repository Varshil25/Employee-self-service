package ess.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ess.model.AttendanceRecord;

@Repository
public class AttendanceRecordDao {
	@Autowired
	private HibernateTemplate ht;

	@Transactional
	public void addAttendanceRecord(AttendanceRecord attend) throws DataAccessException {
		try {
			this.ht.save(attend);
		} catch (DataAccessException ex) {
			// Handle or log the exception appropriately
			throw ex; // Re-throwing the exception to propagate it to the caller
		}
	}
}