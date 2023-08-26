package com.demoqa.pages.AlertsFrameWindows;

import com.demoqa.base.BaseClass;

public class BrowserWindowsPage extends BaseClass {
    private final String tabButton = "//button[@id='tabButton']";
    private final String sampleURL = "https://demoqa.com/sample";
    private final String windowButton = "//button[@id='windowButton']";
    private final String messageWindowButton = "//button[@id='messageWindowButton']";

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
}
