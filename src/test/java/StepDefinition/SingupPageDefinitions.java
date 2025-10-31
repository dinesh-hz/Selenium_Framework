package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import page_actions.SingupPage_Action;
import utilities.Bass_Class;
import utilities.contText;

public class SingupPageDefinitions {

	public static final Logger LOGER= LogManager.getLogger(SingupPageDefinitions.class);

	SingupPage_Action singup = new SingupPage_Action();


	@Given("user should be  in webpage")
	public void user_should_be_in_webpage() {

		Bass_Class.set_URL(contText.fburlpath);
		Bass_Class.waitForPageLoadComplete();
	}

	@Given("user should clcik the createnewaccound button")
	public void user_should_clcik_the_createnewaccound_button() throws InterruptedException {
		singup.clcikbutton();

	}

	@When("user should be fill the fome")
	public void user_should_be_fill_the_fome() {
		singup.fillenternewfom();
	}

	@Then("user clcik the login button")
	public void user_clcik_the_login_button() {

		singup.clciksignbutton();
	}




	

}
