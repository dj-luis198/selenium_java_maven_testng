package com.demoqa.pages.elements;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class RadioButtonPage extends BaseClass {

    private final String yesRadio = "//label[normalize-space()='Yes']";
    private final String impressiveRadio = "//label[@for='impressiveRadio']";
    private final String noRadio = "//label[normalize-space()='No']";
    private final String checkedYes = "//input[@id='yesRadio']";
    private final String checkedImpressive = "//input[@id='impressiveRadio']";
    private final String checkedNoRadio = "//input[@id='noRadio']";
    private final String textSuccess = "//span[@class='text-success']";

    public void clickYes() {
        BaseClass.click(yesRadio);
    }

    public void clickImpressive() {
        BaseClass.click(impressiveRadio);
    }

    public void clickNoRadio() {
        BaseClass.click(noRadio);
    }

    public Boolean statusYes() {
        return BaseClass.isSelected(checkedYes);
    }

    public Boolean statusImpressive() {
        return BaseClass.isSelected(checkedImpressive);
    }

    public Boolean statusNoRadio() {
        return BaseClass.isSelected(checkedNoRadio);
    }

    public String getTextSuccess() {
        return BaseClass.getTextContent(textSuccess);
    }

    public Boolean NoFindElementSuccess() {
        return BaseClass.NoFind(textSuccess);
    }

    public Boolean isDisabledElement(){
        return BaseClass.isDisplayed(checkedNoRadio);
    }

    public void goToRadioButton(HomePage homePage) {
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToRadioButtonPage();
    }
}
