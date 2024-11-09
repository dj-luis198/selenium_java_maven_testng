package com.demoqa.pages.AlertsFrameWindows;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class NestedFramesPages extends BaseClass {

    private final String contextText = "//div[@id='framesWrapper']/div";
    private final String frameParent = "//iframe[@id='frame1']";
    private final String frameParentText = "//body";
    private final String frameChild = "//iframe[@srcdoc='<p>Child Iframe</p>']";
    private final String frameChildText = "//p[normalize-space()='Child Iframe']";

    public void goToParentFrame() {
        BaseClass.switchToTheFrame(frameParent);
    }

    public Boolean verifiTextParentFrame() {
        if (BaseClass.getTextContent(frameParentText).equals("Parent frame")) {
            return true;
        }
        return false;
    }

    public void goToChildFrame() {
        BaseClass.switchToTheFrame(frameChild);
    }

    public Boolean verifiTextChildFrame() {
        if (BaseClass.getTextContent(frameChildText).equals("Child Iframe")) {
            return true;
        }
        return false;
    }

    public void returnToContent() {
        BaseClass.returnDefaultContent();
    }

    public Boolean verifiTextDefaultContent() {
        if (BaseClass.getTextContent(contextText).contains("Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.")) {
                    return true;
        }
        return false;
    }

    public void goToNestedFrames(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToNestedFramesPage();
    }
}
