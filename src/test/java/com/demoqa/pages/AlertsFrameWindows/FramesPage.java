package com.demoqa.pages.AlertsFrameWindows;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class FramesPage extends BaseClass {
    private final String textDefaultContent = "//div[@id='framesWrapper']/div";
    private final String frame1 = "//iframe[@id='frame1']";
    private final String frame2 = "//iframe[@id='frame2']";
    private final String textFrame = "//h1[@id='sampleHeading']";

    public void goToFrame1() {
        switchToTheFrame(frame1);
    }

    public void goToFrame2() {
        switchToTheFrame(frame2);
    }

    public Boolean verifiTextFrame() {
        if (getTextContent(textFrame).equals("This is a sample page")) {
            return true;
        }
        return false;
    }

    public void returnToContent() {
        returnDefaultContent();
    }

    public Boolean verifiTextDefaultContent() {
        if (getTextContent(textDefaultContent).equals(
                "Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below")) {
            return true;
        }
        return false;
    }

    public void goToFrames(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToFramesPage();
    }
}
