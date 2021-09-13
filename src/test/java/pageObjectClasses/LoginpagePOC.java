package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpagePOC {
	
	WebDriver d;
	public LoginpagePOC(WebDriver d1) {
		// TODO Auto-generated constructor stub
		d=d1;
		PageFactory.initElements(d1, this);
		
	}
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement NewCustomer;
	public void NewUserRegistration() {
		NewCustomer.click();}
	
	@FindBy(xpath="//a[contains(text(),'Change Password')]")
	WebElement ChangePassword;
	public void ChangePassword() {
		ChangePassword.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Delete Account')]")
	WebElement DeleteAccount;
	public void DeleteAccount() {
		DeleteAccount.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Deposit')]")
	WebElement Deposit;
	public void Deposit() {
		Deposit.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Withdrawal')]")
	WebElement Withdrawal;
	public void Withdrawal() {
		Withdrawal.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Fund Transfer')]")
	WebElement FundTransfer;
	public void FundTransfer() {
		FundTransfer.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Mini Statement')]")
	WebElement MiniStatement;
	public void MiniStatement() {
		MiniStatement.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Balance Enquiry')]")
	WebElement BalanceEnquiry;
	public void BalanceEnquiry() {
		BalanceEnquiry.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Customised Statement')]")
	WebElement CustomisedStatement;
	public void CustomisedStatement() {
		CustomisedStatement.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Edit Account')]")
	WebElement EditAccount;
	public void EditAccount() {
		EditAccount.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	WebElement EditCustomer;
	public void EditCustomer() {
		EditCustomer.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Delete Customer')]")
	WebElement DeleteCustomer;
	public void DeleteCustomer() {
		DeleteCustomer.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'New Account')]")
	WebElement NewAccount;
	public void NewAccount() {
		NewAccount.click();
	}
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement login;
	
	
	
	public void enterUserName(String str) {
		username.sendKeys(str);
	}
	public void enterPassword(String str) {
		password.sendKeys(str);
	}
	public void login() {
		login.click();
	}
	
	

}
