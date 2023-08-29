package com.demoqa.pages.widgets;

import com.demoqa.base.BaseClass;

public class AutoCompletePage extends BaseClass {

    private final String autoCompleteMultipleInput = "//input[@id='autoCompleteMultipleInput']";
    private final String textAutocompleteMultiple = "//div[contains(@class,'auto-complete__control')][1]";
    private final String deleteAllColors = "//div[contains(@class,'clear-indicator')]";
    private final String autoCompleteSingleInput = "//input[@id='autoCompleteSingleInput']";
    private final String textAutocompleteSingle = "//div[@id='autoCompleteSingleContainer']//child::div[contains(@class,'auto-complete__control')]";

    public void typeColorSingle(String text) {
        type(autoCompleteSingleInput, text);
    }

    public void selectSingleColor(String text) {
        click("//div[contains(@id,'react-select-3-option-')][text()='" + text + "']");
    }

    public String returnSelectOption() {
        return getTextContent(textAutocompleteSingle);
    }

    public void typeColorMultiple(String text) {
        type(autoCompleteMultipleInput, text);
    }

    public void selectColor(String text) {
        click("//div[contains(@id,'react-select-2-option-')][text()='" + text + "']");
    }

    public String returnSelectOptions() {
        return getTextContent(textAutocompleteMultiple);
    }

    public void deleteColor(String text) {
        click("//div[contains(text(),'" + text + "')]//following-sibling::div");
    }

    public void deleteAllColors() {
        click(deleteAllColors);
    }
}
