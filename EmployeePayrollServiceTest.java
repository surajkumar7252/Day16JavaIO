package day16javaio.javaio;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;


import day16javaio.javaio.EmployeePayrollService.IOService;
public class EmployeePayrollServiceTest {
	
	private static final Logger log = LogManager.getLogger(EmployeePayrollServiceTest.class);

	@Test
	public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = {new EmployeePayrollData(1, "Jeff Bezos", 10000.0),
				new EmployeePayrollData(2, "Bill Gates", 15000.0),
				new EmployeePayrollData(3, "Dan Bilzerian", 10500.0)};
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(FILE_IO);
		employeePayrollService.printData(FILE_IO);
		long entries = employeePayrollService.countEntries(FILE_IO);
		Assert.assertEquals(3, entries);
	}

	@Test
	public void givenFileOnReadingFromFileShouldMatchEmployeeCount() {
		EmployeePayrollService employeePayrollService=new EmployeePayrollService();
		long entries=employeePayrollService.readEmployeePayrollData(FILE_IO);
		Assert.assertEquals(3, entries);
	}

}
