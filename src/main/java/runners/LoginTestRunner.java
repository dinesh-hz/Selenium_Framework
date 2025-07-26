package runners;

import org.testng.annotations.Test;

import Dataprvder_testng.ExcelDataProvider;
import page_actions.LoginPage;

public class LoginTestRunner {
	
	  @Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	    public void runTest(String username, String password) {
		  LoginPage steps = new LoginPage();
	        steps.entreusername(username);
	        steps.entrepassword(password);
	    }

}

// this is data provider to get value and assinge here in page action class
