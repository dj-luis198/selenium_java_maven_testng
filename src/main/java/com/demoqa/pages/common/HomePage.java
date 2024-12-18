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
    private final String widgets = "//h5[normalize-space()='Widgets']";
    private final String accordian = "//span[normalize-space()='Accordian']";
    private final String autoComplete = "//span[normalize-space()='Auto Complete']";
    private final String datePicker = "//span[normalize-space()='Date Picker']";
    private final String slider = "//span[normalize-space()='Slider']";
    private final String progressBar = "//span[normalize-space()='Progress Bar']";
    private final String tabs = "//span[normalize-space()='Tabs']";
    private final String toolTips = "//span[normalize-space()='Tool Tips']";
    private final String menu = "//span[normalize-space()='Menu']";
    private final String selectMenu = "//span[normalize-space()='Select Menu']";
    private final String forms = "//h5[normalize-space()='Forms']";
    private final String practiceForm = "//span[normalize-space()='Practice Form']";
    private final String bookStore = "//h5[normalize-space()='Book Store Application']";
    private final String login = "//span[normalize-space()='Login']";

    public void SelectBookStoreItem() {
        BaseClass.click(login);
    }

    public void SelectBookStore() {
        goToHome();
        BaseClass.click(bookStore);
    }

    public void goToHome() {
        BaseClass.goTo();
    }

    public String getTitleHomePage() {
        return BaseClass.getTitlePage();
    }

    public void SelectPracticeFormItem() {
        BaseClass.click(practiceForm);
    }

    public void SelectForms() {
        BaseClass.click(forms);
    }

    public void SelectSelectMenuItem() {
        BaseClass.click(selectMenu);
    }

    public void SelectMenuItem() {
        BaseClass.click(menu);
    }

    public void SelectToolTipsItem() {
        BaseClass.click(toolTips);
    }

    public void SelectTabsItem() {
        BaseClass.click(tabs);
    }

    public void SelectProgressBarItem() {
        BaseClass.click(progressBar);
    }

    public void SelectSliderItem() {
        BaseClass.click(slider);
    }

    public void SelectDatePickerItem() {
        BaseClass.click(datePicker);
    }

    public void SelectAutoCompleteItem() {
        BaseClass.click(autoComplete);
    }

    public void SelectAccordianItem() {
        BaseClass.click(accordian);
    }

    public void SelectModalDialogsItem() {
        BaseClass.click(modalDialogs);
    }

    public void SelectNestedFramesItem() {
        BaseClass.click(nestedFrames);
    }

    public void SelectFramesItem() {
        BaseClass.click(frames);
    }

    public void SelectAlertsItem() {
        BaseClass.click(alerts);
    }

    public void SelectBrowserWindowsItem() {
        BaseClass.click(BrowserWindows);
    }

    public void SelectDynamicPropertiesItem() {
        BaseClass.click(dynamicProperties);
    }

    public void SelectUploadAndDownloadItem() {
        BaseClass.click(uploadAndDownload);
    }

    public void SelectBrokenLinksImagesItem() {
        BaseClass.click(brokenLinksImages);
    }

    public void SelectElements() {
        BaseClass.click(elementsText);
    }

    public void SelectWidgets() {
        BaseClass.click(widgets);
    }

    public void SelectAlertsFrameWindows() {
        BaseClass.click(AlertsFrameWindowsText);
    }

    public void SelectLinksItem() {
        BaseClass.click(links);
    }

    public void SelectTextBoxItem() {
        BaseClass.click(textBox);
    }

    public void SelectCheckBoxItem() {
        BaseClass.click(checkBox);
    }

    public void SelectRadioButtonItem() {
        BaseClass.click(radioButton);
    }

    public void SelectWebTablesItem() {
        BaseClass.click(webTables);
    }

    public void SelectButtonsItem() {
        BaseClass.click(buttons);
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

    public void goToTabsPage() {
        this.SelectWidgets();
        this.SelectTabsItem();
    }

    public void goToToolTipsPage() {
        this.SelectWidgets();
        this.SelectToolTipsItem();
    }

    public void goToMenuPage() {
        this.SelectWidgets();
        this.SelectMenuItem();
    }

    public void goToSelectMenuPage() {
        this.SelectWidgets();
        this.SelectSelectMenuItem();
    }

    public void goToFormsPage() {
        this.SelectForms();
        this.SelectPracticeFormItem();
    }

    public void goToLoginPage() {
        this.SelectBookStore();
        this.SelectBookStoreItem();
    }
}
