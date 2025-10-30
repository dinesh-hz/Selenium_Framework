package StepDefinition;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import page_actions.LoginPage;
import page_actions.SingupPage;

import java.io.IOException;

public class SingupPageDefinitions {
	SingupPage singup = new SingupPage();
	LoginPage login = new LoginPage();
	public static final Logger LOGER= LogManager.getLogger(SingupPageDefinitions.class);


	

}
