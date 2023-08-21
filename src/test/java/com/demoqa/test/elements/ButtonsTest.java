package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.test.BaseTest;

public class ButtonsTest extends BaseTest {
    HomePage homePage;
    ButtonsPage buttonsPage;

    @BeforeMethod
    public void preconditions() {
        homePage = new HomePage();
        buttonsPage = new ButtonsPage();
        homePage.goToButtonsPage();
    }

    @Test(description = "Validate double clic on Button")
    public void doubleClickButton() {
        buttonsPage.dblClickButton();
        Assert.assertTrue(buttonsPage.returnMessageDoubleClick());
    }

    @Test(description = "Validate right clic on Button")
    public void rightClickButton() {
        buttonsPage.rightClickButton();
        Assert.assertTrue(buttonsPage.returnMessageRighClick());
    }

    @Test(description = "Validate common clic on Button")
    public void dynamicClickButton() {
        buttonsPage.clickButton();
        Assert.assertTrue(buttonsPage.returnMessageClick());
    }
}
