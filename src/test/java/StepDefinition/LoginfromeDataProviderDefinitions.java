package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_actions.LoginPage;
import utilities.Bass_Class;
import utilities.contText;

public class LoginfromeDataProviderDefinitions extends Bass_Class{
	
	LoginPage log = new LoginPage();
	
	@Given("user  go to url web application")
	public void user_go_to_url_web_application() {
		
		set_URL(contText.url);
		
	}

	@When("user enterss the data {string} and {string}")
	public void user_enterss_the_data_and(String string, String string2) throws InterruptedException {
		
		log.entreusername(string);
		Thread.sleep(5000);
		log.entreusername(string2);

	}

	@Then("user clcik the login button")
	public void user_clcik_the_login_button() {
	}
}
