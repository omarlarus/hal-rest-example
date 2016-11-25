package it.larus.assess.restspark.representation;

import java.util.List;

import it.larus.assess.restspark.domain.User;

/*
	{
		title: "Rapportino Novembre 2016 - Omar Rampado",
		year: 2016,
		month: 11,
		user: {
			id: 123,
			realname: "Omar Rampado"
		},
		workdays: 20,
		lunchtickets: 18,
		_links: {
			self: {href: "/report/user/123/timesheet/2016/11"}
		}
		dailyreports:[
			{
				day: "2016/11/01",
				workhours: 6,
				permithours: 2, 
				lunchtickets: 1
			},
			{
				day: "2016/11/02",
				workhours: 4,
				permithours: 4, 
				lunchtickets: 0
			},...
		]
	}
 */
public class UserMonthlyReport extends HalRepresentation {
	private String title;
	private int year;
	private int month;
	private User user;
	private int workdays;
	private int lunchTickets;
	private List<UserDailyReport> dailyreports;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getWorkdays() {
		return workdays;
	}

	public void setWorkdays(int workdays) {
		this.workdays = workdays;
	}

	public int getLunchTickets() {
		return lunchTickets;
	}

	public void setLunchTickets(int lunchTickets) {
		this.lunchTickets = lunchTickets;
	}

	public List<UserDailyReport> getDailyreports() {
		return dailyreports;
	}

	public void setDailyreports(List<UserDailyReport> dailyreports) {
		this.dailyreports = dailyreports;
	}

}
