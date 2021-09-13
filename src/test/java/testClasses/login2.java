
	package testClasses;

	import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
	import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.core.Logger;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

	import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import otherClasses.ExtentReporterNG;
	import pageObjectClasses.LoginpagePOC;
	public class login2 extends Basic {
		WebDriver d = null;
		String path = null;
		//Listeners l=new Listeners();
		
		private static Logger log = (Logger) LogManager.getLogger(Basic.class.getName());
		ExtentTest test;
		//ExtentReports extent=ExtentReporterNG.getReportObject();
		//ExtentTest 
		@BeforeClass
		public void init() {
			
			d = initialize();
		}

		
		
		
		
		@Test
		public void login() throws InterruptedException {
			SoftAssert sa=new SoftAssert();
		 String str=Thread.currentThread().getStackTrace()[1].getMethodName();
		    
			test= extent.createTest(str);
			
			/*
			  String methodNameUsingClassInstance =
            new TestGetMethodName() {}.getClass().getEnclosingMethod().getName();
        System.out.println("Current Method Execution Name Using Class Instance - " +
            methodNameUsingClassInstance); 
			  */
			//String str=currentc
		//	test= extent.createTest("");
			//ExtentTest test=l.test1;
			d.get(url);
			System.out.println(d.getTitle());
			
			if(d.getTitle().equals("Guru99 Bank Home Page"))
			{
			//test.log( Status.PASS, "Navigated to the specified URL");
			ExtentReporterNG.Pass(test, "Navigated to the specified URL");
			}else {		
				
				try {
					path = getScreenShotPath(str, d);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExtentReporterNG.Fail(test, "Not Navigated to URL",path);
				AssertJUnit.assertTrue(false);
			}

			
			LoginpagePOC l = new LoginpagePOC(d);
			l.enterUserName(username);
			//test.log(Status.INFO, "username enter");
			ExtentReporterNG.Info(test, "Username entered");
		//	log.info("username entered");
			l.enterPassword(pass);
			ExtentReporterNG.Info(test, "password entered");
		//	test.log(Status.INFO, pass);
		//	log.info("password entered");
			l.login();
		//	log.info("login Clicked");
			System.out.println(d.getTitle() );
			if (d.getTitle().equals("Guru99 Bank Manager HomePage")) {
		//		log.info("Test passsed");
				AssertJUnit.assertTrue(true);
				//test.log(Status.PASS, "Login Success");
				ExtentReporterNG.Pass(test, "login Success");
			} else {
		//		log.info("Test Fail");
				try {
					path = getScreenShotPath(str, d);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				AssertJUnit.assertTrue(false);
				test.log(Status.FAIL, "Login Success");
			}
			System.out.println("hello");
			sa.assertAll();
		}
	}



