package Dataprvder_testng;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static String[][] getExcelData() throws IOException, InvalidFormatException {


		File file = new File(".//src//test//resources//Excelldata//Logindata.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheetAt(1);

		int lastRowNum = sheet.getLastRowNum();

		short lastCellNum = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[lastRowNum][lastCellNum];

		for (int i = 1; i <= lastRowNum; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < lastCellNum; j++) {

				XSSFCell cell = row.getCell(j);

				DataFormatter dataFormatter = new DataFormatter();

				String cellValue = dataFormatter.formatCellValue(cell);

				data[i - 1][j] = cellValue;

			}

		}
		
		workbook.close();
		
		return data;

	}

}
