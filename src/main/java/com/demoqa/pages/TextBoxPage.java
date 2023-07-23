package com.demoqa.pages;

import org.openqa.selenium.WebDriver;

import com.demoqa.base.BaseClass;

public class TextBoxPage extends BaseClass{

    private static String fullNameInput= "//*[@id=\"userName\"]";
    private static String emailInput="//*[@id=\"userEmail\"]";
    private static String currentAddressInput="//*[@id=\"currentAddress\"]";
    private static String permanentAddressInput="//*[@id=\"permanentAddress\"]";
    

    public TextBoxPage(WebDriver driver){
        BaseClass.driver=driver;
    }

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
    
}
