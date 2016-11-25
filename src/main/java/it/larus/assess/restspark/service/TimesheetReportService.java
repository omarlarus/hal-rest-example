package it.larus.assess.restspark.service;

import it.larus.assess.restspark.representation.AllUserMonthlyReport;
import it.larus.assess.restspark.representation.AllUserYearlyReport;
import it.larus.assess.restspark.representation.UserMonthlyReport;

/**
 * Report of timesheet
 * Use representation package and timesheetservice
 * @author omar
 *
 */
public interface TimesheetReportService {

	/**
	 * Yearly timesheet report of all users
	 * @param year
	 * @return
	 */
	AllUserYearlyReport getAllUserYearlyReport(int year);
	
	/**
	 * Monthly timesheet report of all users 
	 * @param year
	 * @param month
	 * @return
	 */
	AllUserMonthlyReport getAllUserMonthlyReport(int year, int month);
	
	/**
	 * Monthly timesheet report of specific user
	 * @param year
	 * @param month
	 * @param userId
	 * @return
	 */
	UserMonthlyReport getUserMonthlyReport(int year, int month, long userId); 
}
