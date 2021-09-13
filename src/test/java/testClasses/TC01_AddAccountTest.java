package testClasses;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import otherClasses.Newaccount;
import pageObjectClasses.LoginpagePOC;
import pageObjectClasses.NewaccountPOC;

public class TC01_AddAccountTest extends Basic {

	WebDriver d = null;

	@BeforeClass
	public void init() throws InterruptedException {

		d = initialize();
		d.get(url);

				LoginpagePOC l = new LoginpagePOC(d);
		l.enterUserName(username);
		l.enterPassword(pass);
		l.login();

		l.NewAccount();

	}

	@Test
	public void AddCustomer() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		NewaccountPOC user1 = new NewaccountPOC(d);
		int k1 = Newaccount.getNumberofRows();
		int k2=Newaccount.getNumberofcolom();
		
		System.out.println(" " + k1 +" "+ (k1-2));
		String[] str1 = new String[k2];
		for (int i = k1-2; i < k1; i++) {
		String[]	str = Newaccount.readData(i);
			//String[] str = new String[str.length];
			for(int j=0;j<str.length;j++)
			{
				str1[j]=str[j];
			}
			/*str1[0] = str[0];
			str1[1] = str[1];
			str1[2] = str[2];
			str1[3] = str[3];
			str1[4] = str[4];*/
			user1.enterCustmerID(str1[3]);
			int k = TC01_AddUserTest.getRandomInteger();
			if (k == 1 || k == 3 || k == 5 || k == 7 || k == 9)
				user1.selectAccount("saving");
			else {
				user1.selectAccount("current");
			}
			user1.enterAmmount(ammount());
			user1.sumit();
			String AID = user1.AID();
			str1[5] = AID;

			String Ammount = user1.Ammount();
			str1[6] = Ammount;

			Newaccount.writeData(i, str1);
			// Thread.sleep(5000);
			user1.contin();
			user1.newAccount();
			System.out.println("success");
		}
	}

	public String ammount() {
		int i = ThreadLocalRandom.current().nextInt(5000, 99999);
		String user = String.valueOf(i);
		return user;
	}
}
