package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	
	public static ExtentReports generateReport() {
	
	ExtentSparkReporter htmlReport = new ExtentSparkReporter("ProjectReport.html") ;
	ExtentReports reports = new ExtentReports();
	reports.attachReporter(htmlReport);
	reports.setSystemInfo("suite", "Regression");
	reports.setSystemInfo("TestBy", "Asmita");
	return reports;
	}
}
