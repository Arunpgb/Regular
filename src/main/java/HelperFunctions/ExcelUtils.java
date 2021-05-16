package HelperFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ProjectConstants.ProjectConstants;


public class ExcelUtils {

	//@SuppressWarnings("deprecation")
	public static List<Map<String, String>> getTestdetails(String Sheetname) {
		List<Map<String, String>> listOfCases = null;
		Map<String, String> testcases = null;
		try {
			// Creating WorkBook and Fetching Sheet details
			FileInputStream fis= new FileInputStream(ProjectConstants.getExcelpath());
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet  sheet = workbook.getSheet(Sheetname);

			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();

			listOfCases = new ArrayList<Map<String,String>>();

			for (int row = 1; row <=rowCount; row++) {
				testcases = new HashMap<String,String>();

				for (int col = 0; col < columnCount; col++) {
					String key = sheet.getRow(0).getCell(col).getStringCellValue();
					String Value = sheet.getRow(row).getCell(col).getStringCellValue();
					testcases.put(key, Value);
				}
				listOfCases.add(testcases);

			}
		}

		catch (FileNotFoundException Filenotavailable) {
			Filenotavailable.getStackTrace();
			Filenotavailable.getMessage();
		}

		catch (IOException IOException) {
			IOException.getStackTrace();
			IOException.getMessage();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			//fis.close();
			
		}
		return listOfCases;

	}

}
