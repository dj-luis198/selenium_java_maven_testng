package com.demoqa.pages.forms;

import java.io.File;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class FormPage extends BaseClass {
    private File file;

    private final String firstNameInput = "//input[@id='firstName']";
    private final String lastNameInput = "//input[@id='lastName']";
    private final String userEmailInput = "//input[@id='userEmail']";
    private final String radioButton = "//input[contains(@id,'gender-radio-')]/following-sibling::label";
    private final String radiosButtons = "//input[contains(@id,'gender-radio-')]";
    private final String userNumberInput = "//input[@id='userNumber']";
    private final String dateOfBirthInput = "//input[@id='dateOfBirthInput']";
    private final String monthSelect = "//select[@class='react-datepicker__month-select']";
    private final String yearSelect = "//select[@class='react-datepicker__year-select']";
    private final String autoCompleteInput = "//input[@id='subjectsInput']";
    private final String containerAutoComplete = "//div[contains(@class,'subjects-auto-complete__control')]";
    private final String hobbiesCheckbox = "//label[contains(@for,'hobbies-checkbox-')]";
    private final String hobbiesValue = "//input[contains(@id,'hobbies-checkbox-')]";
    private final String uploadFileInput = "//input[@id='uploadPicture']";
    private final String state = "//div[@id='state']";
    private final String stateOption = "//div[contains(@class,'-singleValue')]";
    private final String city = "//div[@id='city']";
    private final String cityOption = "(//div[contains(@class,'-singleValue')])[2]";
    private final String submitButton = "//button[@id='submit']";

    public void clickSubmit() {
        click(submitButton);
    }

    public void selectCity(String text) {
        click(city);
        click("//div[contains(@id,'react-select-4-option-')][contains(text(),'" + text + "')]");
    }

    public Boolean verifyCity(String text) {
        if (getAttributeInnerText(cityOption).equals(text)) {
            return true;
        }
        return false;
    }

    public Boolean verifyState(String text) {
        if (getAttributeInnerText(stateOption).equals(text)) {
            return true;
        }
        return false;
    }

    public void selectState(String text) {
        click(state);
        click("//div[contains(@id,'react-select-3-option-')][contains(text(),'" + text + "')]");
    }

    public void uploadFile() {
        file = new File("files/img.png");
        type(uploadFileInput, file.getAbsolutePath());
    }

    public Boolean verifyuploadedFilePath() {
        if (getText(uploadFileInput).contains(file.getName())) {
            return true;
        }
        return false;
    }

    public void selectHobbie(String text) {
        List<WebElement> listHobbies = returnElements(hobbiesCheckbox);
        for (WebElement hobbie : listHobbies) {
            if (getAttributeElementContent(hobbie).equals(text)) {
                clickElement(hobbie);
            }
        }
    }

    public Boolean verifySelectedHobbies(String text) {
        List<WebElement> list = returnElements(hobbiesValue);
        for (WebElement option : list) {
            if (isSelected(option)) {
                if (getAttributeDefaultValue(option).equals("1") && (text.equals("Sports"))) {
                    return true;
                } else {
                    if (getAttributeDefaultValue(option).equals("2") && (text.equals("Reading"))) {
                        return true;
                    } else {
                        if (getAttributeDefaultValue(option).equals("3") && (text.equals("Music"))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void typeSubjectsMultiple(String text) {
        typeSimple(autoCompleteInput, text);
    }

    public void selectSubjects(String text) {
        click("//div[contains(@id,'react-select-2-option-')][text()='" + text + "']");
    }

    public String returnSelectOptions() {
        return getTextContent(containerAutoComplete);
    }

    public void selectDay(String day, String month) {
        List<WebElement> listDays = returnElements(
                "//div[@class='react-datepicker__week']//child::div[contains(@aria-label,'" + month + "')]");
        int sizeList = returnLengthXpath(
                "//div[@class='react-datepicker__week']//child::div[contains(@aria-label,'" + month + "')]");
        int lastDay = Integer.parseInt(getAttributeElementContent(listDays.get(sizeList - 1)));
        if (Integer.parseInt(day) <= lastDay) {
            for (WebElement elementDay : listDays) {
                if (day.equals(getAttributeElementContent(elementDay))) {
                    clickElementJS(elementDay);
                    break;
                }
            }
        }
    }

    public Boolean verifyDay(String day, String month) {
        clickJS(dateOfBirthInput);
        if (day.equals(getTextContent("//div[contains(@class,'react-datepicker__day--selected')]"))) {
            return true;
        }
        return false;
    }

    public void selectMonth(String month) {
        selectPerText(monthSelect, month);
    }

    public String verifyMonth() {
        return isSelectInnerText(monthSelect);
    }

    public void selectYear(String year) {
        selectPerText(yearSelect, year);
    }

    public String verifyYear() {
        return isSelectValue(yearSelect);
    }

    public void clickDatePicker() {
        clickJS(dateOfBirthInput);
    }

    public void typeUserNumer(String text) {
        type(userNumberInput, text);
    }

    public String verifyUserNumber() {
        return getText(userNumberInput);
    }

    public void selectRadioGender(String text) {
        List<WebElement> list = returnElements(radioButton);
        for (WebElement option : list) {
            if (getAttributeElementContent(option).equals(text)) {
                clickElement(option);
            }
        }
    }

    public Boolean verifySelectedGender(String text) {
        List<WebElement> list = returnElements(radiosButtons);
        for (WebElement option : list) {
            if (isSelected(option)) {
                if (getAttributeDefaultValue(option).equals(text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void typeFirstName(String text) {
        type(firstNameInput, text);
    }

    public void typeLastName(String text) {
        type(lastNameInput, text);
    }

    public void typeUserEmail(String text) {
        type(userEmailInput, text);
    }

    public String verifyEmail() {
        return getText(userEmailInput);
    }

    public String verifyFirstName() {
        return getText(firstNameInput);
    }

    public String verifyLastName() {
        return getText(lastNameInput);
    }

    public void goToForms(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToFormsPage();
    }

}
