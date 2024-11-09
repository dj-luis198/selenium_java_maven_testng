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
        BaseClass.click(promtButton);
    }

    public void TypeMessagePrompAlert(String text) {
        BaseClass.promptAlert(text);
    }

    public Boolean returnPromptResult (String text){
        if(BaseClass.getTextContent(promptResult).contains(text)){
            return true;
        }
        return false;
    }

    public void clickConfirmAlertButton() {
        BaseClass.click(confirmButton);
    }

    public void selectOkconfirmAlert() {
        BaseClass.confirmAlertOk();
    }

    public Boolean returnConfirmResultOK (){
        if(BaseClass.getTextContent(confirmResult).contains("Ok")){
            return true;
        }
        return false;
    }

    public void selectCancelconfirmAlert() {
        BaseClass.confirmAlertCancel();
    }

    public Boolean returnConfirmResultCancel (){
        if(BaseClass.getTextContent(confirmResult).contains("Cancel")){
            return true;
        }
        return false;
    }

    public void clickAlertButton() {
        BaseClass.click(alertButton);
    }

    public Boolean acceptAlert() {
        String text = BaseClass.acceptCommonAlert();
        if (text.equals(textAlert)) {
            return true;
        }
        return false;
    }

    public void clickTimerAlertButton() {
        BaseClass.click(timerAlertButton);
    }

    public Boolean acceptTimerAlert() {
        String text = BaseClass.acceptCommonAlert();
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
