package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class MenuPage extends BaseClass {

    private final String ancestorItem1 = "//a[normalize-space()='Main Item 1']/ancestor::li";
    private final String item1 = "//a[normalize-space()='Main Item 1']";
    private final String ancestorItem2 = "//a[normalize-space()='Main Item 2']/ancestor::li";
    private final String item2 = "//a[normalize-space()='Main Item 2']";
    private final String ancestorSubItem1 = "(//a[@href='#'][normalize-space()='Sub Item'])[1]/ancestor::li";
    private final String subItem1 = "(//a[@href='#'][normalize-space()='Sub Item'])[1]";
    private final String ancestorSubItem2 = "(//a[@href='#'][normalize-space()='Sub Item'])[2]/ancestor::li";
    private final String subItem2 = "(//a[@href='#'][normalize-space()='Sub Item'])[2]";
    private final String ancestorSubSubList = "//a[normalize-space()='SUB SUB LIST \u00BB']/ancestor::li";
    private final String subSubList = "//a[normalize-space()='SUB SUB LIST \u00BB']";
    private final String ancestorSubSubItem1 = "//a[normalize-space()='Sub Sub Item 1']/ancestor::li";
    private final String subSubItem1 = "//a[normalize-space()='Sub Sub Item 1']";
    private final String ancestorSubSubItem2 = "//a[normalize-space()='Sub Sub Item 2']/ancestor::li";
    private final String subSubItem2 = "//a[normalize-space()='Sub Sub Item 2']";
    private final String ancestorItem3 = "//a[normalize-space()='Main Item 3']/ancestor::li";
    private final String item3 = "//a[normalize-space()='Main Item 3']";

    public void moveToItem3() {
        moveToElement(item3);
    }

    public Boolean verifyItem3() {
        if (returnCSSBackground(ancestorItem3).equals("rgba(0, 63, 32, 1)")||returnCSSBackground(ancestorItem3).equals("rgb(0, 63, 32)")) {
            clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void moveToSubSubItem2() {
        moveToElement(subSubItem2);
    }

    public Boolean verifySubSubItem2() {
        if ((returnCSSBackground(ancestorSubSubItem2).equals("rgba(0, 63, 32, 1)") &&
                verifyItem2())||(returnCSSBackground(ancestorSubSubItem2).equals("rgb(0, 63, 32)") &&
                verifyItem2())) {
                    clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void moveToSubSubItem1() {
        moveToElement(subSubItem1);
    }

    public Boolean verifySubSubItem1() {
        if (returnCSSBackground(ancestorSubSubItem1).equals("rgba(0, 63, 32, 1)")||returnCSSBackground(ancestorSubSubItem1).equals("rgb(0, 63, 32)")) {
            clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void moveToSubSubList() {
        moveToElement(subSubList);
        waitVisibilityOf(subSubItem1);
        waitVisibilityOf(subSubItem2);
    }

    public Boolean verifySubSubList() {
        if (returnCSSBackground(ancestorSubSubList).equals("rgba(0, 63, 32, 1)")||returnCSSBackground(ancestorSubSubList).equals("rgb(0, 63, 32)")) {
            if (isDisplayed(subSubItem1) && isDisplayed(subSubItem2)) {
                clearActions();
                return true;
            }
        }
        clearActions();
        return false;
    }

    public void moveToSubItem2() {
        moveToElement(subItem2);
    }

    public Boolean verifySubItem2() {
        if ((returnCSSBackground(ancestorSubItem2).equals("rgba(0, 63, 32, 1)") &&
                returnCSSBackground(ancestorItem2).equals("rgba(0, 63, 32, 1)"))||(returnCSSBackground(ancestorSubItem2).equals("rgb(0, 63, 32)") &&
                returnCSSBackground(ancestorItem2).equals("rgb(0, 63, 32)"))) {
                    clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void moveToSubItem1() {
        moveToElement(subItem1);
    }

    public Boolean verifySubItem1() {
        if (returnCSSBackground(ancestorSubItem1).equals("rgba(0, 63, 32, 1)")||returnCSSBackground(ancestorSubItem1).equals("rgb(0, 63, 32)")) {
            clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void moveToItem2() {
        moveToElement(item2);
        waitVisibilityOf(subItem1);
        waitVisibilityOf(subItem2);
        waitVisibilityOf(subSubList);
    }

    public Boolean verifyItem2() {
        if (returnCSSBackground(ancestorItem2).equals("rgba(0, 63, 32, 1)")||returnCSSBackground(ancestorItem2).equals("rgb(0, 63, 32)")) {
            if (isDisplayed(subItem1) && isDisplayed(subItem2) && isDisplayed(subSubList)) {
                clearActions();
                return true;
            }
        }
        clearActions();
        return false;
    }

    public void moveToItem1() {
        moveToElement(item1);
    }

    public Boolean verifyItem1() {
        if (returnCSSBackground(ancestorItem1).equals("rgba(0, 63, 32, 1)")||returnCSSBackground(ancestorItem1).equals("rgb(0, 63, 32)")) {
            clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void goToMenu(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToMenuPage();
    }
}
