package com.demoqa.pages;

import com.demoqa.base.BaseClass;

public class RadioButtonPage extends BaseClass {

    private final String yesRadio = "//label[normalize-space()='Yes']";
    private final String impressiveRadio = "//label[@for='impressiveRadio']";
    private final String noRadio = "//label[normalize-space()='No']";
    private final String checkedYes = "//input[@id='yesRadio']";
    private final String checkedImpressive = "//input[@id='impressiveRadio']";
    private final String checkedNoRadio = "//input[@id='noRadio']";
    private final String textSuccess = "//span[@class='text-success']";

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
