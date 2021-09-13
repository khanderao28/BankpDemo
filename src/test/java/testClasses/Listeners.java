package testClasses;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import otherClasses.ExtentReporterNG;


public class Listeners extends Basic implements ITestListener {
	private static Logger log = (Logger) LogManager.getLogger(Basic.class.getName());
	static int k=0;
	 ExtentTest test;
	ExtentReports extent1=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public ExtentTest test1;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent1.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		ExtentTest test1=test;
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//extentTest.get().log(Status.PASS, "Test Passed");
	test.pass("Success");	
	System.out.println("success");
	log.info("Test Success" + " "+ result.getMethod().getMethodName()+" "+ ++k);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		test.fail("Failed");
	
		log.info(" Test failed"+ " "+ result.getMethod().getMethodName() +" "+ ++k);
		extentTest.get().fail(result.getThrowable());
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("d").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent1.flush();
	}

}


