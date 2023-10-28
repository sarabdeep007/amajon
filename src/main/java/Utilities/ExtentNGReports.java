package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentNGReports {
	
	public static ExtentReports getExtentReports()
	{
		String extentReportPath = System.getProperty("user.dir")+"/extentReports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("Amazon Test Report");
		reporter.config().setDocumentTitle("Amazon Testing");
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		
		return extentReports;
		
		
		
	}

}
