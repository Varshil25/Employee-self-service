package ess.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TourLeave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fromDate;
	private Date toDate;
	private String fromdayType;
	private String todayType;
	private String leaveType;
	private String reason;
	private String address;
	private String number;
	private String appliedDuration;
	private String postedDuration;
	private String file;
	private String status = "Pending";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDateString) {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date fd = sdf1.parse(fromDateString);
			fromDate = new java.sql.Date(fd.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			// Handle parsing exception
		}
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(String toDateString) {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date td = sdf1.parse(toDateString);
			toDate = new java.sql.Date(td.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getFromdayType() {
		return fromdayType;
	}

	public void setFromdayType(String fromdayType) {
		this.fromdayType = fromdayType;
	}

	public String getTodayType() {
		return todayType;
	}

	public void setTodayType(String todayType) {
		this.todayType = todayType;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAppliedDuration() {
		return appliedDuration;
	}

	public void setAppliedDuration(String appliedDuration) {
		this.appliedDuration = appliedDuration;
	}

	public String getPostedDuration() {
		return postedDuration;
	}

	public void setPostedDuration(String postedDuration) {
		this.postedDuration = postedDuration;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
