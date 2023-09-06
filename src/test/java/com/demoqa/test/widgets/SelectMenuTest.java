package com.demoqa.test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.widgets.SelectMenuPage;
import com.demoqa.test.base.BaseTest;

public class SelectMenuTest extends BaseTest {
    SelectMenuPage selectMenuPage;

    @BeforeMethod
    public void preconditions() {
        selectMenuPage = new SelectMenuPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToSelectMenuPage();
        adsFooter.deleteAds();
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
