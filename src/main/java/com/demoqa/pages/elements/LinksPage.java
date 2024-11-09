package com.demoqa.pages.elements;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class LinksPage extends BaseClass {

    private final String createdLink = "//a[@id='created']";
    private final String noContentLink = "//a[@id='no-content']";
    private final String movedLink = "//a[@id='moved']";
    private final String badRequestLink = "//a[@id='bad-request']";
    private final String unauthorizedLink = "//a[@id='unauthorized']";
    private final String forbiddenLink = "//a[@id='forbidden']";
    private final String invalidURLLink = "//a[@id='invalid-url']";
    private final String linkResponseMsg = "//p[@id='linkResponse']";
    private final String newTabSimpleLink = "//a[@id='simpleLink']";
    private final String newTabDinamicLink = "//a[@id='dynamicLink']";
    private final String url = "https://demoqa.com/";

    public Boolean returnURL() {
        if (BaseClass.getURL().equals(url)) {
            return true;
        }
        return false;
    }

    public void clickNewTabDinamicLink() {
        BaseClass.openNewTabAndSwitch(newTabDinamicLink);
    }

    public void clickNewTabSimpleLink() {
        BaseClass.openNewTabAndSwitch(newTabSimpleLink);
    }

    public void clickCreatedLink() {
        BaseClass.click(createdLink);
    }

    public void clickNoContentLink() {
        BaseClass.click(noContentLink);
    }

    public void clickMovedLink() {
        BaseClass.click(movedLink);
    }

    public void clickBadRequestLink() {
        BaseClass.click(badRequestLink);
    }

    public void clickUnauthorizedLink() {
        BaseClass.click(unauthorizedLink);
    }

    public void clickForbiddenLink() {
        BaseClass.click(forbiddenLink);
    }

    public void clickInvalidURLLink() {
        BaseClass.click(invalidURLLink);
    }

    public String returnLinkResponseMsg() {
        return BaseClass.getTextContent(linkResponseMsg);
    }

    public void goToLinks(HomePage homePage) {
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToLinksPage();
    }
}
