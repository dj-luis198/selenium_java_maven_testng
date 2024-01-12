package com.demoqa.pages.elements;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class DynamicPropertiesPage extends BaseClass {
    private final String enableAfterButton = "//button[@id='enableAfter']";
    private final String colorChangeButton = "//button[@id='colorChange']";
    private final String visibleAfterButton = "//button[@id='visibleAfter']";

    public Boolean returnIsVisible() {
        return isVisible(visibleAfterButton);
    }

    public Boolean returnIsNoVisible() {
        return NoFind(visibleAfterButton);
    }

    public Boolean returnColor() {
        String color1="rgba(220, 53, 69, 1)";
        String color2="rgb(220, 53, 69)";
        return returnChangeCSSValue(colorChangeButton, color1, color2,"color");
    }

    public String returnInitColor() {
        return returnCSSColor(colorChangeButton);
    }

    public Boolean returnStatusChangeToEnabled() {
        return waitIsEnabled(enableAfterButton);
    }

    public Boolean returnStatusEnabled() {
        String enabled = returnPropertyValue(enableAfterButton, "disabled");
        if (enabled.equals("false"))
            return true;
        else
            return false;
    }

    public void goToDynamicProperties(HomePage homePage) {
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToDynamicPropertiesPage();
    }

}
