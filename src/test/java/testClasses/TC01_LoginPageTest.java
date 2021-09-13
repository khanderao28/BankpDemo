package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import otherClasses.ExtentReporterNG;
import pageObjectClasses.LoginpagePOC;

public class TC01_LoginPageTest extends Basic {
	WebDriver d = null;
	String path = null;
	// Listeners l=new Listeners();

	private static Logger log = (Logger) LogManager.getLogger(Basic.class.getName());
	ExtentTest test;

	// ExtentReports extent=ExtentReporterNG.getReportObject();
	// ExtentTest
	@BeforeClass
	public void init() {

		d = initialize();
	}

	@Test
	public void loginuser() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		String str = Thread.currentThread().getStackTrace()[1].getMethodName();

		test = extent.createTest(str);

		d.get(url);
		System.out.println(d.getTitle());

		if (d.getTitle().equals("Guru99 Bank Home Page1")) {
			
			ExtentReporterNG.Pass(test, "Navigated to the specified URL");
		} else {

			try {
				path = getScreenShotPath(str, d);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			ExtentReporterNG.Fail(test, "Not Navigated to URL", path);
			AssertJUnit.assertTrue(false);
		}
		LoginpagePOC l = new LoginpagePOC(d);
		l.enterUserName(username);
		
		ExtentReporterNG.Info(test, "Username entered");
		
		l.enterPassword(pass);
		ExtentReporterNG.Info(test, "password entered");
		
		l.login();
		
		System.out.println(d.getTitle());
		if (d.getTitle().equals("Guru99 Bank Manager HomePage")) {
			// log.info("Test passsed");
			AssertJUnit.assertTrue(true);
			// test.log(Status.PASS, "Login Success");
			ExtentReporterNG.Pass(test, "login Success");
		} else {
			// log.info("Test Fail");
			try {
				path = getScreenShotPath(str, d);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AssertJUnit.assertTrue(false);
			// test.log(Status.FAIL, "Login Success");
			ExtentReporterNG.Fail(test, "Not Success", path);
		}
		System.out.println("hello");
		sa.assertAll();
	}
}
