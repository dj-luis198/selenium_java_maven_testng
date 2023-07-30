package com.demoqa.pages;

import com.demoqa.base.BaseClass;

public class ButtonsPage extends BaseClass {

    private static String doubleClickBtn = "//button[@id='doubleClickBtn']";
    private static String rightClickBtn = "//button[@id='rightClickBtn']";
    private static String ClickBtn = "(//button[normalize-space()='Click Me'])[1]";
    private static String doubleClickMessage = "//p[@id='doubleClickMessage']";
    private static String rightClickMessage = "//p[@id='rightClickMessage']";
    private static String dynamicClickMessage = "//p[@id='dynamicClickMessage']";

    public void dblClickButton() {
        doubleClick(doubleClickBtn);
    }

    public Boolean returnMessageDoubleClick() {
        return (getTextContent(doubleClickMessage).equals("You have done a double click"));
    }

    public void rightClickButton() {
        rightClick(rightClickBtn);
    }

    public Boolean returnMessageRighClick() {
        return (getTextContent(rightClickMessage).equals("You have done a right click"));
    }

    public void clickButton() {
        click(ClickBtn);
    }

    public Boolean returnMessageClick() {
        return (getTextContent(dynamicClickMessage).equals("You have done a dynamic click"));
    }

}
