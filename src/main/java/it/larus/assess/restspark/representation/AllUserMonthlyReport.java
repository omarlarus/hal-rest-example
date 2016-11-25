package it.larus.assess.restspark.representation;

import java.util.List;

/*
	{
		title: "Rapportini Novembre 2016",
		year: 2016,
		month: 11,
		_links: {
			self: {href: "/report/user/all/timesheet/2016/11"}
		}
		userreports:[
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
			}
		]
	}
 */
public class AllUserMonthlyReport extends HalRepresentation {

	private String title;
	private int year;
	private int month;
	private List<UserMonthlyReport> userreports;

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

	public List<UserMonthlyReport> getUserreports() {
		return userreports;
	}

	public void setUserreports(List<UserMonthlyReport> userreports) {
		this.userreports = userreports;
	}

}
