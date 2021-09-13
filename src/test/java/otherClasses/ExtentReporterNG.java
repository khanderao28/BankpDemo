package otherClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.record.common.ExtendedColor;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	 static ExtentReports extent1;
	public static  ExtentReports getReportObject()
	{
		
		String time =new SimpleDateFormat("HH.mm.ss.dd-MM-yyy").format(new Date());
		String rname=" Report-"+time+".html";
		String path =System.getProperty("user.dir")+"\\reports\\"+rname;
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		  extent1 = new ExtentReports();
		extent1.attachReporter(reporter);
		extent1.setSystemInfo("Tester", "Thorat");
		return extent1;
		
	}
		public static void Pass(ExtentTest test,String msg) {
			test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		}
		public static void Pass1(ThreadLocal<ExtentTest> test,String msg) {
			test.get().log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		}
		public static void Info(ExtentTest test,String msg) {
			test.log(Status.INFO, MarkupHelper.createLabel(msg, ExtentColor.GREY));
		}
		public static void Fail(ExtentTest test,String msg, String path) {
			test.log(Status.FAIL, MarkupHelper.createLabel(msg.toUpperCase(), ExtentColor.RED));
			test.fail("Failed Screenshot".toUpperCase(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		}
		public static void Fail1(ThreadLocal<ExtentTest> test,String msg, String path) {
			test.get().log(Status.FAIL, MarkupHelper.createLabel(msg.toUpperCase(), ExtentColor.RED));
			test.get().fail("Failed Screenshot".toUpperCase(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		}
}
