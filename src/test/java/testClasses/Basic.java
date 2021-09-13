package testClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import otherClasses.PropertiesClass;

public class Basic  {
	WebDriver d;
	PropertiesClass datac=new PropertiesClass();
	public String url="http://demo.guru99.com/V4/index.php";
	public String username=datac.getusername();
	public String pass=datac.getpassword();
	static ExtentReports extent;
	
	
	@BeforeTest
	public  void getReportObject()
	{
		
		String time =new SimpleDateFormat("HH.mm.ss_dd-MM-yyy").format(new Date());
		String rname=" Report-"+time+".html";
		String path =System.getProperty("user.dir")+"\\reports\\"+rname;
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		
		 extent =new ExtentReports();
		 
		extent.attachReporter(reporter);
	
		extent.setSystemInfo("Tester", "Thorat");
		
	}
	
	
	@AfterTest
	public void end()
	{
		extent.flush();
	}
	
	public WebDriver initialize()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
				d = new ChromeDriver(options);
				d.manage().window().maximize();
				d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return d;
	}
	
	@AfterClass
	public void tearDown() {
		
		d.quit();
		
	}
	
	
	public String getScreenShotPath(String testCaseName,WebDriver d) throws IOException
	{
		File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		//FileUtils.copyFile(source,new File(destinationFile));
		FileHandler.copy(src,new File(destinationFile));
		return destinationFile;


	}

}
