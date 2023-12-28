package com.demoqa.test.gui.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.ButtonsPage;

@Test(groups = "ButtonsTest", timeOut = 30000)
public class ButtonsTest extends BaseTest {
  ButtonsPage buttonsPage;

  @BeforeMethod
  public void preconditions() {
    try {
      buttonsPage = new ButtonsPage();
      buttonsPage.goToButtons();
    } catch (Exception e) {
      System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
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
