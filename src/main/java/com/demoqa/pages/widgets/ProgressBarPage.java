package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class ProgressBarPage extends BaseClass{
    private final String startButton= "//button[@id='startStopButton']";
    private final String resetButton = "//button[@id='resetButton']";
    private final String progressBar = "//div[@role='progressbar']";

    public void clickStartButton(){
        BaseClass.click(startButton);
    }

    public Boolean verifyProgressBar(){
        return BaseClass.waitProgressBar(progressBar);
    }

    public Boolean verifyResetButton(){
        return BaseClass.isDisplayed(resetButton);
    } 

    public void goToProgressBar(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToProgressBarPage();
    }
}
