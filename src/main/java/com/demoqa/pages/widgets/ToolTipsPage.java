package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;
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
        BaseClass.scrollToElement(toolTipButton);
        BaseClass.moveToElement(toolTipButton);
    }

    public Boolean verifyToolTipButton() {
        if (BaseClass.isDisplayed(toolTipButtonMsg)) {
            if (BaseClass.getAttributeInnerText(toolTipButtonMsg).equals("You hovered over the Button")) {
                return true;
            }
        }
        return false;
    }

    public void moveMouseTOTextField() {
        BaseClass.scrollToElement(toolTipTextField);
        BaseClass.moveToElement(toolTipTextField);
    }

    public Boolean verifyToolTipTextField() {
        if (BaseClass.isDisplayed(toolTipTextFieldMsg)) {
            if (BaseClass.getAttributeInnerText(toolTipTextFieldMsg).equals("You hovered over the text field")) {
                return true;
            }
        }
        return false;
    }

    public void moveMouseTOContraryLink() {
        BaseClass.scrollToElement(toolTipContraryLink);
        BaseClass.moveToElement(toolTipContraryLink);
    }

    public Boolean verifyToolTipContraryLink() {
        if (BaseClass.isDisplayed(toolTipcontraryMsg)) {
            if (BaseClass.getAttributeInnerText(toolTipcontraryMsg).equals("You hovered over the Contrary")) {
                return true;
            }
        }
        return false;
    }

    public void moveMouseTO11032Link() {
        BaseClass.scrollToElement(toolTip11032Link);
        BaseClass.moveToElement(toolTip11032Link);
    }

    public Boolean verifyToolTip11032Link() {
        if (BaseClass.isDisplayed(toolTip11032LinkMsg)) {
            if (BaseClass.getAttributeInnerText(toolTip11032LinkMsg).equals("You hovered over the 1.10.32")) {
                return true;
            }
        }
        return false;
    }

    public void goToToolTips(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToToolTipsPage();
    }
}
