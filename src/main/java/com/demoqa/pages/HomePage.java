package com.demoqa.pages;

import com.demoqa.base.BaseClass;

public class HomePage extends BaseClass {

    private static String elementsText = "//div[@class=\"card mt-4 top-card\"][1]//div[@class=\"card-body\"]";
    private static String textBox = "//*[contains(text(),\"Text Box\")]";
    private static String checkBox = "//*[contains(text(),\"Check Box\")]";
    private static String radioButton = "(//li[@id='item-2'])[1]";
    private static String webTables = "//span[normalize-space()='Web Tables']";
    private static String buttons = "//span[normalize-space()='Buttons']";

    public String getTitleHomePage() {
        return getTitlePage();
    }

    public void SelectElements() {
        click(elementsText);
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

}
