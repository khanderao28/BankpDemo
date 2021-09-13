package pageObjectClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
public class NewaccountPOC {
	WebDriver d;
	public NewaccountPOC(WebDriver d) {
		// TODO Auto-generated constructor stub
		this.d=d;
		PageFactory.initElements(d, this);	}
	
	@FindBy(xpath="//tbody/tr[2]/td[2]/input[1]")
	WebElement cid;
	@FindBy(name="selaccount")
	WebElement dd;
	
	
	@FindBy(xpath="//tbody/tr[4]/td[2]/input[1]")
	WebElement deposit;
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	WebElement conti;
	@FindBy(xpath="//a[contains(text(),'New Account')]")
	WebElement newAccount;
	@FindBy(xpath="//tbody/tr[4]/td[2]")
	WebElement aid;
	@FindBy(xpath="//tbody/tr[10]/td[2]")
	WebElement ammount;
	
	
	@FindBy(xpath="//tbody/tr[5]/td[2]/input[1]")
	WebElement submit;
	
	public void enterCustmerID(String str) {
		cid.sendKeys(str);
	}
	public void enterAmmount(String str) {
		deposit.sendKeys(str);
	}

	public void selectAccount(String str) {
		if(str.equals("saving"))
		{Select sd = new Select(dd);
			sd.selectByIndex(1);
		}
		else
		{Select sd = new Select(dd);
			sd.selectByIndex(0);
		}
	}
	public void sumit() {
		submit.click();
		
	}
	public void contin() {
		conti.click();
		
	}
	public void newAccount() {
		newAccount.click();
		
	}
	public String AID() {
	    String aid1=aid.getText();
	    return aid1;
		
	}
	public String Ammount() {
	    String aid1=ammount.getText();
	    return aid1;
		
	}
}
