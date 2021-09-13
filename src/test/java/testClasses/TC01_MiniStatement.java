package testClasses;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import otherClasses.Newaccount;
import pageObjectClasses.LoginpagePOC;

public class TC01_MiniStatement extends Basic {

	
	WebDriver d = null;

	@BeforeClass
	public void init() throws InterruptedException {

		d = initialize();
		d.get(url);

		
		LoginpagePOC l = new LoginpagePOC(d);
		l.enterUserName(username);
		l.enterPassword(pass);
		l.login();
		l.MiniStatement();
		//l.newAccount();/html/body/div[3]/div/ul/li[5]

	}
	
	
	@Test()
	public void depositAccount() throws IOException, InterruptedException {
		//d.findElement(By.xpath("//a[contains(text(),'Withdrawal')]")).click();
		int k=getRandomInteger1();
		String str=Newaccount.deleteaccount(k);
	
		d.findElement(By.name("accountno")).sendKeys(str);
		
		d.findElement(By.name("AccSubmit")).click();
		if(isAlertPresent())
		{
			System.out.println("Account not found");
		}
		else
		{
		
			File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE); String
			  destinationFile = System.getProperty("user.dir") +
			  "\\reports\\" + str +" MiniStatement" +".png";
			  
			  try {org.openqa.selenium.io.FileHandler.copy(src, new File(destinationFile)); } catch (IOException
			  e) { // TODO Auto-generated catch block e.printStackTrace();
				  
			  }
			  
			  d.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		}
		
	}
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        d.switchTo().alert().accept();; 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}   // isAlertPresent()
	
	
	public static int getRandomInteger1() throws IOException {
		int k1 = Newaccount.getNumberofRows();
		return ThreadLocalRandom.current().nextInt(getRandomInteger2(), k1);
	}
	public static int getRandomInteger2() throws IOException {
		int k1 = Newaccount.getNumberofRows();
		return ThreadLocalRandom.current().nextInt(1, k1);
	}

	
	
}
