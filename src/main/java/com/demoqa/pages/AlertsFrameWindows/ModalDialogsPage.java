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
        BaseClass.click(showLargeModalButton);
    }

    public Boolean verifyTitleLargeModal() {
        if (BaseClass.getTextContent(headerTitleLargeModal).equals("Large Modal")) {
            return true;
        }
        return false;
    }

    public Boolean verifyTextBodyLargeModal() {
        if (BaseClass.getTextContent(bodyLargeModal).contains("Lorem")) {
            return true;
        }
        return false;
    }

    public void closeLargeModal() {
        BaseClass.click(closeLargeModalButton);
    }

    public void closeLargeModalX() {
        BaseClass.click(closeLargeModalButtonX);
    }

    public Boolean verifyFadeModalBackdropIsVisible(){
        return BaseClass.isDisplayed(FadeModalBackdrop);
    }

    public Boolean verifyDialogModalIsVisible(){
        return BaseClass.isDisplayed(dialog);
    }

    public Boolean verifyFadeModalBackdropIsNoVisible(){
        return BaseClass.getPageSource(FadeModalBackdropSource);
    }

    public Boolean verifyDialogModalIsNoVisible(){
        return BaseClass.getPageSource(dialogSource);
    }

    public void clickShowSmallModalButton() {
        BaseClass.click(showSmallModalButton);
    }

    public Boolean verifyTitleSmallModal() {
        if (BaseClass.getTextContent(headerTitleSmallModal).equals("Small Modal")) {
            return true;
        }
        return false;
    }

    public Boolean verifyTextBodySmallModal() {
        if (BaseClass.getTextContent(bodySmallModal).equals("This is a small modal. It has very less content")) {
            return true;
        }
        return false;
    }

    public void closeSmallModal() {
        BaseClass.click(closeSmallModalButton);
    }

    public void closeSmallModalX() {
        BaseClass.click(closeSmallModalButtonX);
    }

    public void goToModalDialogs(){
        HomePage homePage= new HomePage();
        homePage.goToHome();
        homePage.goToModalDialogsPage(); 
    }
}
