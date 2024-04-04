package ess.model;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Date date;
	private Time time;

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

	public Date getDate() {
		return date;
	}

	public void setDate(String dateString) {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date d = sdf1.parse(dateString);
			date = new java.sql.Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			// Handle parsing exception
		}
	}

	public Time getTime() {
		return time;
	}

	public void setTime(String timeString) {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
			java.util.Date t = sdf1.parse(timeString);
			time = new Time(t.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			// Handle parsing exception
		}
	}
}
