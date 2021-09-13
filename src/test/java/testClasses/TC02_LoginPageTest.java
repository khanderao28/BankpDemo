package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import jdk.internal.org.jline.utils.Log;
import otherClasses.ExtentReporterNG;
import otherClasses.KDFlogin;
import pageObjectClasses.LoginpagePOC;

public class TC02_LoginPageTest extends Basic {

	WebDriver d;
	//String path=null;
//	static int k = 1;
//	private static Logger log = (Logger) LogManager.getLogger(Basic.class.getName());

	@BeforeClass
	public void init() {

		d = initialize();
		d.get(url);

		}

	@Test(dataProvider = "LoginData")
	public void loginTest(String str1, String str2) throws InterruptedException, IOException {
		SoftAssert sa=new SoftAssert();
		String str = Thread.currentThread().getStackTrace()[1].getMethodName();
		//Thread.sleep(2000);
		ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
		ExtentTest test = extent.createTest(str);
		extentTest.set(test);
		LoginpagePOC l = new LoginpagePOC(d);
		l.enterUserName(str1);
		l.enterPassword(str2);
		l.login();
		// System.out.println(d.getTitle());
		String	path = null;
		if(isAlertPresent())
		{	
			String path1=getScreenShotPath(str,d);
			//String abc=d.switchTo().alert().getText().toString();
			//d.switchTo().defaultContent();
			//test.fail("failed".toUpperCase());
		//extentTest.get().addScreenCaptureFromPath(getScreenShotPath(str,d), str);
		//extentTest.get().fail("Failed Screenshot".toUpperCase(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenShotPath(str,d)).build());
		ExtentReporterNG.Fail1(extentTest,str +" is failed" , getScreenShotPath(str,d));
		//String abc=d.switchTo().alert().getText().toString();
		//System.out.println(abc);
		//test.fail(abc);
		/*try {
				path = getScreenShotPath(str, d);
			} catch (IOException e) {abc
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i=0;i<500000;i++)
			{
				System.out.print(" ");
			}
		//Thread.sleep(2000);
			String abc=d.switchTo().alert().getText();
			//Thread.sleep(2000);
			for(int i=0;i<500000;i++)
			{
				System.out.print(" ");
			}
			ExtentReporterNG.Fail(test, abc , path);
			for(int i=0;i<500000;i++)
			{
				System.out.print(" ");
			}
			//Thread.sleep(2000);*/
			sa.assertTrue(false);
			//Assert.assertTrue(false);

			d.switchTo().alert().accept();
			d.switchTo().defaultContent();
		}else
		{
			//ExtentReporterNG.Pass(test, "login Success");
			ExtentReporterNG.Pass1(extentTest, "login Success");
			sa.assertTrue(true);
		//	log.info("Test Passed" + ++k);
			d.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
			d.switchTo().alert().accept();
			d.switchTo().defaultContent();

		}
		//if (d.getTitle().equals("Guru99 Bank Manager HomePage")) {
			//		} else {//Thread.sleep(2000)}
		//Thread.sleep(5000);
		sa.assertAll();
	}

	@DataProvider(name = "LoginData")
	public Object[][] getData() throws IOException {

		Object[][] data = new Object[5][2];
		for (int i = 0; i < 5; i++) {
			String[] userdata = KDFlogin.exceldata(i);

			data[i][0] = userdata[0];
			data[i][1] = userdata[1];
		}
		/*
		 * data[0][0]="mngr351739"; data[0][1]="uvenAvy"; data[1][0]="jsdhja";
		 * data[1][1]="dfzxd"; data[2][0]="mngr351739"; data[2][1]="dccasd";
		 * data[3][0]="mngr351739"; data[3][1]="uvenAvy"; data[4][0]="dadadawa";
		 * data[4][1]="uvenAvy";
		 */
		return data;

	}
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 	System.out.println(d.switchTo().alert().getText());
	        d.switchTo().alert().accept();
	        System.out.println();
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}   

}
