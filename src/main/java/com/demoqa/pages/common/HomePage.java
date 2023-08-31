package com.demoqa.pages.common;

import com.demoqa.base.BaseClass;

public class HomePage extends BaseClass {

    private final String elementsText = "//h5[normalize-space()='Elements']";
    private final String AlertsFrameWindowsText = "//h5[normalize-space()='Alerts, Frame & Windows']";
    private final String textBox = "//*[contains(text(),\"Text Box\")]";
    private final String checkBox = "//*[contains(text(),\"Check Box\")]";
    private final String radioButton = "(//li[@id='item-2'])[1]";
    private final String webTables = "//span[normalize-space()='Web Tables']";
    private final String buttons = "//span[normalize-space()='Buttons']";
    private final String links = "//span[normalize-space()='Links']";
    private final String brokenLinksImages = "//span[normalize-space()='Broken Links - Images']";
    private final String uploadAndDownload = "//span[normalize-space()='Upload and Download']";
    private final String dynamicProperties = "//span[normalize-space()='Dynamic Properties']";
    private final String BrowserWindows = "//span[normalize-space()='Browser Windows']";
    private final String alerts = "//span[normalize-space()='Alerts']";
    private final String frames = "//span[normalize-space()='Frames']";
    private final String nestedFrames = "//span[normalize-space()='Nested Frames']";
    private final String modalDialogs = "//span[normalize-space()='Modal Dialogs']";
    private final String widgets = "//div[normalize-space()='Widgets']";
    private final String accordian = "//span[normalize-space()='Accordian']";
    private final String autoComplete = "//span[normalize-space()='Auto Complete']";
    private final String datePicker = "//span[normalize-space()='Date Picker']";
    private final String slider = "//span[normalize-space()='Slider']";
    private final String progressBar = "//span[normalize-space()='Progress Bar']";

    public String getTitleHomePage() {
        return getTitlePage();
    }

    public void SelectProgressBarItem() {
        click(progressBar);
    }

    public void SelectSliderItem() {
        click(slider);
    }

    public void SelectDatePickerItem() {
        click(datePicker);
    }

    public void SelectAutoCompleteItem() {
        click(autoComplete);
    }

    public void SelectAccordianItem() {
        click(accordian);
    }

    public void SelectModalDialogsItem() {
        click(modalDialogs);
    }

    public void SelectNestedFramesItem() {
        click(nestedFrames);
    }

    public void SelectFramesItem() {
        click(frames);
    }

    public void SelectAlertsItem() {
        click(alerts);
    }

    public void SelectBrowserWindowsItem() {
        click(BrowserWindows);
    }

    public void SelectDynamicPropertiesItem() {
        click(dynamicProperties);
    }

    public void SelectUploadAndDownloadItem() {
        click(uploadAndDownload);
    }

    public void SelectBrokenLinksImagesItem() {
        click(brokenLinksImages);
    }

    public void SelectElements() {
        click(elementsText);
    }

    public void SelectWidgets() {
        click(widgets);
    }

    public void SelectAlertsFrameWindows() {
        click(AlertsFrameWindowsText);
    }

    public void SelectLinksItem() {
        click(links);
    }

    public void SelectTextBoxItem() {
        click(textBox);
    }

    public void SelectCheckBoxItem() {
        click(checkBox);
    }

    public void SelectRadioButtonItem() {
        click(radioButton);
    }

    public void SelectWebTablesItem() {
        click(webTables);
    }

    public void SelectButtonsItem() {
        click(buttons);
    }

    public void goToTextBoxPage() {
        this.SelectElements();
        this.SelectTextBoxItem();
    }

    public void goToCheckBoxPage() {
        this.SelectElements();
        this.SelectCheckBoxItem();
    }

    public void goToRadioButtonPage() {
        this.SelectElements();
        this.SelectRadioButtonItem();
    }

    public void goToWebTablesPage() {
        this.SelectElements();
        this.SelectWebTablesItem();
    }

    public void goToButtonsPage() {
        this.SelectElements();
        this.SelectButtonsItem();
    }

    public void goToLinksPage() {
        this.SelectElements();
        this.SelectLinksItem();
    }

    public void goToBrokenLinksImagesPage() {
        this.SelectElements();
        this.SelectBrokenLinksImagesItem();
    }

    public void goToUploadAndDownloadPage() {
        this.SelectElements();
        this.SelectUploadAndDownloadItem();
    }

    public void goToDynamicPropertiesPage() {
        this.SelectElements();
        this.SelectDynamicPropertiesItem();
    }

    public void goToAlertsFrameWindowsPage() {
        this.SelectAlertsFrameWindows();
        this.SelectBrowserWindowsItem();
    }

    public void goToAlertsPage() {
        this.SelectAlertsFrameWindows();
        this.SelectAlertsItem();
    }

    public void goToFramesPage() {
        this.SelectAlertsFrameWindows();
        this.SelectFramesItem();
    }

    public void goToNestedFramesPage() {
        this.SelectAlertsFrameWindows();
        this.SelectNestedFramesItem();
    }

    public void goToModalDialogsPage() {
        this.SelectAlertsFrameWindows();
        this.SelectModalDialogsItem();
    }

    public void goToAccordianPage() {
        this.SelectWidgets();
        this.SelectAccordianItem();
    }

    public void goToAutoCompletePage() {
        this.SelectWidgets();
        this.SelectAutoCompleteItem();
    }

    public void goToDatePickerPage() {
        this.SelectWidgets();
        this.SelectDatePickerItem();
    }

    public void goToSliderPage() {
        this.SelectWidgets();
        this.SelectSliderItem();
    }

    public void goToProgressBarPage() {
        this.SelectWidgets();
        this.SelectProgressBarItem();
    }
}
