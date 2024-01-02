package com.demoqa.test.gui.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "ButtonsTest", timeOut = 30000)
public class ButtonsTest extends BaseTest {
  private ButtonsPage buttonsPage;

  private static Logger logger= LogManager.getLogger(ButtonsTest.class);

  @BeforeMethod
  public void preconditions() {
    try {
      buttonsPage = new ButtonsPage();
      buttonsPage.goToButtons();
    } catch (TimeoutException | NoSuchElementException e) {
      logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
      String browser = getBrowser();
      setUp(browser);
      buttonsPage = new ButtonsPage();
      buttonsPage.goToButtons();
    }
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
