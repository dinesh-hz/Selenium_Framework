package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Fileread_Manager {

	public void file_reader() throws FileNotFoundException {

		FileInputStream file = new FileInputStream("./src/test/resources/config.properties");

		Properties properties = new Properties();

		try {

			properties.load(file);

		} catch (Exception e) {

			e.printStackTrace();
		}

		contText.app_name = properties.getProperty("APP_NAME");
		contText.url = properties.getProperty("URL");
		contText.USER_NAME = properties.getProperty("USER_NAME");
		contText.pass_word = properties.getProperty("PASS_WORD");
		contText.use_na = properties.getProperty("USER_NA");
		contText.passsw = properties.getProperty("PASSWOR");

		contText.name = properties.getProperty("FIRST_NAME");
		contText.sname = properties.getProperty("SURENAME");
		contText.mailid = properties.getProperty("MAILID");
		contText.passsowrddd = properties.getProperty("PASSWORD");
		contText.data = properties.getProperty("DATA");
		contText.month = properties.getProperty("MONTH");
		contText.year = properties.getProperty("YEAR");
		contText.gender = properties.getProperty("GENDER");

		contText.excellpath = properties.getProperty("Excell_sheet");
		contText.sheetname = properties.getProperty("sheet_name");

		contText.fburlpath = properties.getProperty("fburl");

	}

}
