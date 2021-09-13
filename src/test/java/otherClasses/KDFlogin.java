package otherClasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class KDFlogin {

	@Test
	public static String[] exceldata(int j) throws IOException {

		Sheet sheet = null;
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("logindata")) {
		//		System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet = workbook.getSheetAt(i);
				break;
			}
		}
		int k = 0;
		
		String[] strAr = new String[2];

		String username = sheet.getRow(j + 1).getCell(k).toString();
		String password = sheet.getRow(j + 1).getCell(k + 1).toString();
			
		strAr[0] = username;
		strAr[1] = password;
	

		return strAr;

	}
}
