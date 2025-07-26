package Excell_read;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil_simple_tyepe {
	
//	this is simple way to get data from excell sheet from whenever

	public static String getCellData( int row, int col) throws Exception {
		FileInputStream fis = new FileInputStream(new File("./src//test//resources//Excelldata//Logindata.xlsx"));
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheetAt(0);
		Row r = sheet.getRow(row);
		Cell c = r.getCell(col);
		return c.toString();
	}
}
