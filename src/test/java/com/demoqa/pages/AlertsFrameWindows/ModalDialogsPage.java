package com.demoqa.pages.AlertsFrameWindows;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class ModalDialogsPage extends BaseClass {
    private final String FadeModalBackdrop = "//div[@class='fade modal-backdrop show']";
    private final String dialog = "//div[@role='dialog']";
    private final String FadeModalBackdropSource = "fade modal-backdrop show";
    private final String dialogSource = "fade modal show";
    private final String showSmallModalButton = "//button[@id='showSmallModal']";
    private final String headerTitleSmallModal = "//div[@id='example-modal-sizes-title-sm']";
    private final String bodySmallModal = "//div[@class='modal-body']";
    private final String closeSmallModalButton = "//button[@id='closeSmallModal']";
    private final String closeSmallModalButtonX = "//button[@class='close']";
    private final String showLargeModalButton = "//button[@id='showLargeModal']";
    private final String headerTitleLargeModal = "//div[@id='example-modal-sizes-title-lg']";
    private final String bodyLargeModal = "//div[@class='modal-body']/p";
    private final String closeLargeModalButton = "//button[@id='closeLargeModal']";
    private final String closeLargeModalButtonX = "//button[@class='close']";

    public void clickShowLargeModalButton() {
        click(showLargeModalButton);
    }

    public Boolean verifyTitleLargeModal() {
        if (getTextContent(headerTitleLargeModal).equals("Large Modal")) {
            return true;
        }
        return false;
    }

    public Boolean verifyTextBodyLargeModal() {
        if (getTextContent(bodyLargeModal).contains("Lorem")) {
            return true;
        }
        return false;
    }

    public void closeLargeModal() {
        click(closeLargeModalButton);
    }

    public void closeLargeModalX() {
        click(closeLargeModalButtonX);
    }

    public Boolean verifyFadeModalBackdropIsVisible(){
        return isDisplayed(FadeModalBackdrop);
    }

    public Boolean verifyDialogModalIsVisible(){
        return isDisplayed(dialog);
    }

    public Boolean verifyFadeModalBackdropIsNoVisible(){
        return getPageSource(FadeModalBackdropSource);
    }

    public Boolean verifyDialogModalIsNoVisible(){
        return getPageSource(dialogSource);
    }

    public void clickShowSmallModalButton() {
        click(showSmallModalButton);
    }

    public Boolean verifyTitleSmallModal() {
        if (getTextContent(headerTitleSmallModal).equals("Small Modal")) {
            return true;
        }
        return false;
    }

    public Boolean verifyTextBodySmallModal() {
        if (getTextContent(bodySmallModal).equals("This is a small modal. It has very less content")) {
            return true;
        }
        return false;
    }

    public void closeSmallModal() {
        click(closeSmallModalButton);
    }

    public void closeSmallModalX() {
        click(closeSmallModalButtonX);
    }

    public void goToModalDialogs(){
        HomePage homePage= new HomePage();
        homePage.goToHome();
        homePage.goToModalDialogsPage(); 
    }
}
