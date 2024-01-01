package com.demoqa.test.gui.AlertsFrameWindows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.AlertsPage;
import com.demoqa.pages.common.HomePage;
import com.demoqa.util.AnsiColorUtils;

import net.datafaker.Faker;

@Test(groups = "AlertsTest", timeOut = 30000)
public class AlertsTest extends BaseTest {
    AlertsPage alertsPage;
    HomePage homePage;

    private static Logger logger= LogManager.getLogger(AlertsTest.class);

    Faker fake = new Faker();

    @BeforeMethod
    public void preconditions() {
        try {
            alertsPage = new AlertsPage();
            alertsPage.goToAlerts(homePage);
        } catch (TimeoutException | NoSuchElementException e) { 
        logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
        String browser= getBrowser();
        setUp(browser);
        alertsPage = new AlertsPage();
            alertsPage.goToAlerts(homePage);
      }   
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
