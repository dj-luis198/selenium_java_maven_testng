package com.demoqa.pages;

import org.openqa.selenium.WebDriver;

import com.demoqa.base.BaseClass;

public class RadioButtonPage extends BaseClass {

    private static String yesRadio = "//label[normalize-space()='Yes']";
    private static String impressiveRadio = "//label[normalize-space()='Impressive']";
    private static String noRadio = "//label[normalize-space()='No']";
    private static String checkedYes = "//input[@id='yesRadio']";
    private static String checkedImpressive = "//input[@id='impressiveRadio']";
    private static String checkedNoRadio = "//input[@id='noRadio']";
    private static String textSuccess = "//span[@class='text-success']";

    public RadioButtonPage(WebDriver driver) {
        BaseClass.driver = driver;
    }

    public void clickYes() {
        click(yesRadio);
    }

    public void clickImpressive() {
        click(impressiveRadio);
    }

    public void clickNoRadio() {
        click(noRadio);
    }

    public Boolean statusYes() {
        return isSelected(checkedYes);
    }

    public Boolean statusImpressive() {
        return isSelected(checkedImpressive);
    }

    public Boolean statusNoRadio() {
        return isSelected(checkedNoRadio);
    }

    public String getTextSuccess() {
        return getTextContent(textSuccess);
    }

    public Boolean NoFindElementSuccess() {
        return NoFind(textSuccess);
    }

    public Boolean isDisabledElement(){
        return isDisplayed(checkedNoRadio);
    }
}
