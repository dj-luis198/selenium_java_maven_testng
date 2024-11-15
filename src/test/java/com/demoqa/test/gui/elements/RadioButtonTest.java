package com.demoqa.test.gui.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.RadioButtonPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "RadioButtonTest", timeOut = 30000)
public class RadioButtonTest extends BaseTest {

  private HomePage homePage;
  private RadioButtonPage radioButtonPage;

  private static Logger logger= LogManager.getLogger(RadioButtonTest.class);

  @BeforeMethod
  public void preconditions() {
    try {
      radioButtonPage = new RadioButtonPage();
      radioButtonPage.goToRadioButton(homePage);
    } catch (TimeoutException | NoSuchElementException e) {
      logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
      Assert.fail();
    }
  }

  @Test(description = "Validate selected Yes radio button")
  public void testSelectYes() {
    radioButtonPage.clickYes();
    Assert.assertTrue(radioButtonPage.statusYes());
    Assert.assertEquals(radioButtonPage.getTextSuccess(), "Yes");
  }

  @Test(description = "Validate selected Impressive radio button")
  public void testSelectImpressive() {
    radioButtonPage.clickImpressive();
    Assert.assertTrue(radioButtonPage.statusImpressive());
    Assert.assertEquals(radioButtonPage.getTextSuccess(), "Impressive");
  }

  @Test(description = "validate no selection radio button")
  public void testSelectNoRadio() {
    radioButtonPage.clickNoRadio();
    Assert.assertTrue(radioButtonPage.NoFindElementSuccess());
    Assert.assertFalse(radioButtonPage.statusNoRadio());
    Assert.assertTrue(radioButtonPage.NoFindElementSuccess());
  }
}
