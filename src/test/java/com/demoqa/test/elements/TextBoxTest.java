package com.demoqa.test.elements;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.TextBoxPage;
import com.demoqa.test.BaseTest;
import net.datafaker.Faker;

public class TextBoxTest extends BaseTest{
    private String fullName,email,currentAddress,permanentAddress;

    @BeforeMethod
    public void initData(){
        HomePage homePage=new HomePage();
        Faker faker = new Faker();

        fullName = faker.name().fullName(); 
        email = faker.internet().emailAddress(); 
        currentAddress = faker.address().fullAddress(); 
        permanentAddress= faker.address().fullAddress();

        homePage.goToTextBoxPage();
    }

    @Test
    public void testTextBoxs(){
        TextBoxPage textBoxPage = new TextBoxPage();

        textBoxPage.typeFullName(fullName);
        Assert.assertEquals(fullName,textBoxPage.getTextFullName());
        textBoxPage.typeEmeil(email);
        Assert.assertEquals(email,textBoxPage.getTextEmail());
        textBoxPage.typeCurrentAddress(currentAddress);
        Assert.assertEquals(currentAddress,textBoxPage.getTextCurrentAddress());
        textBoxPage.typePermanentAddress(permanentAddress);
        Assert.assertEquals(permanentAddress,textBoxPage.getTextPermanentAddress());
    }
    
}
