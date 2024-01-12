package com.demoqa.pages.AlertsFrameWindows;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class AlertsPage extends BaseClass {

    private final String alertButton = "//button[@id='alertButton']";
    private final String textAlert = "You clicked a button";
    private final String timerAlertButton = "//button[@id='timerAlertButton']";
    private final String textTimerAlert = "This alert appeared after 5 seconds";
    private final String confirmButton = "//button[@id='confirmButton']";
    private final String confirmResult = "//span[@id='confirmResult']";
    private final String promtButton = "//button[@id='promtButton']";
    private final String promptResult = "//span[@id='promptResult']";

    public void clickPromptAlertButton() {
        click(promtButton);
    }

    public void TypeMessagePrompAlert(String text) {
        promptAlert(text);
    }

    public Boolean returnPromptResult (String text){
        if(getTextContent(promptResult).contains(text)){
            return true;
        }
        return false;
    }

    public void clickConfirmAlertButton() {
        click(confirmButton);
    }

    public void selectOkconfirmAlert() {
        confirmAlertOk();
    }

    public Boolean returnConfirmResultOK (){
        if(getTextContent(confirmResult).contains("Ok")){
            return true;
        }
        return false;
    }

    public void selectCancelconfirmAlert() {
        confirmAlertCancel();
    }

    public Boolean returnConfirmResultCancel (){
        if(getTextContent(confirmResult).contains("Cancel")){
            return true;
        }
        return false;
    }

    public void clickAlertButton() {
        click(alertButton);
    }

    public Boolean acceptAlert() {
        String text = acceptCommonAlert();
        if (text.equals(textAlert)) {
            return true;
        }
        return false;
    }

    public void clickTimerAlertButton() {
        click(timerAlertButton);
    }

    public Boolean acceptTimerAlert() {
        String text = acceptCommonAlert();
        if (text.equals(textTimerAlert)) {
            return true;
        }
        return false;
    }

    public void goToAlerts(HomePage homePage){
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToAlertsPage();
    }
}
