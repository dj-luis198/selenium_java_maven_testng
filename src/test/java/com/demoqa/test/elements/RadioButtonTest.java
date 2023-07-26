package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.RadioButtonPage;
import com.demoqa.test.BaseTest;

public class RadioButtonTest extends BaseTest{
    HomePage homePage;
    RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void preconditions(){
        homePage=new HomePage(driver);
        radioButtonPage= new RadioButtonPage(driver);
        homePage.goToRadioButtonPage();
    }

    @Test(description = "Validate selected Yes radio button")
    public void testSelectYes(){
        radioButtonPage.clickYes();
        Assert.assertTrue(radioButtonPage.statusYes());
        Assert.assertEquals(radioButtonPage.getTextSuccess(),"Yes");
    }

    @Test(description = "Validate selected Impressive radio button")
    public void testSelectImpressive(){
        radioButtonPage.clickImpressive();
        Assert.assertTrue(radioButtonPage.statusImpressive());
        Assert.assertEquals(radioButtonPage.getTextSuccess(),"Impressive");
    } 

    @Test(description = "validate no selection radio button")
    public void testSelectNoRadio(){
        radioButtonPage.clickNoRadio();
        Assert.assertTrue(radioButtonPage.NoFindElementSuccess());
        Assert.assertFalse(radioButtonPage.statusNoRadio());
        Assert.assertTrue(radioButtonPage.NoFindElementSuccess());
    } 
}
