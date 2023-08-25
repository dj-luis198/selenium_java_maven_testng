package com.demoqa.pages.elements;

import com.demoqa.base.BaseClass;

public class DynamicPropertiesPage extends BaseClass {
    private final String enableAfterButton = "//button[@id='enableAfter']";
    private final String colorChangeButton = "//button[@id='colorChange']";
    private final String visibleAfterButton = "//button[@id='visibleAfter']";

    public Boolean returnIsVisible() {
        return isDisplayed(visibleAfterButton);
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

}
