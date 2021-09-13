package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adduser {
	WebDriver d;
	public Adduser(WebDriver d1) {
		// TODO Auto-generated constructor stub
		d=d1;
		PageFactory.initElements(d1, this);
	}
	
	@FindBy(xpath="//tbody/tr[4]/td[2]/input[1]")
	WebElement cname;
	@FindBy(xpath="//tbody/tr[5]/td[2]/input[1]")
	WebElement male;
	@FindBy(xpath="//tbody/tr[5]/td[2]/input[2]")
	WebElement female;
	@FindBy(xpath="//input[@id='dob']")
	WebElement dob;
	@FindBy(xpath="//tbody/tr[7]/td[2]/textarea[1]")
	WebElement add;
	@FindBy(xpath="//tbody/tr[8]/td[2]/input[1]")
	WebElement city;
	@FindBy(xpath="//tbody/tr[9]/td[2]/input[1]")
	WebElement state;
	@FindBy(xpath="//tbody/tr[10]/td[2]/input[1]")
	WebElement pin;
	@FindBy(xpath="//tbody/tr[11]/td[2]/input[1]")
	WebElement mobile;
	@FindBy(xpath="//tbody/tr[12]/td[2]/input[1]")
	WebElement email;
	@FindBy(xpath="//tbody/tr[13]/td[2]/input[1]")
	WebElement password;
	@FindBy(xpath="//tbody/tr[14]/td[2]/input[1]")
	WebElement submit;
	@FindBy(xpath="//tbody/tr[15]/td[2]/input[1]")
	WebElement reset;
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	WebElement conti;
	//tbody/tr[14]/td[2]/input[1]
	
	
	public void customername(String str) {
		cname.sendKeys(str);
		
	}
	public void selectMaleGender() {
		male.click();
		
	}
	public void selectFemaleGender() {
		female.click();
		
	}
	public void addAddress(String str) {
		add.sendKeys(str);
		
	}
	public void DOB(String str1,String str2,String str3) {
		dob.sendKeys(str1);
		dob.sendKeys(str2);
		dob.sendKeys(str3);
		
		
	}
	public void cityName(String str) {
		city.sendKeys(str);
		
	}
	public void stateName(String str) {
		state.sendKeys(str);
		
	}
	public void enterPin(String str) {
		if(str.length()>=6)
		{
		pin.sendKeys(str);
		}
		else
		{pin.sendKeys("000000");}
		
	}
	public void enterMobile(String str) {
		mobile.sendKeys(str);
		
	}
	public void enterEmail(String str) {
		email.sendKeys(str);
		
	}
	
	public void submit() {
		submit.click();
		
	}
	public void reset() {
		reset.click();
		
	}
	
	public void contin()
	{
		conti.click();
	}
	public void selectPassword(String pass) {
		// TODO Auto-generated method stub
		password.sendKeys(pass);
	}

}
