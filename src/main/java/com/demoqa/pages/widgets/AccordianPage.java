package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class AccordianPage extends BaseClass {
    private final String section1Button = "//div[@id='section1Heading']";
    private final String section1Content = "//div[@id='section1Content']";
    private final String section2Button = "//div[@id='section2Heading']";
    private final String section2Content = "//div[@id='section2Content']";
    private final String section3Button = "//div[@id='section3Heading']";
    private final String section3Content = "//div[@id='section3Content']";

    public void clickSection1() {
        BaseClass.click(section1Button);
    }

    public Boolean isDisplayedSection1() {
        return BaseClass.isDisplayed(section1Content);
    }

    public void clickSection2() {
        BaseClass.click(section2Button);
    }

    public Boolean isDisplayedSection2() {
        return BaseClass.isDisplayed(section2Content);
    }

    public void clickSection3() {
        BaseClass.click(section3Button);
    }

    public Boolean isDisplayedSection3() {
        return BaseClass.isDisplayed(section3Content);
    }

    public void goToAccordian(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToAccordianPage();
    }

}
