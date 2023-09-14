package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;

public class TabsPage extends BaseClass {

    private final String tabWhat = "//a[@id='demo-tab-what']";
    private final String tabOrigin = "//a[@id='demo-tab-origin']";
    private final String tabUse = "//a[@id='demo-tab-use']";
    private final String tabMore = "//a[@id='demo-tab-more']";

    public void clickTabWhat() {
        click(tabWhat);
    }

    public Boolean verifyTabWhat() {
        if (getAttributeAriaSelected(tabWhat).equals("true")) {
            return true;
        }
        return false;
    }

    public void clickTabOrigin() {
        click(tabOrigin);
    }

    public Boolean verifyTabOrigin() {
        if (getAttributeAriaSelected(tabOrigin).equals("true")) {
            return true;
        }
        return false;
    }

    public void clickTabUse() {
        click(tabUse);
    }

    public Boolean verifyTabUse() {
        if (getAttributeAriaSelected(tabUse).equals("true")) {
            return true;
        }
        return false;
    }

    public void clickTabMore() {
        click(tabMore);
    }

    public Boolean verifyTabMore() {
        if (getAttributeAriaDisabled(tabMore).equals("true")) {
            return true;
        }
        return false;
    }

}
