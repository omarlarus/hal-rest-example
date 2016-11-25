package it.larus.assess.restspark.domain;

/**
 * A module to track work time of a worker
 * 
 * @author omar
 *
 */
public class Timesheet {
	private String worker;
	private int minutes;
	private String refTask;
	private Integer year;
	private Integer month;
	private Integer day;

	public Timesheet() {
		worker = "N/D";
		minutes = 0;
	}
	
	public Timesheet(String worker, int minutes) {
		super();
		this.worker = worker;
		this.minutes = minutes;
	}

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getRefTask() {
		return refTask;
	}

	public void setRefTask(String refTask) {
		this.refTask = refTask;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

}
