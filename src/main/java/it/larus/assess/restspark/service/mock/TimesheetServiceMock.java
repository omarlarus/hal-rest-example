package it.larus.assess.restspark.service.mock;

import java.util.ArrayList;
import java.util.List;

import it.larus.assess.restspark.domain.Timesheet;
import it.larus.assess.restspark.service.TimesheetService;

public class TimesheetServiceMock implements TimesheetService {

	@Override
	public List<Timesheet> getAll() {
		List<Timesheet> list = new ArrayList<>();
		list.add(new Timesheet("isaac.newton", 110));
		list.add(new Timesheet("galileo.galilei", 120));
		list.add(new Timesheet("albert.einstein", 130));
		return list;
	}

}
