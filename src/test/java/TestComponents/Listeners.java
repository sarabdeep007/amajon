package TestComponents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentNGReports;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentNGReports.getExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	Logger logger = (Logger)LogManager.getLogger();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.get().getStatus();
		  extentTest.get().log(Status.PASS, "Test Pass aa baai");
		  logger.info("morcha maar lya test pass karta");
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	 
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver =  (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String screenshotPath = null;
		
		screenshotPath = getScreenShot(result.getMethod().getMethodName(), driver);
		
		extentTest.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
		
		
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 extent.flush();
	}

}
