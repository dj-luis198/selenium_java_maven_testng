package com.demoqa.pages.elements;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

public class TextBoxPage extends BaseClass{

    private final String fullNameInput= "//*[@id=\"userName\"]";
    private final String emailInput="//*[@id=\"userEmail\"]";
    private final String currentAddressInput="//*[@id=\"currentAddress\"]";
    private final String permanentAddressInput="//*[@id=\"permanentAddress\"]";
    
    public void typeFullName(String text){
        type(fullNameInput,text);
    }

    public void typeEmeil(String text){
        type(emailInput,text);
    }

    public void typePermanentAddress(String text){
        type(permanentAddressInput,text);
    }

    public void typeCurrentAddress(String text){
        type(currentAddressInput,text);
    }

    public String getTextFullName(){
        return getText(fullNameInput);
    }

    public String getTextEmail(){
        return getText(emailInput);
    }

    public String getTextCurrentAddress(){
        return getText(currentAddressInput);
    }

    public String getTextPermanentAddress(){
        return getText(permanentAddressInput);
    }

    public void goToTextBox(HomePage homePage) {
        homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToTextBoxPage();
        adsFooter.deleteAds();
    }
    
}
