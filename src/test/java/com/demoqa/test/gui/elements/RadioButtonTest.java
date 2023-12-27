package com.demoqa.test.gui.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.RadioButtonPage;

@Test(groups = "RadioButtonTest", timeOut = 30000)
public class RadioButtonTest extends BaseTest {

  HomePage homePage;
  RadioButtonPage radioButtonPage;

  @BeforeMethod
  public void preconditions() {
    try {
      radioButtonPage = new RadioButtonPage();
      radioButtonPage.goToRadioButton(homePage);
    } catch (Exception e) {
      System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
      String browser = getBrowser();
      setUp(browser);
      radioButtonPage = new RadioButtonPage();
      radioButtonPage.goToRadioButton(homePage);
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
