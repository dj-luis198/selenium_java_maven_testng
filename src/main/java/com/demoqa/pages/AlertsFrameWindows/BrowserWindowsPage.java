package com.demoqa.pages.AlertsFrameWindows;

import com.demoqa.base.BaseClass;

public class BrowserWindowsPage extends BaseClass {
    private final String tabButton = "//button[@id='tabButton']";
    private final String sampleURL = "https://demoqa.com/sample";
    private final String windowButton = "//button[@id='windowButton']";
    private final String messageWindowButton = "//button[@id='messageWindowButton']";
    private final String blankURL = "about:blank";


    public void openAndGoWindowMessage() {
        clickNewTab(messageWindowButton);
    }

    public void openAndGoWindow() {
        clickNewTab(windowButton);
    }

    public void openAndGoTab() {
        clickNewTab(tabButton);
    }

    public Boolean verifyUrl() {
        if (sampleURL.equals(getURL())) {
            return true;
        }
        return false;
    }

    public Boolean verifyBlankUrl() {
        if (blankURL.equals(getURL())) {
            return true;
        }
        return false;
    }
}
