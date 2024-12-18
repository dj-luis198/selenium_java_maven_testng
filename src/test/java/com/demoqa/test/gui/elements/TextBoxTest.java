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
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.util.AnsiColorUtils;

import net.datafaker.Faker;

@Test(groups = "TextBoxTest", timeOut = 30000)
public class TextBoxTest extends BaseTest {
  private HomePage homePage;
  private String fullName, email, currentAddress, permanentAddress;

  private static Logger logger= LogManager.getLogger(TextBoxTest.class);

  @BeforeMethod
  public void preconditions() {
    try {
      TextBoxPage textBoxPage = new TextBoxPage();
      textBoxPage.goToTextBox(homePage);
      Faker faker = new Faker();
      fullName = faker.name().fullName();
      email = faker.internet().emailAddress();
      currentAddress = faker.address().fullAddress();
      permanentAddress = faker.address().fullAddress();
    } catch (TimeoutException | NoSuchElementException e) {
      logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
      Assert.fail();
    }
  }

  @Test
  public void testTextBoxs() {
    TextBoxPage textBoxPage = new TextBoxPage();

    textBoxPage.typeFullName(fullName);
    Assert.assertEquals(fullName, textBoxPage.getTextFullName());
    textBoxPage.typeEmeil(email);
    Assert.assertEquals(email, textBoxPage.getTextEmail());
    textBoxPage.typeCurrentAddress(currentAddress);
    Assert.assertEquals(currentAddress, textBoxPage.getTextCurrentAddress());
    textBoxPage.typePermanentAddress(permanentAddress);
    Assert.assertEquals(permanentAddress, textBoxPage.getTextPermanentAddress());
  }

}
