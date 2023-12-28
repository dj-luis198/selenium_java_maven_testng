package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

public class SelectMenuPage extends BaseClass {
    private final String selectValue = "//div[@id='withOptGroup']";
    private final String option00 = "//div[@id='react-select-2-option-0-0']";
    private final String singleValue = "//div[contains(@class,'-singleValue')]";
    private final String selectOne = "//div[@id='selectOne']";
    private final String option02 = "//div[@id='react-select-3-option-0-2']";
    private final String oldSelectMenu = "//select[@id='oldSelectMenu']";

    public void selectOldMenu(String text) {
        selectOptionByText(oldSelectMenu, text);
    }

    public Boolean verifySelectText(String text) {
        if (isSelectInnerText(oldSelectMenu).equals(text)) {
            return true;
        }
        return false;
    }

    public void clickSelectOne() {
        click(selectOne);
    }

    public void selectOpt2() {
        click(option02);
    }

    public Boolean verifySelectOpt2() {
        if (getAttributeInnerText(singleValue).equals("Mrs.")) {
            return true;
        }
        return false;
    }

    public void clickSelectValue() {
        click(selectValue);
    }

    public void selectG1Opt1() {
        click(option00);
    }

    public Boolean verifySelectG1Opt1() {
        if (getAttributeInnerText(singleValue).equals("Group 1, option 1")) {
            return true;
        }
        return false;
    }

    public void goToSelectMenu(){
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToSelectMenuPage();
        adsFooter.deleteAds();
    }
}
