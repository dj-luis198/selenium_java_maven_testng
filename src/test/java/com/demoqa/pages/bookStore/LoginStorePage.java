package com.demoqa.pages.bookStore;

import com.demoqa.base.BaseClass;

public class LoginStorePage extends BaseClass{
    private final String userNameInput="//input[@id='userName']";
    private final String passInput="//input[@id='password']";
    private final String loginButton="//button[@id='login']";

    public void typeUserName(String text){
        type(userNameInput, text);
    }

    public void typeUserPass(String text){
        type(passInput, text);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public void goToLoginStore(){
        irA("https://demoqa.com/login");
    }
    
}
