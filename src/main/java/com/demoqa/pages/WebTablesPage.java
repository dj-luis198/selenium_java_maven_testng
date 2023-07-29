package com.demoqa.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.demoqa.base.BaseClass;

public class WebTablesPage extends BaseClass {

    private static String addButton = "//button[@id='addNewRecordButton']";
    private static String formModal = "//div[@id='registration-form-modal']";
    private static String firstNameInput = "//input[@id='firstName']";
    private static String lastNameInput = "//input[@id='lastName']";
    private static String userEmailInput = "//input[@id='userEmail']";
    private static String ageInput = "//input[@id='age']";
    private static String salaryInput = "//input[@id='salary']";
    private static String departmentInput = "//input[@id='department']";
    private static String submitButton = "//button[@id='submit']";
    private static String nextButton = "//button[normalize-space()='Next']";
    private static String previousButton = "//div[@class='-previous']//button[@type='button']";
    private static String searchInput = "//input[@id='searchBox']";
    private static String rowsEmptyTable = "(//div[@role='rowgroup'])//child::div[contains(@class,'-padRow')]";
    private static String columnHeader = "(//div[contains(@role,'columnheader')])";
    private static String totalPages = "//span[@class='-totalPages']";
    private static String actualPageInput = "//div[@class='-pageJump']//child::input";
    private static String rowGrup = "rt-tr-group";
    private static String rowPerPage = "//select[@aria-label='rows per page']";

     public WebTablesPage(WebDriver driver) {
        BaseClass.driver = driver;
    }

    public String getDataEdited(String index) {
        return getTextContent("//span[@id='" + index + "']//ancestor::div[@role='rowgroup']");
    }

    public void editUser(String fName, String lName, int age, String email, int salary, String depto) {
        this.createArrayListUserData(fName, lName, age, email, salary, depto);
        this.typeDataUser(fName, lName, age, email, salary, depto);
        this.clickSubmit();
    }

    public void clickEditOrDeleteUserButton(String index) {
        click("//span[@id='" + index + "']");
    }

    public String returnResultSearchDelete(String pers) {
        int rows = returnLength(rowGrup);

        if (getPageSource("-padRow")) {
            int rowsEmpty = returnXpath(rowsEmptyTable).size();
            for (int i = 1; i <= (rows - rowsEmpty); i++) {
                if (pers.equals(getTextContent("(//div[@role='rowgroup'])[" + i
                        + "]"))) {
                    return getAttributeId("(//div[@role='rowgroup'])[" + i
                            + "]//child::span[@title='Delete']");
                }
            }
        }
        return "false";
    }

    public String returnResultSearch(String pers) {
        int rows = returnLength(rowGrup);

        if (getPageSource("-padRow")) {
            int rowsEmpty = returnXpath(rowsEmptyTable).size();
            for (int i = 1; i <= (rows - rowsEmpty); i++) {
                if (pers.equals(getTextContent("(//div[@role='rowgroup'])[" + i
                        + "]"))) {
                    return getAttributeId("(//div[@role='rowgroup'])[" + i
                            + "]//child::span[@title='Edit']");
                }
            }
        }
        return "false";
    }

    public void search(String text) {
        type(searchInput, text);
    }

    public Boolean returnHaveResult() {
        int rows = returnLength(rowGrup);
        if (getPageSource("-padRow")) {
            int rowsEmpty = returnXpath(rowsEmptyTable).size();
            if (!(rows == rowsEmpty)) {
                return true;
            }
        }
        return false;
    }

    public void ClickNextButton() {
        if (this.isEnabledButton(nextButton)) {
            click(nextButton);
        }
    }

    public void ClickPreviousButton() {
        if (this.isEnabledButton(previousButton)) {
            click(previousButton);
        }
    }

    public Boolean isEnabledPreviousButton() {
        return this.isEnabledButton(previousButton);
    }

    public Boolean isEnabledNextButton() {
        return this.isEnabledButton(nextButton);
    }

    public void selectRowsPerPageManualy(String text) {
        this.selectRowsPerPageTable(text);
    }

    public Boolean selectRowsPerPage() {
        List<WebElement> listOptions = selectGetOptions(rowPerPage);
        for (WebElement webElement : listOptions) {
            String text = webElement.getText();
            this.selectRowsPerPageTable(text);
            if (!text.equals(returnLength(rowGrup) + " rows")) {
                return false;
            }
        }
        return true;
    }

    public Boolean selectRowsPerPageTable(String text) {
        return selectPerText(rowPerPage, text);
    }

    public Boolean isEnabledButton(String locator) {
        return isEnabled(locator);
    }

    public void clickAddButton() {
        click(addButton);
    }

    public String returnTextForm() {
        return getTextContent(formModal);
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

    public void typeAge(int text) {
        type(ageInput, text + "");
    }

    public void typeSalary(int text) {
        type(salaryInput, text + "");
    }

    public void typeDepartment(String text) {
        type(departmentInput, text);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public ArrayList<String> createArrayListUserData(String fName, String lName, int age, String email, int salary,
            String depto) {
        ArrayList<String> pers = new ArrayList<String>();
        pers.add(fName);
        pers.add(lName);
        pers.add(age + "");
        pers.add(email);
        pers.add(salary + "");
        pers.add(depto);

        return pers;
    }

    public void typeDataUser(String fName, String lName, int age, String email, int salary, String depto) {
        this.typeFirstName(fName);
        this.typeLastName(lName);
        this.typeAge(age);
        this.typeUserEmail(email);
        this.typeSalary(salary);
        this.typeDepartment(depto);
    }

    public Boolean register(String fName, String lName, int age, String email, int salary, String depto) {
        ArrayList<String> pers = this.createArrayListUserData(fName, lName, age, email, salary, depto);
        this.typeDataUser(fName, lName, age, email, salary, depto);
        this.clickSubmit();
        return this.verifyExistsUser(pers);
    }

    public void goToLastPageInput() {
        String actualPage = getText(actualPageInput);
        String lastPage = getTextContent(totalPages);
        if (!actualPage.equals(lastPage)) {
            typeAndEnter(actualPageInput, lastPage);
        }
    }

    public Boolean verifyExistsUser(ArrayList<String> pers) {
        this.goToLastPageInput();
        int columns = returnLengthXpath(columnHeader);
        int rows = returnLength(rowGrup);
        if (getPageSource("-padRow")) {
            int rowsEmpty = returnXpath(rowsEmptyTable).size();
            for (int i = 1; i <= (columns - 1); i++) {
                if (!pers.get(i - 1).equals(getTextContent("(//div[@role='rowgroup'])[" + (rows - rowsEmpty)
                        + "]//child::div[@role='gridcell'][" + i + "]"))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i <= (columns - 1); i++) {
                if (!pers.get(i - 1).equals(getTextContent("(//div[@role='rowgroup'])[" + (rows)
                        + "]//child::div[@role='gridcell'][" + i + "]"))) {
                    return false;
                }
            }
        }
        return true;
    }
}
