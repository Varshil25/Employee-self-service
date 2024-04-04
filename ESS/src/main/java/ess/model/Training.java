package ess.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Training {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String trainingName;
	private String duration;
	private Date startDate;
	private Date endDate;
	private String mode;
	private String skillsNeeded;
	private String trainingObjective;
	private String location;
	private String industryExpertName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDateString) {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date = sdf1.parse(startDateString);
			startDate = new java.sql.Date(date.getTime());  
		} catch (ParseException e) {
			e.printStackTrace();
			// Handle parsing exception
		}
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDateString) {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date = sdf1.parse(endDateString);
			endDate = new java.sql.Date(date.getTime());  
		} catch (ParseException e) {
			e.printStackTrace();
			// Handle parsing exception
		}
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getSkillsNeeded() {
		return skillsNeeded;
	}

	public void setSkillsNeeded(String skillsNeeded) {
		this.skillsNeeded = skillsNeeded;
	}

	public String getTrainingObjective() {
		return trainingObjective;
	}

	public void setTrainingObjective(String trainingObjective) {
		this.trainingObjective = trainingObjective;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIndustryExpertName() {
		return industryExpertName;
	}

	public void setIndustryExpertName(String industryExpertName) {
		this.industryExpertName = industryExpertName;
	}

}
