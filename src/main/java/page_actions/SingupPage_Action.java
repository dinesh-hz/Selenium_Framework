package page_actions;

import Page_locators.Singup_Locaters;
import utilities.Bass_Class;
import utilities.contText;

public class SingupPage_Action extends Bass_Class {


    Singup_Locaters locters = new Singup_Locaters();

    public void clcikbutton() throws InterruptedException {

        locters.Createaccount_btn.click();

        waitForSeconds(3);
    }

    public void fillenternewfom() {


        locters.firstname.sendKeys(contText.name);

        locters.surname.sendKeys(contText.sname);

        locters.mobil_mailid.sendKeys(contText.mailid);

        waitForSeconds(3);

        try {
            locters.reentermail.sendKeys(contText.mailid);

        } catch (Exception e) {
            e.getStackTrace();
        }

        locters.password.sendKeys(contText.passsowrddd);

        selectFromDropdown(locters.data, Dropdowntype.text, contText.data);
        selectFromDropdown(locters.month, Dropdowntype.text, contText.month);
        selectFromDropdown(locters.year, Dropdowntype.text, contText.year);

        locters.male.click();

        waitForSeconds(3);

    }

    public void clciksignbutton() {

        locters.signup_btn.click();

    }


}
