package testClasses;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import otherClasses.Newaccount;
import pageObjectClasses.LoginpagePOC;

public class TC01_DeleteAccountTest extends Basic {

	
	WebDriver d = null;

	@BeforeClass
	public void init() throws InterruptedException {

		d = initialize();
		d.get(url);

		
		LoginpagePOC l = new LoginpagePOC(d);
		l.enterUserName(username);
		l.enterPassword(pass);
		l.login();
		l.DeleteAccount();
		//d.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();
		//l.newAccount();

	}
	
	
	@Test
	public void deleteAccount() throws IOException, InterruptedException {
		int k=getRandomInteger1();
		String str=Newaccount.deleteaccount(k);
		System.out.println("Deleted account is- "+str);
		d.findElement(By.xpath("//tbody/tr[6]/td[2]/input[1]")).sendKeys(str);
		d.findElement(By.xpath("//tbody/tr[11]/td[2]/input[1]")).click();
		Newaccount.deleterow(str);
		Newaccount.writeData1();
		d.switchTo().alert().accept();
		//d.switchTo().defaultContent();
		d.switchTo().alert().accept();
		//d.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
	}
	
	
	public static int getRandomInteger1() throws IOException {
		int k1 = Newaccount.getNumberofRows();
		return ThreadLocalRandom.current().nextInt(getRandomInteger2(), k1);
	}
	public static int getRandomInteger2() throws IOException {
		int k1 = Newaccount.getNumberofRows();
		return ThreadLocalRandom.current().nextInt(2, k1);
	}
}
