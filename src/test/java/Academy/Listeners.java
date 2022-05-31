package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.ExtentReporterNG;
import resource.base;

public class Listeners extends base implements ITestListener {
	
	public WebDriver driver;

     ExtentTest test;
	
	ExtentReports extent = ExtentReporterNG.getReportobject();
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) { 
		// TODO Auto-generated method stub
	  test = extent.createTest(result.getMethod().getMethodName()); 
	   
	  extentTest.set(test);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) { 
		// TODO Auto-generated method stub
		
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot
		extentTest.get().fail(result.getThrowable());
       
		WebDriver driver = null;
		String testmethodname = result.getMethod().getMethodName();
		
       
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch(Exception e)
			{
				
			}
		
		try {
			
			extentTest.get().addScreenCaptureFromPath(getscreenshotpath(testmethodname,driver),result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

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
