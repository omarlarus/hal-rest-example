package it.larus.assess.restspark.representation;

import java.util.Date;

/*
			{
				day: "2016/11/01",
				workhours: 6,
				permithours: 2, 
				lunchtickets: 1
			},
 */
public class UserDailyReport {
	private Date day;
	private int workHours;
	private int permitHours;
	private int lunchTickets;

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public int getWorkHours() {
		return workHours;
	}

	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}

	public int getPermitHours() {
		return permitHours;
	}

	public void setPermitHours(int permitHours) {
		this.permitHours = permitHours;
	}

	public int getLunchTickets() {
		return lunchTickets;
	}

	public void setLunchTickets(int lunchTickets) {
		this.lunchTickets = lunchTickets;
	}

}
