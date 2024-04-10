package ess.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Attendance", uniqueConstraints = @UniqueConstraint(columnNames = { "userid", "date" }))
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "userid")
	private int userid;
	@Column(name = "date")
	private LocalDate date;
	private String shift;
	private LocalTime firstIn;
	private LocalTime lastout;
	private String firstHalf;
	private String secondHalf;
	private LocalTime netWork;
	@OneToMany(mappedBy = "attendance", fetch = FetchType.EAGER)
	private List<AttendanceRecord> attendanceRecords = new ArrayList<>();

	public Attendance() {
		super();
		this.attendanceRecords = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public LocalTime getFirstIn() {
		return firstIn;
	}

	public void setFirstIn(LocalTime firstIn) {
		this.firstIn = firstIn;
	}

	public LocalTime getLastout() {
		return lastout;
	}

	public void setLastout(LocalTime lastout) {
		this.lastout = lastout;
	}

	public String getFirstHalf() {
		return firstHalf;
	}

	public void setFirstHalf(String firstHalf) {
		this.firstHalf = firstHalf;
	}

	public String getSecondHalf() {
		return secondHalf;
	}

	public void setSecondHalf(String secondHalf) {
		this.secondHalf = secondHalf;
	}

	public LocalTime getNetWork() {
		return netWork;
	}

	public void setNetWork(LocalTime netWork) {
		this.netWork = netWork;
	}

	public List<AttendanceRecord> getAttendanceRecords() {
		return attendanceRecords;
	}

	public void setAttendanceRecords(List<AttendanceRecord> attendanceRecords) {
		this.attendanceRecords = attendanceRecords;
	}

	public void addAttendanceRecord(AttendanceRecord attendanceRecord) {
		attendanceRecord.setAttendance(this);
		this.attendanceRecords.add(attendanceRecord);
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Attendance(int id, int userid, LocalDate date, String shift, LocalTime firstIn, LocalTime lastout,
			String firstHalf, String secondHalf, LocalTime netWork, List<AttendanceRecord> attendanceRecords) {
		super();
		this.id = id;
		this.userid = userid;
		this.date = date;
		this.shift = shift;
		this.firstIn = firstIn;
		this.lastout = lastout;
		this.firstHalf = firstHalf;
		this.secondHalf = secondHalf;
		this.netWork = netWork;
		this.attendanceRecords = attendanceRecords;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", userid=" + userid + ", date=" + date + ", shift=" + shift + ", firstIn="
				+ firstIn + ", lastout=" + lastout + ", firstHalf=" + firstHalf + ", secondHalf=" + secondHalf
				+ ", netWork=" + netWork + ", attendanceRecords=" + attendanceRecords + "]";
	}

}