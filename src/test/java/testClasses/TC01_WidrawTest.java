package testClasses;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import otherClasses.Newaccount;
import pageObjectClasses.LoginpagePOC;

public class TC01_WidrawTest extends Basic {
	
	
	WebDriver d = null;

	@BeforeClass
	public void init() throws InterruptedException {

		d = initialize();
		d.get(url);

		
		LoginpagePOC l = new LoginpagePOC(d);
		l.enterUserName(username);
		l.enterPassword(pass);
		l.login();
		l.Withdrawal();
		//l.newAccount();/html/body/div[3]/div/ul/li[5]

	}
	
	
	@Test()
	public void depositAccount() throws IOException, InterruptedException {
		//d.findElement(By.xpath("//a[contains(text(),'Withdrawal')]")).click();
		int k=getRandomInteger1();
		String str=Newaccount.deleteaccount(k);
		String str1=ammount();
		System.out.println("widraw account is- "+str1);
		//System.out.println("Ammount Added -"+str1);
		d.findElement(By.name("accountno")).sendKeys(str);
		d.findElement(By.name("ammount")).sendKeys(str1);
		d.findElement(By.name("desc")).sendKeys("xyz");
		d.findElement(By.name("AccSubmit")).click();
		if(isAlertPresent())
		{
			System.out.println("Balance is low ");
		}
		else
		{
		String str3=d.findElement(By.xpath("//*[@id=\"withdraw\"]/tbody/tr[23]/td[2]")).getText();
		Newaccount.AddDepositORWidrow(str, str3);
		//Newaccount.writeData1();
		d.findElement(By.xpath("//*[@id=\"withdraw\"]/tbody/tr[24]/td/a")).click();
		}
		Thread.sleep(2000);
		
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
	
	public String ammount() {
		int i = ThreadLocalRandom.current().nextInt(10000,75000 );
		String user = String.valueOf(i);
		return user;
	}
	public static int getRandomInteger1() throws IOException {
		int k1 = Newaccount.getNumberofRows();
		return ThreadLocalRandom.current().nextInt(getRandomInteger2(), k1);
	}
	public static int getRandomInteger2() throws IOException {
		int k1 = Newaccount.getNumberofRows();
		return ThreadLocalRandom.current().nextInt(1, k1);
	}

}
