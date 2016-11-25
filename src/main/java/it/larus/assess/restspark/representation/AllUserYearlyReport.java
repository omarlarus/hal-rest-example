package it.larus.assess.restspark.representation;

import java.util.List;

/*
		{
			title: "Rapportini 2016",
			year: 2016,
			monthlyreports:[
				{
					title: "Rapportini Ottobre 2016",
					year: 2016,
					month: 10,
					_links: {
						self: {href: "/report/user/all/timesheet/2016/10"}
					}
				},
				{
					title: "Rapportini Novembre 2016",
					year: 2016,
					month: 11,
					_links: {
						self: {href: "/report/user/all/timesheet/2016/11"}
					}
				},...
			]				
		}
 */
public class AllUserYearlyReport extends HalRepresentation {
	private String title;
	private int year;
	private List<AllUserMonthlyReport> monthlyreports;

	public List<AllUserMonthlyReport> getMonthlyreports() {
		return monthlyreports;
	}

	public void setMonthlyreports(List<AllUserMonthlyReport> monthlyreports) {
		this.monthlyreports = monthlyreports;
	}

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

}
