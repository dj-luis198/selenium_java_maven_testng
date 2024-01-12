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
        if (getURL().equals(url)) {
            return true;
        }
        return false;
    }

    public void clickNewTabDinamicLink() {
        openNewTabAndSwitch(newTabDinamicLink);
    }

    public void clickNewTabSimpleLink() {
        openNewTabAndSwitch(newTabSimpleLink);
    }

    public void clickCreatedLink() {
        click(createdLink);
    }

    public void clickNoContentLink() {
        click(noContentLink);
    }

    public void clickMovedLink() {
        click(movedLink);
    }

    public void clickBadRequestLink() {
        click(badRequestLink);
    }

    public void clickUnauthorizedLink() {
        click(unauthorizedLink);
    }

    public void clickForbiddenLink() {
        click(forbiddenLink);
    }

    public void clickInvalidURLLink() {
        click(invalidURLLink);
    }

    public String returnLinkResponseMsg() {
        return getTextContent(linkResponseMsg);
    }

    public void goToLinks(HomePage homePage) {
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToLinksPage();
    }
}
