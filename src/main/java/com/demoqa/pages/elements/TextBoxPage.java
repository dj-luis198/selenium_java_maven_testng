package com.demoqa.pages.elements;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class TextBoxPage extends BaseClass{

    private final String fullNameInput= "//*[@id=\"userName\"]";
    private final String emailInput="//*[@id=\"userEmail\"]";
    private final String currentAddressInput="//*[@id=\"currentAddress\"]";
    private final String permanentAddressInput="//*[@id=\"permanentAddress\"]";
    
    public void typeFullName(String text){
        BaseClass.type(fullNameInput,text);
    }

    public void typeEmeil(String text){
        BaseClass.type(emailInput,text);
    }

    public void typePermanentAddress(String text){
        BaseClass.type(permanentAddressInput,text);
    }

    public void typeCurrentAddress(String text){
        BaseClass.type(currentAddressInput,text);
    }

    public String getTextFullName(){
        return BaseClass.getText(fullNameInput);
    }

    public String getTextEmail(){
        return BaseClass.getText(emailInput);
    }

    public String getTextCurrentAddress(){
        return BaseClass.getText(currentAddressInput);
    }

    public String getTextPermanentAddress(){
        return BaseClass.getText(permanentAddressInput);
    }

    public void goToTextBox(HomePage homePage) {
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToTextBoxPage();
    }
    
}
