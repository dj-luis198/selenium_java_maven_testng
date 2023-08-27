package com.demoqa.test.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.AlertsFrameWindows.AlertsPage;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.test.base.BaseTest;

import net.datafaker.Faker;

public class AlertsTest extends BaseTest {
    AlertsPage alertsPage;

    Faker fake = new Faker();

    @BeforeMethod
    public void preconditions() {
        alertsPage = new AlertsPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToAlertsPage();
        adsFooter.deleteAds();
    }

    @Test
    public void ValidateAlert() {
        alertsPage.clickAlertButton();
        Assert.assertTrue(alertsPage.acceptAlert());
    }

    @Test
    public void ValidateTimerAlert() {
        alertsPage.clickTimerAlertButton();
        Assert.assertTrue(alertsPage.acceptTimerAlert());
    }

    @Test
    public void ValidateConfirmAlertOK() {
        alertsPage.clickConfirmAlertButton();
        alertsPage.selectOkconfirmAlert();
        Assert.assertTrue(alertsPage.returnConfirmResultOK());
    }

    @Test
    public void ValidateConfirmAlertCancel() {
        alertsPage.clickConfirmAlertButton();
        alertsPage.selectCancelconfirmAlert();
        Assert.assertTrue(alertsPage.returnConfirmResultCancel());
    }

    @Test
    public void ValidatePromptAlert() {
        String text = fake.funnyName().name();
        alertsPage.clickPromptAlertButton();
        alertsPage.TypeMessagePrompAlert(text);
        Assert.assertTrue(alertsPage.returnPromptResult(text));
    }
}
