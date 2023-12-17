package com.demoqa.pages.AlertsFrameWindows;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

public class BrowserWindowsPage extends BaseClass {
    private final String tabButton = "//button[@id='tabButton']";
    private final String sampleURL = "https://demoqa.com/sample";
    private final String windowButton = "//button[@id='windowButton']";
    private final String messageWindowButton = "//button[@id='messageWindowButton']";
    private final String blankURL = "about:blank";


    public void openAndGoWindowMessage() {
        clickNewTab(messageWindowButton);
    }

    public String openAndGoWindow() {
        String url=clickNewTab(windowButton);
        return url;
    }

    public String openAndGoTab() {
        String url=clickNewTab(tabButton);
        return url;
    }

    public Boolean verifyUrl(String url) {
        if (sampleURL.equals(url)) {
            return true;
        }
        return false;
    }

    public Boolean verifyBlankUrl(String url) {
        if (blankURL.equals(url)) {
            return true;
        }
        return false;
    }

    public void goToBrowserWindows(HomePage homePage) {
        homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToAlertsFrameWindowsPage();
        adsFooter.deleteAds();
    }
}
