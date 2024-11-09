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
        BaseClass.moveToElement(item3);
    }

    public Boolean verifyItem3() {
        if (BaseClass.returnCSSBackground(ancestorItem3).equals("rgba(0, 63, 32, 1)")|| BaseClass.returnCSSBackground(ancestorItem3).equals("rgb(0, 63, 32)")) {
            BaseClass.clearActions();
            return true;
        }
        BaseClass.clearActions();
        return false;
    }

    public void moveToSubSubItem2() {
        BaseClass.moveToElement(subSubItem2);
    }

    public Boolean verifySubSubItem2() {
        if ((BaseClass.returnCSSBackground(ancestorSubSubItem2).equals("rgba(0, 63, 32, 1)") &&
                verifyItem2())||(BaseClass.returnCSSBackground(ancestorSubSubItem2).equals("rgb(0, 63, 32)") &&
                verifyItem2())) {
                    BaseClass.clearActions();
            return true;
        }
        BaseClass.clearActions();
        return false;
    }

    public void moveToSubSubItem1() {
        BaseClass.moveToElement(subSubItem1);
    }

    public Boolean verifySubSubItem1() {
        if (BaseClass.returnCSSBackground(ancestorSubSubItem1).equals("rgba(0, 63, 32, 1)")|| BaseClass.returnCSSBackground(ancestorSubSubItem1).equals("rgb(0, 63, 32)")) {
            BaseClass.clearActions();
            return true;
        }
        BaseClass.clearActions();
        return false;
    }

    public void moveToSubSubList() {
        BaseClass.moveToElement(subSubList);
        BaseClass.waitVisibilityOf(subSubItem1);
        BaseClass.waitVisibilityOf(subSubItem2);
    }

    public Boolean verifySubSubList() {
        if (BaseClass.returnCSSBackground(ancestorSubSubList).equals("rgba(0, 63, 32, 1)")|| BaseClass.returnCSSBackground(ancestorSubSubList).equals("rgb(0, 63, 32)")) {
            if (BaseClass.isDisplayed(subSubItem1) && BaseClass.isDisplayed(subSubItem2)) {
                BaseClass.clearActions();
                return true;
            }
        }
        BaseClass.clearActions();
        return false;
    }

    public void moveToSubItem2() {
        BaseClass.moveToElement(subItem2);
    }

    public Boolean verifySubItem2() {
        if ((BaseClass.returnCSSBackground(ancestorSubItem2).equals("rgba(0, 63, 32, 1)") &&
                BaseClass.returnCSSBackground(ancestorItem2).equals("rgba(0, 63, 32, 1)"))||(BaseClass.returnCSSBackground(ancestorSubItem2).equals("rgb(0, 63, 32)") &&
                BaseClass.returnCSSBackground(ancestorItem2).equals("rgb(0, 63, 32)"))) {
                    BaseClass.clearActions();
            return true;
        }
        BaseClass.clearActions();
        return false;
    }

    public void moveToSubItem1() {
        BaseClass.moveToElement(subItem1);
    }

    public Boolean verifySubItem1() {
        if (BaseClass.returnCSSBackground(ancestorSubItem1).equals("rgba(0, 63, 32, 1)")|| BaseClass.returnCSSBackground(ancestorSubItem1).equals("rgb(0, 63, 32)")) {
            BaseClass.clearActions();
            return true;
        }
        BaseClass.clearActions();
        return false;
    }

    public void moveToItem2() {
        BaseClass.moveToElement(item2);
        BaseClass.waitVisibilityOf(subItem1);
        BaseClass.waitVisibilityOf(subItem2);
        BaseClass.waitVisibilityOf(subSubList);
    }

    public Boolean verifyItem2() {
        if (BaseClass.returnCSSBackground(ancestorItem2).equals("rgba(0, 63, 32, 1)")|| BaseClass.returnCSSBackground(ancestorItem2).equals("rgb(0, 63, 32)")) {
            if (BaseClass.isDisplayed(subItem1) && BaseClass.isDisplayed(subItem2) && BaseClass.isDisplayed(subSubList)) {
                BaseClass.clearActions();
                return true;
            }
        }
        BaseClass.clearActions();
        return false;
    }

    public void moveToItem1() {
        BaseClass.moveToElement(item1);
    }

    public Boolean verifyItem1() {
        if (BaseClass.returnCSSBackground(ancestorItem1).equals("rgba(0, 63, 32, 1)")|| BaseClass.returnCSSBackground(ancestorItem1).equals("rgb(0, 63, 32)")) {
            BaseClass.clearActions();
            return true;
        }
        BaseClass.clearActions();
        return false;
    }

    public void goToMenu(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToMenuPage();
    }
}
