package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class AutoCompletePage extends BaseClass {

    private final String autoCompleteMultipleInput = "//input[@id='autoCompleteMultipleInput']";
    private final String textAutocompleteMultiple = "//div[contains(@class,'auto-complete__control')][1]";
    private final String deleteAllColors = "//div[contains(@class,'clear-indicator')]";
    private final String autoCompleteSingleInput = "//input[@id='autoCompleteSingleInput']";
    private final String textAutocompleteSingle = "//div[@id='autoCompleteSingleContainer']//child::div[contains(@class,'auto-complete__control')]";

    public void typeColorSingle(String text) {
        BaseClass.type(autoCompleteSingleInput, text);
    }

    public void selectSingleColor(String text) {
        BaseClass.click("//div[contains(@id,'react-select-3-option-')][text()='" + text + "']");
    }

    public String returnSelectOption() {
        return BaseClass.getTextContent(textAutocompleteSingle);
    }

    public void typeColorMultiple(String text) {
        BaseClass.type(autoCompleteMultipleInput, text);
    }

    public void selectColor(String text) {
        BaseClass.click("//div[contains(@id,'react-select-2-option-')][text()='" + text + "']");
    }

    public String returnSelectOptions() {
        return BaseClass.getTextContent(textAutocompleteMultiple);
    }

    public void deleteColor(String text) {
        BaseClass.click("//div[contains(text(),'" + text + "')]//following-sibling::div");
    }

    public void deleteAllColors() {
        BaseClass.click(deleteAllColors);
    }

    public void goToAutoComplete(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToAutoCompletePage();
    }
}
