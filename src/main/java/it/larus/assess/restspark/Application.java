package it.larus.assess.restspark;

import static spark.Spark.get;
import static spark.Spark.port;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.eclipse.jetty.http.HttpStatus;

import it.larus.assess.restspark.representation.AllUserMonthlyReport;
import it.larus.assess.restspark.representation.AllUserYearlyReport;
import it.larus.assess.restspark.representation.UserMonthlyReport;
import it.larus.assess.restspark.service.TimesheetReportService;
import it.larus.assess.restspark.service.TimesheetService;
import it.larus.assess.restspark.service.mock.TimesheetReportServiceMock;
import it.larus.assess.restspark.service.mock.TimesheetServiceMock;
import it.larus.assess.restspark.transformer.JsonTransformer;
import spark.Response;

/**
 * mvn exec:java -Dexec.mainClass="it.larus.assess.restspark.Application"
 * @author omar
 *
 */
public class Application {
	
	public static void main(String[] args) throws JAXBException {
		/*
		 * Configuration
		 */
		port(8080);
		
		TimesheetService timesheetService = new TimesheetServiceMock();
		TimesheetReportService reportService = new TimesheetReportServiceMock();
		
		/*
		 * URIs 
		 */
		
		spark.Spark.get("/info", (req, res) -> "Timesheet manager");
		
		get("/timesheet", "application/json", (request, response) -> {
			response.type("application/json");
		    return timesheetService.getAll();
		}, new JsonTransformer());


		get("/report/user/all/timesheet/:year", "application/json", (request, response) -> {
			response.type("application/hal+json");
			int year;
			String yearParam = request.params(":year");
			try
			{
				year = Integer.parseInt(yearParam);				
			}catch(NumberFormatException e)
			{
				return handleNumberError(response, yearParam);
			}

			AllUserYearlyReport report = reportService.getAllUserYearlyReport(year);
			report.addLink("self", request.uri());
			
			report.getMonthlyreports().forEach(r -> r.addLink("self", "/report/user/all/timesheet/"+r.getYear()+"/"+r.getMonth()));
			
			return report;
			
		}, new JsonTransformer());
		
		get("/report/user/all/timesheet/:year/:month", "application/json", (request, response) -> {
			response.type("application/hal+json");

			int year;
			int month;
			String valueParam = request.params(":year");
			try
			{
				year = Integer.parseInt(valueParam);		
				valueParam = request.params(":month");
				month = Integer.parseInt(valueParam);	
			}catch(NumberFormatException e)
			{
				return handleNumberError(response, valueParam);
			}
	
			
			AllUserMonthlyReport report = reportService.getAllUserMonthlyReport(year,month);
			report.addLink("self", request.uri());
			report.getUserreports().forEach(r -> r.addLink("self", "/report/user/"+r.getUser().getId()+"/timesheet/"+r.getYear()+"/"+r.getMonth()));
			
			return report;
		}, new JsonTransformer());
		
		get("/report/user/:userId/timesheet/:year/:month", "application/json", (request, response) -> {
			response.type("application/hal+json");
			int year;
			int month;
			long userId;
			String valueParam = request.params(":year");
			try
			{
				year = Integer.parseInt(valueParam);		
				valueParam = request.params(":month");
				month = Integer.parseInt(valueParam);	
				valueParam = request.params(":userId");
				userId = Long.parseLong(valueParam);			
			}catch(NumberFormatException e)
			{
				return handleNumberError(response, valueParam);
			}
			
			UserMonthlyReport report = reportService.getUserMonthlyReport(year, month, userId);
			report.addLink("self", request.uri());
			
			return report;
		}, new JsonTransformer());
		
	}

	/**
	 * Set response status when a param is not a number
	 * @param response
	 * @param paramValue
	 * @return
	 */
	private static Object handleNumberError(Response response, String paramValue) {
		response.status(HttpStatus.BAD_REQUEST_400);
		Map<String, String> message = new HashMap<>();
		message.put("errorType",  "invalid input");
		message.put("errorMessage", paramValue +" must be a number");
		return message;
	}

}
