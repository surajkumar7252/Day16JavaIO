package day16javaio.javaio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;



public class EmployeePayrollService {
	private static final Logger log = LogManager.getLogger(EmployeePayrollService.class);
	private List<EmployeePayrollData> employeePayrollList;
	
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}
	public EmployeePayrollService() {}
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}
	
	
	
    public static void main( String[] args )
    {
    	ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData();
       }

    public void readEmployeePayrollData(Scanner consoleInputReader) {
		log.info("Enter Employee ID : ");
		int id = consoleInputReader.nextInt();
		log.info("Enter Employee Name : ");
		String name = consoleInputReader.next();
		log.info("Enter Employee Salary : ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}
    public void writeEmployeePayrollData() {
			log.info("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
		}
	
}
