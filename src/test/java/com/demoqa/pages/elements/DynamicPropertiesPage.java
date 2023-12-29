package com.demoqa.pages.elements;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

public class DynamicPropertiesPage extends BaseClass {
    private final String enableAfterButton = "//button[@id='enableAfter']";
    private final String colorChangeButton = "//button[@id='colorChange']";
    private final String visibleAfterButton = "//button[@id='visibleAfter']";

    public Boolean returnIsVisible() {
        return isVisible(visibleAfterButton,6);
    }

    public Boolean returnIsNoVisible() {
        return NoFind(visibleAfterButton);
    }

    public String returnColor() {
        return returnCSSColor(colorChangeButton);
    }

    public Boolean returnStatusEnabled() {
        if (isEnabled(enableAfterButton)) {
            return true;
        }
        return false;
    }

    public void goToDynamicProperties(HomePage homePage) {
        homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToDynamicPropertiesPage();
        adsFooter.deleteAds();
    }

    public void waitChange(){
        waitNotVisibiliy(enableAfterButton,6);
    }

    public void waitChangeColor(){
        waitNotVisibiliy(colorChangeButton,5);
    }

    public void waitChangeVisible(){
        waitVisibilityOf(visibleAfterButton,5);
    }

}
