package ess.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Holiday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date startDate;
	private Date endDate;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDateString) {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date d = sdf1.parse(startDateString);
			startDate = new java.sql.Date(d.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDateString) {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date d = sdf1.parse(endDateString);
			endDate = new java.sql.Date(d.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
