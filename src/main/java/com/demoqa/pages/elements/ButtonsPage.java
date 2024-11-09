package com.demoqa.pages.elements;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class ButtonsPage extends BaseClass {

    private final String doubleClickBtn = "//button[@id='doubleClickBtn']";
    private final String rightClickBtn = "//button[@id='rightClickBtn']";
    private final String ClickBtn = "(//button[normalize-space()='Click Me'])[1]";
    private final String doubleClickMessage = "//p[@id='doubleClickMessage']";
    private final String rightClickMessage = "//p[@id='rightClickMessage']";
    private final String dynamicClickMessage = "//p[@id='dynamicClickMessage']";

    public void dblClickButton() {
        BaseClass.doubleClick(doubleClickBtn);
    }

    public Boolean returnMessageDoubleClick() {
        return (BaseClass.getTextContent(doubleClickMessage).equals("You have done a double click"));
    }

    public void rightClickButton() {
        BaseClass.rightClick(rightClickBtn);
    }

    public Boolean returnMessageRighClick() {
        return (BaseClass.getTextContent(rightClickMessage).equals("You have done a right click"));
    }

    public void clickButton() {
        BaseClass.click(ClickBtn);
    }

    public Boolean returnMessageClick() {
        return (BaseClass.getTextContent(dynamicClickMessage).equals("You have done a dynamic click"));
    }

    public void goToButtons() {
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToButtonsPage();
    }

}
