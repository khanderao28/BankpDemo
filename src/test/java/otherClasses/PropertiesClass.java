package otherClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {
	FileInputStream fis;
	Properties prop;
	 public PropertiesClass()  {
		 
		 prop=new Properties();
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resorcesFiles\\data.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//String browserName=System.getProperty("browser");
		
		
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	 public String getusername() {
		 
		 String username=prop.getProperty("username");
		 return username;
		 
		
	}
 public String getpassword() {
		 
		 String username=prop.getProperty("password");
		 return username;
		 
		
	}

}
