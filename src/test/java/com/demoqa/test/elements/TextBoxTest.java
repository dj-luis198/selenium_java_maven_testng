package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.TextBoxPage;

import net.datafaker.Faker;

@Test(groups = "TextBoxTest")
public class TextBoxTest extends BaseTest {
    AdsFooter adsFooter;
    private String fullName, email, currentAddress, permanentAddress;

    @BeforeMethod
    public void initData() {
        HomePage homePage = new HomePage();
        adsFooter = new AdsFooter();
        Faker faker = new Faker();
        fullName = faker.name().fullName();
        email = faker.internet().emailAddress();
        currentAddress = faker.address().fullAddress();
        permanentAddress = faker.address().fullAddress();
        homePage.goToHome();
        homePage.goToTextBoxPage();
        adsFooter.deleteAds();
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
