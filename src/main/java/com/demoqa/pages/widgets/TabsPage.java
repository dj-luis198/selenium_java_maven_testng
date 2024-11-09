package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class TabsPage extends BaseClass {

    private final String tabWhat = "//a[@id='demo-tab-what']";
    private final String tabOrigin = "//a[@id='demo-tab-origin']";
    private final String tabUse = "//a[@id='demo-tab-use']";
    private final String tabMore = "//a[@id='demo-tab-more']";

    public void clickTabWhat() {
        BaseClass.click(tabWhat);
    }

    public Boolean verifyTabWhat() {
        if (BaseClass.getAttributeAriaSelected(tabWhat).equals("true")) {
            return true;
        }
        return false;
    }

    public void clickTabOrigin() {
        BaseClass.click(tabOrigin);
    }

    public Boolean verifyTabOrigin() {
        if (BaseClass.getAttributeAriaSelected(tabOrigin).equals("true")) {
            return true;
        }
        return false;
    }

    public void clickTabUse() {
        BaseClass.click(tabUse);
    }

    public Boolean verifyTabUse() {
        if (BaseClass.getAttributeAriaSelected(tabUse).equals("true")) {
            return true;
        }
        return false;
    }

    public void clickTabMore() {
        BaseClass.click(tabMore);
    }

    public Boolean verifyTabMore() {
        if (BaseClass.getAttributeAriaDisabled(tabMore).equals("true")) {
            return true;
        }
        return false;
    }

    public void goToTabs(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToTabsPage();
    }
}
