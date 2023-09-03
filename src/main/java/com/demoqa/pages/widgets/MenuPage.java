package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;

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
        scrollToElement(item3);
        moveToElement(item3);
    }

    public Boolean verifyItem3() {
        if (returnCSSBackground(ancestorItem3).equals("rgba(0, 63, 32, 1)")) {
            clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void moveToSubSubItem2() {
        scrollToElement(subSubItem2);
        moveToElement(subSubItem2);
    }

    public Boolean verifySubSubItem2() {
        System.out.println(returnCSSBackground(ancestorSubSubItem2));
        if (returnCSSBackground(ancestorSubSubItem2).equals("rgba(0, 63, 32, 1)") &&
                verifyItem2()) {
                    clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void moveToSubSubItem1() {
        scrollToElement(subSubItem1);
        moveToElement(subSubItem1);
    }

    public Boolean verifySubSubItem1() {
        System.out.println(returnCSSBackground(ancestorSubSubItem1));
        if (returnCSSBackground(ancestorSubSubItem1).equals("rgba(0, 63, 32, 1)")) {
            clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void moveToSubSubList() {
        waitVisibilityOf(subSubList);
        System.out.println("subSubList es visible");
        scrollToElement(subSubList);
        System.out.println("scroll a subSubList");
        //waitElementToBeClickable(subSubList);
        moveToElement(subSubList);
        System.out.println("se movio a subSubList");
        click(subSubList);
        waitVisibilityOf(subSubItem2);
        System.out.println("subSubItem2 es visible");
    }

    public Boolean verifySubSubList() {
        if (returnCSSBackground(ancestorSubSubList).equals("rgba(0, 63, 32, 1)")) {
            if (isDisplayed(subSubItem1) && isDisplayed(subSubItem2)) {
                clearActions();
                return true;
            }
        }
        clearActions();
        return false;
    }

    public void moveToSubItem2() {
        scrollToElement(subItem2);
        moveToElement(subItem2);
        click(subItem2);
    }

    public Boolean verifySubItem2() {
        if (returnCSSBackground(ancestorSubItem2).equals("rgba(0, 63, 32, 1)") &&
                returnCSSBackground(ancestorItem2).equals("rgba(0, 63, 32, 1)")) {
                    clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void moveToSubItem1() {
        scrollToElement(subItem1);
        moveToElement(subItem1);
    }

    public Boolean verifySubItem1() {
        if (returnCSSBackground(ancestorSubItem1).equals("rgba(0, 63, 32, 1)")) {
            clearActions();
            return true;
        }
        clearActions();
        return false;
    }

    public void moveToItem2() {
        scrollToElement(item2);
        moveToElement(item2);
        waitVisibilityOf(subSubList);
    }

    public Boolean verifyItem2() {
        if (returnCSSBackground(ancestorItem2).equals("rgba(0, 63, 32, 1)")) {
            if (isDisplayed(subItem1) && isDisplayed(subItem2) && isDisplayed(subSubList)) {
                clearActions();
                return true;
            }
        }
        clearActions();
        return false;
    }

    public void moveToItem1() {
        scrollToElement(item1);
        moveToElement(item1);
    }

    public Boolean verifyItem1() {
        if (returnCSSBackground(ancestorItem1).equals("rgba(0, 63, 32, 1)")) {
            clearActions();
            return true;
        }
        clearActions();
        return false;
    }
}
