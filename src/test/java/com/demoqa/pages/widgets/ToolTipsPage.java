package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

public class ToolTipsPage extends BaseClass {
    private final String toolTipButton = "//button[@id='toolTipButton']";
    private final String toolTipButtonMsg = "//div[@id='buttonToolTip']";
    private final String toolTipTextField = "//input[@id='toolTipTextField']";
    private final String toolTipTextFieldMsg = "//div[@id='textFieldToolTip']";
    private final String toolTipContraryLink = "//a[normalize-space()='Contrary']";
    private final String toolTipcontraryMsg = "//div[@id='contraryTexToolTip']";
    private final String toolTip11032Link = "//a[normalize-space()='1.10.32']";
    private final String toolTip11032LinkMsg = "//div[@id='sectionToolTip']";

    public void moveMouseTOButton() {
        scrollToElement(toolTipButton);
        moveToElement(toolTipButton);
    }

    public Boolean verifyToolTipButton() {
        if (isDisplayed(toolTipButtonMsg)) {
            if (getAttributeInnerText(toolTipButtonMsg).equals("You hovered over the Button")) {
                return true;
            }
        }
        return false;
    }

    public void moveMouseTOTextField() {
        scrollToElement(toolTipTextField);
        moveToElement(toolTipTextField);
    }

    public Boolean verifyToolTipTextField() {
        if (isDisplayed(toolTipTextFieldMsg)) {
            if (getAttributeInnerText(toolTipTextFieldMsg).equals("You hovered over the text field")) {
                return true;
            }
        }
        return false;
    }

    public void moveMouseTOContraryLink() {
        scrollToElement(toolTipContraryLink);
        moveToElement(toolTipContraryLink);
    }

    public Boolean verifyToolTipContraryLink() {
        if (isDisplayed(toolTipcontraryMsg)) {
            if (getAttributeInnerText(toolTipcontraryMsg).equals("You hovered over the Contrary")) {
                return true;
            }
        }
        return false;
    }

    public void moveMouseTO11032Link() {
        scrollToElement(toolTip11032Link);
        moveToElement(toolTip11032Link);
    }

    public Boolean verifyToolTip11032Link() {
        if (isDisplayed(toolTip11032LinkMsg)) {
            if (getAttributeInnerText(toolTip11032LinkMsg).equals("You hovered over the 1.10.32")) {
                return true;
            }
        }
        return false;
    }

    public void goToToolTips(){
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToToolTipsPage();
        adsFooter.deleteAds();
    }
}
