/*
package utilities;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Bass_Class.*;

import javax.swing.*;


public class Duummyforselenium extends Driver_manger {


    static Bass_Class bass = new Bass_Class();

    public static void main(String[] args) {

        String file = "C:\\Users\\DELL\\Downloads\\20255\\dowload";
        launchBrowser(BrowserName.CHROME, file);

       //  Bass_Class.set_URL("https://the-internet.herokuapp.com/");
       //   Bass_Class.waitForPageLoadComplete();
       */
/* WebElement droganddop = Bass_Class.findElementBy(LocatorType.XPATH, "//a[text()=\"Drag and Drop\"]");
        droganddop.click();
        Bass_Class. waitForPageLoadComplete();
        WebElement element_A = Bass_Class.findElementBy(LocatorType.XPATH, "(//div[@class=\"column\"])[1]");
        WebElement element_B = Bass_Class.findElementBy(LocatorType.XPATH, "(//div[@class=\"column\"])[2]");
        Bass_Class.dragAndDrop(element_A, element_B);
        Bass_Class.waitForSeconds(5);
        Bass_Class.dragAndDrop(element_B, element_A);
        Bass_Class.waitForSeconds(5);
        Bass_Class.Navigate(NavigationType.BACK);
        waitForPageLoadComplete();
        WebElement Dropdown = Bass_Class.findElementBy(LocatorType.XPATH, "//a[text()=\"Dropdown\"]");
        Bass_Class.Elementhighlight(Dropdown);
        Bass_Class.waitForSeconds(5);
        Dropdown.click();
        Bass_Class.waitForPageLoadComplete();
        WebElement dropdownloctere = Bass_Class.findElementBy(LocatorType.ID, "dropdown");
        Bass_Class.Elementhighlight(dropdownloctere);
        Bass_Class.waitForSeconds(5);
        String s = Bass_Class.selectFromDropdown(dropdownloctere, Dropdowntype.value, "1");
        System.out.println("this is option  :" + s);
        boolean multipleSelect = Bass_Class.isMultipleSelect(dropdownloctere);
        System.out.println("this is a : " + multipleSelect);
        Bass_Class.Navigate(NavigationType.BACK);
        Bass_Class.waitForSeconds(3);
        WebElement filedoloadbuton = Bass_Class.findElementBy(LocatorType.XPATH, "//a[text()=\"File Download\"]");
        Bass_Class.Elementhighlight(filedoloadbuton);
        Bass_Class.waitForSeconds(3);
        Bass_Class.scroll_Screen(filedoloadbuton);
        Bass_Class.waitForSeconds(3);
        filedoloadbuton.click();
        Bass_Class.waitForPageLoadComplete();
        WebElement txtbutn = Bass_Class.findElementBy(LocatorType.XPATH, "//a[starts-with(text(),\"empty\")]");
        txtbutn.click();
        Bass_Class.waitForSeconds(3);
        String text = txtbutn.getText();
        System.out.println(text);
        boolean fileDownloaded = Bass_Class.isFileDownloaded(file, text);
        System.out.println(fileDownloaded);
        Bass_Class.waitForSeconds(3);
        String parentwindow = Bass_Class.getWindowHandle();
        System.out.println("parentwindow id : " + parentwindow);
        Bass_Class.NewTab();
        Bass_Class.navigateToURL("https://practice.expandtesting.com/upload");
        Bass_Class.waitForPageLoadComplete();
        Set<String> allWindows = Bass_Class.getAllWindows(1);
        System.out.println(allWindows);
        WebElement fileuload = Bass_Class.findElementBy(LocatorType.XPATH, "//input[@type=\"file\"]");
        fileuload.sendKeys("C:\\Users\\DELL\\Downloads\\dinu.jpg");
        Bass_Class.waitForSeconds(5);
        Bass_Class.findElementBy(LocatorType.ID, "fileSubmit").click();
        Bass_Class.waitForSeconds(5);
        Driver_manger.getDriver().close();
        Bass_Class.getAllWindows(0);
        Bass_Class.waitForSeconds(3);
        Bass_Class.Navigate(NavigationType.BACK);
        Bass_Class.waitForPageLoadComplete();*//*




      */
/*  Bass_Class.findElementBy(LocatorType.XPATH, "//a[text()=\"Frames\"]").click();
        Bass_Class.waitForPageLoadComplete();
        Bass_Class.findElementBy(LocatorType.XPATH, "//a[text()=\"Nested Frames\"]").click();
        Bass_Class.waitForPageLoadComplete();
        int parentframe = Bass_Class.switchToFrameByIndex("frame", 0);
        System.out.println(parentframe);
        Bass_Class.switchToFrameByIndex("frame", 2);
        WebElement elementBy = Bass_Class.findElementBy(LocatorType.CSS_SELECTOR, "html>body");
        String s1 = Bass_Class.ElementAction(elementBy, ElementAction.GET_TEXT);
        System.out.println("text name " + s1);
        Bass_Class.switchToDefaultFrame();
        Bass_Class.switchToFrameByIndex("frame", 1);
        WebElement element = Bass_Class.findElementBy(LocatorType.CSS_SELECTOR, "html>body");
        String s2 = Bass_Class.ElementAction(element, ElementAction.GET_TEXT);
        System.out.println("text name " + s2);
        Bass_Class.Navigate(NavigationType.BACK);
        Bass_Class.Navigate(NavigationType.BACK);
        WebElement multiwindow = Bass_Class.findElementBy(LocatorType.XPATH, "//a[text()=\"Multiple Windows\"]");
        Bass_Class.scroll_Screen(multiwindow);
        Bass_Class.waitForSeconds(3);
        multiwindow.click();
        WebElement clickbton = Bass_Class.findElementBy(LocatorType.XPATH, "//a[text()=\"Click Here\"]");
        clickbton.click();
        Bass_Class.waitForSeconds(3);
        Bass_Class.getAllWindows(1);
        WebElement getmeg = Bass_Class.findElementBy(LocatorType.XPATH, "//div[@class=\"example\"]//h3");
        System.out.println("this is mesgg :" + getmeg.getText());
        Driver_manger.getDriver().close();
        Bass_Class.getAllWindows(0);
        Bass_Class.Navigate(NavigationType.BACK);
        WebElement broken = Bass_Class.findElementBy(LocatorType.XPATH, "//a[text()=\"Broken Images\"]");
        Bass_Class.scroll_Screen(broken);
        broken.click();
        WebElement brokenimage = Bass_Class.findElementBy(LocatorType.XPATH, "(//div[@class=\"example\"]//child::img)[1]");
        boolean verifyBrokenImage = Bass_Class.isVerifyBrokenImage(brokenimage);
        Assert.assertTrue(verifyBrokenImage, " This image isn't Broken :");
        WebElement image = Bass_Class.findElementBy(LocatorType.XPATH, "(//div[@class=\"example\"]//child::img)[3]");
        boolean verifyImage = Bass_Class.isVerifyBrokenImage(image);
        Assert.assertFalse(verifyImage, "This image is Broken : ");
        Bass_Class.Navigate(NavigationType.BACK);
        WebElement Context_Menu_buton = Bass_Class.findElementBy(LocatorType.XPATH, "//a[text()=\"Context Menu\"]");
        Context_Menu_buton.click();
        WebElement inbox = Bass_Class.findElementBy(LocatorType.XPATH, "//div[@id=\"hot-spot\"]");
        Bass_Class.mouseoverAndClickRight(inbox);
        Bass_Class.waitForSeconds(3);
        Bass_Class.Alertshandle(AlertAction.ACCEPT);
        Bass_Class.waitForSeconds(5);
        Bass_Class.Navigate(NavigationType.BACK);*//*



      */
/*  WebElement sliderbox= Bass_Class.findElementBy(LocatorType.XPATH, "//a[text()=\"Horizontal Slider\"]");
        sliderbox.click();
        WebElement slider = Bass_Class.findElementBy(LocatorType.XPATH, "//input[@type=\"range\"]");
*//*

        Bass_Class.set_URL("https://www.amazon.in/");
        Bass_Class.waitForPageLoadComplete();
        Bass_Class.findElementBy(LocatorType.XPATH, "//span[text()=\"Air conditioners\"]//parent::div").click();
        Bass_Class.waitForPageLoadComplete();
        WebElement elementBy = Bass_Class.findElementBy(LocatorType.XPATH, "//input[@aria-label=\"Minimum price\"]");
        elementBy.sendKeys("30000");
        Bass_Class.waitForSeconds(5);
       // Bass_Class.setPriceSliderValue(elementBy,30000);

        //  Bass_Class.moveSliderJS(elementBy, 0);
        WebElement elementBy2= Bass_Class.findElementBy(LocatorType.XPATH, "//input[@aria-label=\"Maximum price\"]");
       // Bass_Class.moveSliderJS(elementBy2, 120);
        elementBy2.sendKeys("40000");
        Bass_Class.waitForSeconds(5);
        getDriver().quit();


    }
}
*/
