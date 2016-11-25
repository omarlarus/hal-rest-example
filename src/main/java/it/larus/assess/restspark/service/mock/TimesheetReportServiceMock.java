package it.larus.assess.restspark.service.mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import it.larus.assess.restspark.domain.User;
import it.larus.assess.restspark.representation.AllUserMonthlyReport;
import it.larus.assess.restspark.representation.AllUserYearlyReport;
import it.larus.assess.restspark.representation.UserDailyReport;
import it.larus.assess.restspark.representation.UserMonthlyReport;
import it.larus.assess.restspark.service.TimesheetReportService;

public class TimesheetReportServiceMock implements TimesheetReportService {

	@Override
	public AllUserYearlyReport getAllUserYearlyReport(int year) {
		AllUserYearlyReport report = new AllUserYearlyReport();
		report.setTitle("Timesheet Yearly Report "+year);
		report.setYear(year);
		report.setMonthlyreports(new ArrayList<>());
		
		report.getMonthlyreports().add(getAllUserMonthlyReport(year, 11));
		
		return report;
	}

	@Override
	public AllUserMonthlyReport getAllUserMonthlyReport(int year, int month) {
		AllUserMonthlyReport report = new AllUserMonthlyReport();
		report.setTitle("Timesheet Monthly Report "+year+"/"+month);
		report.setYear(year);		
		report.setMonth(month);
		report.setUserreports(new ArrayList<>());
		return report;
	}

	@Override
	public UserMonthlyReport getUserMonthlyReport(int year, int month, long userId) {
		UserMonthlyReport report = new UserMonthlyReport();
		
		
		User user = new User();
		user.setId(userId);
		user.setRealname("Omar Rampado");
		
		report.setTitle("Timesheet Monthly Report "+year+"/"+month+" - "+user.getRealname());
		report.setYear(year);
		report.setMonth(month);
		report.setLunchTickets(2);
		report.setWorkdays(3);
		report.setDailyreports(new ArrayList<>());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			UserDailyReport day = new UserDailyReport();
			day.setDay(format.parse("2016/11/01"));
			day.setWorkHours(8);
			day.setPermitHours(0);
			day.setLunchTickets(1);
			report.getDailyreports().add(day);
			
			day = new UserDailyReport();
			day.setDay(format.parse("2016/11/02"));
			day.setWorkHours(5);
			day.setPermitHours(3);
			day.setLunchTickets(1);
			report.getDailyreports().add(day);
			
			day = new UserDailyReport();
			day.setDay(format.parse("2016/11/03"));
			day.setWorkHours(4);
			day.setPermitHours(4);
			day.setLunchTickets(0);
			report.getDailyreports().add(day);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return report;
	}

}
