package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;

public class ProgressBarPage extends BaseClass{
    private final String startButton= "//button[@id='startStopButton']";
    private final String resetButton = "//button[@id='resetButton']";
    private final String progressBar = "//div[@role='progressbar']";

    public void clickStartButton(){
        click(startButton);
    }

    public Boolean verifyProgressBar(){
        return waitProgressBar(progressBar);
    }

    public Boolean verifyResetButton(){
        return isDisplayed(resetButton);
    } 
}
