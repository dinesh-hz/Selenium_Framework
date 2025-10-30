package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import page_actions.LoginPage;
import page_actions.SingupPage_Action;

public class SingupPageDefinitions {
	SingupPage_Action singup = new SingupPage_Action();
	LoginPage login = new LoginPage();
	public static final Logger LOGER= LogManager.getLogger(SingupPageDefinitions.class);


	

}
