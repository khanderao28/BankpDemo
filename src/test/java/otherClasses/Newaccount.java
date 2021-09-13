package otherClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Newaccount {

	public static int getNumberofRows() throws IOException {
		// Sheet sheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				// System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}
		int k = sheet1.getLastRowNum();
		fis.close();
		return k;

	}
	
	public static void AddDepositORWidrow(String str,String str3) throws IOException {
		// Sheet sheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				// System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}
		int k = sheet1.getLastRowNum();
		int k1 = 0;
		for (int i = 1; i < k; i++) {
			if ((sheet1.getRow(i).getCell(5).toString()).equals(str)) {
				Row r = sheet1.getRow(i);
				k1 = r.getRowNum();
				
				break;
			}
		}

		int n = sheet1.getRow(k1).getLastCellNum();
		String[] str1 = new String[n];

		for (int i = 0; i < n; i++) {
			str1[i] = sheet1.getRow(k1).getCell(i).toString();

		}
		
		XSSFRow row = (XSSFRow) sheet1.createRow(k1);
		for (int i = 0; i < str1.length; i++) {
            if(i==6)
            {	System.out.println(" "+str1[i]);
            	System.out.println("\n old Ammount is "+str1[i]);
                System.out.println("new Ammount is "+str3);
                System.out.println(" ");
                	XSSFCell cell = row.createCell(i);
        			cell.setCellValue(str3);
            }
            else
            {   
    			
    			System.out.print(" " + str1[i]);
    			XSSFCell cell = row.createCell(i);
    			cell.setCellValue(str1[i]);
            }
			// System.out.println(cell.getStringCellValue());

		}
	
		fis.close();
		// String path1 = System.getProperty("user.dir") +
		// "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		// fis.close();
		fos.close();

	}
	

	public static void deleterow(String str) throws IOException {
		// Sheet sheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				// System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}
		int k = sheet1.getLastRowNum();
		int k1 = 0;
		for (int i = 1; i < k; i++) {
			if ((sheet1.getRow(i).getCell(5).toString()).equals(str)) {
				Row r = sheet1.getRow(i);
				k1 = r.getRowNum();
				sheet1.removeRow(r);
				break;
			}
		}

		if (k1 >= 0 && k1 < k) {
			sheet1.shiftRows(k1 + 1, k, -1);
		}
		fis.close();
		// String path1 = System.getProperty("user.dir") +
		// "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		// fis.close();
		fos.close();

	}

	public static int getNumberofcolom() throws IOException {
		// Sheet sheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				// System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}

		int k = sheet1.getRow(0).getLastCellNum();
		fis.close();
		return k;

	}

	public static void writeData(int j, String[] str) throws IOException {

		// Sheet sheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				// System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}
		System.out.println(" ");
		// int k = sheet1.getLastRowNum();
		XSSFRow row = (XSSFRow) sheet1.createRow(j + 1);
		for (int i = 0; i < str.length; i++) {

			System.out.print(" " + str[i]);
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(str[i]);
			// System.out.println(cell.getStringCellValue());

		}

		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		fis.close();
		fos.close();

	}

	public static String[] readData(int k) throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				// System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}

		int n = sheet1.getRow(k + 1).getLastCellNum();
		String[] str = new String[n];

		for (int i = 0; i < n; i++) {
			str[i] = sheet1.getRow(k + 1).getCell(i).toString();

		}

		/*
		 * str[0] = sheet1.getRow(k + 1).getCell(0).toString(); str[1] = sheet1.getRow(k
		 * + 1).getCell(1).toString(); str[2] = sheet1.getRow(k +
		 * 1).getCell(2).toString(); str[3] = sheet1.getRow(k +
		 * 1).getCell(3).toString(); str[4] = sheet1.getRow(k +
		 * 1).getCell(4).toString();
		 */
		fis.close();
		// int l=Integer.valueOf(username);
		return str;
	}

	public static String deleteaccount(int k) throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				// System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}

		int n = sheet1.getRow(k).getLastCellNum();
		// String[] str = new String[n];

		// for(int i=0;i<n;i++)

		String str = (String) sheet1.getRow(k).getCell(5).toString();

		/*
		 * str[0] = sheet1.getRow(k + 1).getCell(0).toString(); str[1] = sheet1.getRow(k
		 * + 1).getCell(1).toString(); str[2] = sheet1.getRow(k +
		 * 1).getCell(2).toString(); str[3] = sheet1.getRow(k +
		 * 1).getCell(3).toString(); str[4] = sheet1.getRow(k +
		 * 1).getCell(4).toString();
		 */
		fis.close();
		// int l=Integer.valueOf(username);
		return str;
	}

	public static void writeData1() throws IOException {

		// Sheet sheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				// System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}

		int r = sheet1.getLastRowNum();
		for (int q = 1; q <= r; q++) {

			int n = sheet1.getRow(q).getLastCellNum();
			String[] str = new String[n];

			for (int i = 0; i < n; i++) {
				str[i] = sheet1.getRow(q).getCell(i).toString();

			}
			// int k = sheet1.getLastRowNum();
			XSSFRow row = (XSSFRow) sheet1.createRow(q);
			for (int i = 0; i < str.length; i++) {
				if (i == 0) {
					// System.out.println(str[i]);
					XSSFCell cell = row.createCell(i);
					cell.setCellValue(q);
				} else {
					XSSFCell cell = row.createCell(i);
					cell.setCellValue(str[i]);
				}
				// System.out.println(cell.getStringCellValue());

			}
		}
		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		fis.close();
		fos.close();

	}
	
	
	public static void Payer(String str,String str3) throws IOException {
		// Sheet sheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				// System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}
		int k = sheet1.getLastRowNum();
		int k1 = 0;
		for (int i = 1; i < k; i++) {
			if ((sheet1.getRow(i).getCell(5).toString()).equals(str)) {
				Row r = sheet1.getRow(i);
				k1 = r.getRowNum();
				
				break;
			}
		}

		int n = sheet1.getRow(k1).getLastCellNum();
		String[] str1 = new String[n];

		for (int i = 0; i < n; i++) {
			str1[i] = sheet1.getRow(k1).getCell(i).toString();

		}
		
		XSSFRow row = (XSSFRow) sheet1.createRow(k1);
		for (int i = 0; i < str1.length; i++) {
            if(i==6)
            {	System.out.println(" "+str1[i]);
            	System.out.println("\n old Ammount is "+str1[i]);
                System.out.println("Transfer Ammount is "+str3);
                System.out.println(" ");
                int h=	Integer.valueOf(str1[i])-Integer.valueOf(str3);
                System.out.println(" New Ammount of "+str +" is " +h);
                	XSSFCell cell = row.createCell(i);
        			cell.setCellValue(String.valueOf(h));
            }
            else
            {   
    			
    			System.out.print(" " + str1[i]);
    			XSSFCell cell = row.createCell(i);
    			cell.setCellValue(str1[i]);
            }
			// System.out.println(cell.getStringCellValue());

		}
	
		fis.close();
		// String path1 = System.getProperty("user.dir") +
		// "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		// fis.close();
		fos.close();

	}
	
	public static void Payee(String str,String str3) throws IOException {
		// Sheet sheet = null;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resorcesFiles\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = null;

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("custdata")) {
				// System.out.println(workbook.getSheetAt(i).getSheetName());
				sheet1 = workbook.getSheetAt(i);
				break;
			}
		}
		int k = sheet1.getLastRowNum();
		int k1 = 0;
		for (int i = 1; i < k; i++) {
			if ((sheet1.getRow(i).getCell(5).toString()).equals(str)) {
				Row r = sheet1.getRow(i);
				k1 = r.getRowNum();
				
				break;
			}
		}

		int n = sheet1.getRow(k1).getLastCellNum();
		String[] str1 = new String[n];

		for (int i = 0; i < n; i++) {
			str1[i] = sheet1.getRow(k1).getCell(i).toString();

		}
		
		XSSFRow row = (XSSFRow) sheet1.createRow(k1);
		for (int i = 0; i < str1.length; i++) {
            if(i==6)
            {	System.out.println(" "+str1[i]);
            	System.out.println("\n old Ammount is "+str1[i]);
                System.out.println("Transfer Ammount is "+str3);
                System.out.println(" ");
                int h=	Integer.valueOf(str1[i])+Integer.valueOf(str3);
                System.out.println(" New Ammount of "+str +" is " +h);
                	XSSFCell cell = row.createCell(i);
        			cell.setCellValue(String.valueOf(h));
            }
            else
            {   
    			
    			System.out.print(" " + str1[i]);
    			XSSFCell cell = row.createCell(i);
    			cell.setCellValue(str1[i]);
            }
			// System.out.println(cell.getStringCellValue());

		}
	
		fis.close();
		// String path1 = System.getProperty("user.dir") +
		// "\\src\\test\\java\\resorcesFiles\\Book1.xlsx";
		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		// fis.close();
		fos.close();

	}
	


}
