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

public class TC01_FundTransferTest extends Basic{
	
	WebDriver d = null;

	@BeforeClass
	public void init() throws InterruptedException {

		d = initialize();
		d.get(url);

		
		LoginpagePOC l = new LoginpagePOC(d);
		l.enterUserName(username);
		l.enterPassword(pass);
		l.login();
		l.FundTransfer();
		//l.newAccount();/html/body/div[3]/div/ul/li[5]

	}
	
	
	@Test()
	public void fundTransfer() throws IOException, InterruptedException {
		//d.findElement(By.xpath("//a[contains(text(),'Fund Transfer')]")).click();
		int k=getRandomInteger1();
		String str=Newaccount.deleteaccount(k);
		int k2;
		String str2;
		do {
		 k2=getRandomInteger1();
		 str2=Newaccount.deleteaccount(k2);}while(k==k2);
		System.out.println(k+" "+k2);
		String str4=ammount();
		System.out.println("Payer is" + str);
		System.out.println("Payee is" + str2);
		System.out.println("widraw account is- "+str4);
		//System.out.println("Ammount Added -"+str1);
		d.findElement(By.name("payersaccount")).sendKeys(str);
		d.findElement(By.name("payeeaccount")).sendKeys(str2);

		d.findElement(By.name("ammount")).sendKeys(str4);
		d.findElement(By.name("desc")).sendKeys("xyz");
		d.findElement(By.name("AccSubmit")).click();
		Thread.sleep(5000);
		if(isAlertPresent())
		{
			System.out.println("Balance is low ");
		}
		else
		{
			Newaccount.Payer(str, str4);
			Newaccount.Payee(str2, str4);
			d.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[5]/td/p/a")).click();
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
		int i = ThreadLocalRandom.current().nextInt(40000,100000);
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
