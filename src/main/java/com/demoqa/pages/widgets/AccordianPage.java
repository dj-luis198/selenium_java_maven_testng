package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;

public class AccordianPage extends BaseClass {
    private final String section1Button = "//div[@id='section1Heading']";
    private final String section1Content = "//div[@id='section1Content']/parent::div";
    private final String section2Button = "//div[@id='section2Heading']";
    private final String section2Content = "//div[@id='section2Content']/parent::div";
    private final String section3Button = "//div[@id='section3Heading']";
    private final String section3Content = "//div[@id='section3Content']/parent::div";

    public void clickSection1() {
        click(section1Button);
    }

    public Boolean isDisplayedSection1() {
        return isDisplayed(section1Content);
    }

    public void clickSection2() {
        click(section2Button);
    }

    public Boolean isDisplayedSection2() {
        return isDisplayed(section2Content);
    }

    public void clickSection3() {
        click(section3Button);
    }

    public Boolean isDisplayedSection3() {
        return isDisplayed(section3Content);
    }

}
