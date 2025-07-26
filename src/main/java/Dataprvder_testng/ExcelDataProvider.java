package Dataprvder_testng;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider{
	
	@DataProvider(name = "loginData")
	public static  Object[][] getLoginData() throws IOException, InvalidFormatException {
		
		Object[][] hasi = ExcelUtil.getExcelData();
		
		return hasi;

	}
}
