package com.demoqa.test.gui.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.SelectMenuPage;

@Test(groups = "SelectMenuTest", timeOut = 30000)
public class SelectMenuTest extends BaseTest {
    SelectMenuPage selectMenuPage;

    @BeforeMethod
    public void preconditions() {
        try {
            selectMenuPage = new SelectMenuPage();
            selectMenuPage.goToSelectMenu();
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
            String browser = getBrowser();
            setUp(browser);
            selectMenuPage = new SelectMenuPage();
            selectMenuPage.goToSelectMenu();
        }
    }

    @Test
    public void validateSelectValue() {
        selectMenuPage.clickSelectValue();
        selectMenuPage.selectG1Opt1();
        Assert.assertTrue(selectMenuPage.verifySelectG1Opt1());
    }

    @Test
    public void validateSelectOne() {
        selectMenuPage.clickSelectOne();
        selectMenuPage.selectOpt2();
        Assert.assertTrue(selectMenuPage.verifySelectOpt2());
    }

    @Test
    public void validateOldSelectMenu() {
        selectMenuPage.selectOldMenu("Red");
        Assert.assertTrue(selectMenuPage.verifySelectText("Red"));
    }

}
