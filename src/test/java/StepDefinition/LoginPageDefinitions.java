package StepDefinition;

import Helpers.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import page_actions.Forgotpage;
import page_actions.Homepage;
import page_actions.LoginPage;
import utilities.Bass_Class;
import utilities.contText;

import java.util.List;
import java.util.Map;

public class LoginPageDefinitions {

    protected static final Logger logger = LogManager.getLogger(Hooks.class);

    LoginPage LoginPage = new LoginPage();

    Forgotpage ForgetPage = new Forgotpage();


    Homepage Homepage = new Homepage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Bass_Class.set_URL(contText.url);
        Bass_Class.waitForPageLoadComplete();

        logger.info("done");

    }

    @Given("user entre the valid {string} and {string}")
    public void userEntreTheValidAnd(String user, String pass) {

        LoginPage.enterUsername(user);
        LoginPage.enterPassword(pass);

    }


    @Then("user click the login button")
    public void user_click_the_login_button() {
        // Validate Element is NOT Displayed

        Assert.assertTrue(LoginPage.isLoginButtonVisible(), "user isnt able to see button");

        Assert.assertTrue(LoginPage.isLoginButtonEnabled(), "login button isnt enabled after enter data");
        Bass_Class.waitForSeconds(5);
        LoginPage.clickLoginButton();

    }

    @Then("user should see homepage")
    public void userShouldSeeHomepage() {

        Bass_Class.waitForPageLoadComplete();
        Bass_Class.waitForSeconds(5);
        Assert.assertTrue(Homepage.verifyHomepage(), "user isnt Homepage now");

    }

    @Given("user entre the invalid username and password")
    public void user_entre_the_invalid_username_and_password() throws Exception {

        LoginPage.enterUsername("WorrogeA");
        LoginPage.enterPassword("dvdvddj4562");

    }

    @Then("user should see error message {string}")
    public void user_should_see_error_message(String expexterror_mesg) {

        Assert.assertTrue(LoginPage.isInvalidErrorMessageDisplayed(),"The erroe mesg isnt displayed");

        Assert.assertEquals(LoginPage.getInvalidErrorMessage(),expexterror_mesg,"the text is mismatch");


    }

    @Given("user entre the invalid username {string}")
    public void userEntreTheInvalidUsername(String string) {

        LoginPage.enterPassword(string);

    }

    @When("user entre password")
    public void user_entre_password() {

        LoginPage.enterPassword(contText.pass_word);

    }

    @Then("user should see error message of username {string}")
    public void userShouldSeeErrorMessageOfUsername(String string) {


        Assert.assertEquals(LoginPage.getUsernameRequiredErrorText(),string,"user cant see errormesge of username");

    }

    @Given("user entre the username")
    public void user_entre_the_username() throws Exception {

        LoginPage.enterUsername(contText.USER_NAME);

    }

    @When("user entre invalid password")
    public void user_entre_invalid_password() {

        LoginPage.enterPassword("ggjh@55");

    }

    @Given("user dont enter anything username and password")
    public void user_dont_enter_anything_username_and_password() throws Exception {

        LoginPage.enterUsername("");
        LoginPage.enterPassword("");
    }

    @Then("user should see error message of username&password needs {string}")
    public void userShouldSeeErrorMessageOfUsernamePasswordNeeds(String string) {


        Assert.assertEquals(LoginPage.getUsernameRequiredErrorText(),string, "the text is mismatched");

        Assert.assertEquals( LoginPage.getPasswordRequiredErrorText(),string, "the text is mismatched");

    }

    @Given("user dont entre  enything username")
    public void user_dont_entre_enything_username() {

        LoginPage.enterUsername("");
    }

    @When("user dont entre  enything password")
    public void user_dont_entre_enything_password() {
        LoginPage.enterPassword("");

    }

    @Then("user should see error message of password {string}")
    public void userShouldSeeErrorMessageOfPassword(String string) {
        Bass_Class.waitForSeconds(3);
        Assert.assertEquals(LoginPage.getPasswordRequiredErrorText(),string,"user cant see errormesge of password");

    }

    @Given("user entre on password box")
    public void user_entre_on_password_box() {
        LoginPage.enterPassword(contText.pass_word);

    }

    @Given("user click the Forgot Password link")
    public void user_click_the_forgot_password_link() {

        LoginPage.clickForgotPasswordLink();

    }

    @Then("user should go Forgot Password page {string}")
    public void user_should_go_forgot_password_page(String string) {

        Assert.assertTrue(ForgetPage.isResetPasswordHeadingVisible(),"user isnt in forgetpasswordpage");
        String headingText = ForgetPage.getResetPasswordHeadingText();
        Assert.assertEquals(headingText,string,"Forgot Password page heading text mismatch");

    }

  /*  @Given("user entre the username is uses different case sensitivity")
    public void user_entre_the_username_is_uses_different_case_sensitivity(DataTable dataTable) throws Exception {

        List<Map<String, String>> tableMap = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : tableMap) {
            String username = row.get("usernamenormal");
            String usernamecase = row.get("usernamecase");
            LoginPage.enterUsername(username);

            boolean casesensitive = LoginPage.isDashboardVisible();

            Assert.assertTrue(casesensitive, " Dashboard is not visible");

            LoginPage.entreusername(usernamecase);


            boolean notcasesensitive = LoginPage.isDashboardVisible();

            Assert.assertFalse(notcasesensitive, " Dashboard is  visible");
        }
    }
*/

    @When("user entre the vaild password")
    public void user_entre_the_vaild_password() {
        LoginPage.enterPassword(contText.pass_word);
    }

    @Then("clcik login button")
    public void clcik_login_button() {

        LoginPage.clickLoginButton();

    }

    @Given("user does not entre anything")
    public void user_does_not_entre_anything() {

        LoginPage.enterUsername("");
        LoginPage.enterPassword("");

    }

    @Then("user check on login button is disabled")
    public void user_check_on_login_button_is_disabled() {
        Bass_Class.waitForSeconds(3);

        Assert.assertFalse( LoginPage.isLoginButtonEnabled(), "the login button is not disable");

    }

    @Given("user entre username and password vaild credentials")
    public void user_entre_username_and_password_vaild_credentials() {

        LoginPage.enterUsername(contText.USER_NAME);
        Bass_Class.waitForSeconds(3);
        LoginPage.enterPassword(contText.pass_word);

    }

    @Then("user should go to the homepage")
    public void user_should_go_to_the_homepage() {
        Bass_Class.waitForSeconds(3);

        Assert.assertTrue(Homepage.verifyHomepage(),"user isnt in homepage ");

    }

    @Given("user entre  username and password")
    public void user_entre_username_and_password() {
        LoginPage.enterUsername(contText.USER_NAME);

        LoginPage.enterPassword(contText.pass_word);
    }

    @Then("user  check on login button is enable")
    public void user_check_on_login_button_is_enable() {
        Bass_Class.waitForSeconds(3);

        Assert.assertTrue(LoginPage.isLoginButtonEnabled(),"the login button is not enabled");

    }

    @Given("user entres an valid username and invalid password {string}")
    public void user_entres_an_valid_username_and_invalid_password(String string) {

        LoginPage.enterUsername(contText.USER_NAME);
        LoginPage.enterPassword(string);

    }

    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String string) {

        Bass_Class.waitForSeconds(3);
        Assert.assertEquals(LoginPage.getInvalidErrorMessage(),string,"user did not see any error mesg");

    }

    @Then("user should logout")
    public void userShouldLogout() {


        LoginPage.logoutUser();

    }

    @Given("user entre the username {string} and password {string}")
    public void userEntreTheUsernameAndPassword(String user, String pass) {

        LoginPage.enterUsername(user);

        LoginPage.enterPassword(pass);
    }

    @And("user should not go to the homepage")
    public void userShouldNotGoToTheHomepage() {
        boolean dashboardVisible = Homepage.verifyHomepage();

        Assert.assertFalse(dashboardVisible," user is in  home page ");

    }


    @Given("user entre the username  and password")
    public void userEntreTheUsernameAndPassword(DataTable dataTable) {

       var tableMap = dataTable.asMap(String.class, String.class);

        LoginPage.enterUsername( tableMap.get("username"));
        LoginPage.enterPassword(tableMap.get("password"));
    }
}
