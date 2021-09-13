package testClasses;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import otherClasses.Addcustomerdata;
import otherClasses.ExtentReporterNG;
import pageObjectClasses.Adduser;
import pageObjectClasses.LoginpagePOC;

public class TC01_AddUserTest extends Basic {

	WebDriver d = null;

	@BeforeClass
	public void init() {

		d = initialize();
		d.get(url);

		

		LoginpagePOC l = new LoginpagePOC(d);
		l.enterUserName(username);
		l.enterPassword(pass);
		l.login();
		l.NewUserRegistration();
	}

	@Test
	public void addUser() throws InterruptedException, IOException {
		//SoftAssert sa=new SoftAssert();
		String namem = Thread.currentThread().getStackTrace()[1].getMethodName();
		//Thread.sleep(2000);
		//ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
		ExtentTest test = extent.createTest(namem);
		String[] str = new String[5];
		String[] str1 = new String[6];
		Adduser user = new Adduser(d);
		
		SoftAssert sa=new SoftAssert();
		int l=0;
		for (int i = 0; i <= 1; i++) {
			str[0] = String.valueOf(i + 1);
			str1[0] = String.valueOf(i + 1);

			String username = username();
			str[1] = username;
			str1[1] = username;
			String address = address();
			String day = day();
			String month = month();
			String year = year();
			String mobile = mobile();
			String city = city();
			String state = state();
			String pin = pin();
			String email = email() + email2()+"@gamil.com";

			String pass = password();

			user.customername(username);
			int k = getRandomInteger();
			if (k == 1 || k == 3 || k == 5 || k == 7 || k == 9)
				user.selectMaleGender();
			else {
				user.selectFemaleGender();
			}
			user.DOB(day, month, year);
			user.addAddress(address);
			user.cityName(city);
			user.stateName(state);
			user.enterPin(pin);
			user.enterMobile(mobile);
			user.enterEmail(email);
			user.selectPassword(pass);
			str1[5] = pass;
			user.submit();
			Thread.sleep(2000);
			if(isAlertPresent())
			{
				ExtentReporterNG.Fail(test,str+" is failed" , getScreenShotPath(namem,d));
				System.out.println("User is not added");
				sa.assertTrue(false);
				d.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
			}else
			{
			
			/*
			 * File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE); String
			 * destinationFile = System.getProperty("user.dir") +
			 * "\\reports\\" + username + ".png";
			 * 
			 * try { FileHandler.copy(src, new File(destinationFile)); } catch (IOException
			 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
			 */
				sa.assertTrue(true);
			
				ExtentReporterNG.Pass(test, "User Added");
				
			str1[2] = mobile;
			str[2] = mobile;
			String Cid = d.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
			str[3] = Cid;
			str[4] = email;
			str1[3] = Cid;
			str1[4] = email;
			Addcustomerdata.exceldatac(i, str);
			Addcustomerdata.exceldatac1(i, str1);
			
			user.contin();
			d.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
			}
		}
		sa.assertAll();
		
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
	}   // isAlertPresent()

	public String username() {
		String user = RandomStringUtils.randomAlphabetic(8);
		return user;
	}

	public String address() {
		String user = RandomStringUtils.randomAlphabetic(15);
		return user;
	}

	public String city() {
		String user = RandomStringUtils.randomAlphabetic(5);
		return user;
	}

	public String state() {
		String user = RandomStringUtils.randomAlphabetic(5);
		return user;
	}

	public String pin() {
		String user = RandomStringUtils.randomNumeric(6);
		return user;
	}

	
	public String email() {
		int i = ThreadLocalRandom.current().nextInt(50000, 55555555);
		String user = String.valueOf(i);
		return user;
	}

	public String mobile() {
		String user = RandomStringUtils.randomNumeric(10);
		return user;
	}

	public String password() {
		String user = RandomStringUtils.randomAlphanumeric(10);
		return user;
	}
	public String email2() {
		String user = RandomStringUtils.randomAlphanumeric(getRandomInteger());
		return user;
	}

	public static int getRandomInteger() {
		return ThreadLocalRandom.current().nextInt(1, 9);
	}

	public String day() {
		int i = ThreadLocalRandom.current().nextInt(1, 30);
		String user = String.valueOf(i);
		return user;
	}

	public String month() {
		int i = ThreadLocalRandom.current().nextInt(1, 12);
		String user = String.valueOf(i);
		return user;
	}

	public String year() {
		int i = ThreadLocalRandom.current().nextInt(2020, 2022);
		String user = String.valueOf(i);
		return user;
	}
}
