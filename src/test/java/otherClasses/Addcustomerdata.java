package otherClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Addcustomerdata {

	@Test
	public static void exceldatac(int j, String[] str) throws IOException {

		Sheet sheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				//System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}
 int k=sheet1.getLastRowNum();
		XSSFRow row = (XSSFRow) sheet1.createRow(k + 1);
		for (int i = 0; i < str.length; i++) {
			if(i==0)
			{XSSFCell cell = row.createCell(i);
			cell.setCellValue(String.valueOf(k+1));}
			else {
			//System.out.println(str[i]);
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(str[i]);
			//System.out.println(cell.getStringCellValue());
			}
			
		}
		

		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		fis.close();
		fos.close();

	}
	
	public static void exceldatac1(int j, String[] str) throws IOException {

		Sheet sheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("dataofcust")) {
				//System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}
 int k=sheet1.getLastRowNum();
		XSSFRow row = (XSSFRow) sheet1.createRow(k + 1);
		for (int i = 0; i < str.length; i++) {
			if(i==0)
			{XSSFCell cell = row.createCell(i);
			cell.setCellValue(String.valueOf(k+1));}
			else {
			//System.out.println(str[i]);
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(str[i]);
			//System.out.println(cell.getStringCellValue());
			}
			
		}
		

		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		fis.close();
		fos.close();

	}


}
