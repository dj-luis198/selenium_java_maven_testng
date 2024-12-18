package com.demoqa.pages.elements;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class WebTablesPage extends BaseClass {

    private final String addButton = "//button[@id='addNewRecordButton']";
    private final String formModal = "//div[@id='registration-form-modal']";
    private final String firstNameInput = "//input[@id='firstName']";
    private final String lastNameInput = "//input[@id='lastName']";
    private final String userEmailInput = "//input[@id='userEmail']";
    private final String ageInput = "//input[@id='age']";
    private final String salaryInput = "//input[@id='salary']";
    private final String departmentInput = "//input[@id='department']";
    private final String submitButton = "//button[@id='submit']";
    private final String nextButton = "//button[normalize-space()='Next']";
    private final String previousButton = "//div[@class='-previous']//button[@type='button']";
    private final String searchInput = "//input[@id='searchBox']";
    private final String rowsEmptyTable = "(//div[@role='rowgroup'])//child::div[contains(@class,'-padRow')]";
    private final String columnHeader = "(//div[contains(@role,'columnheader')])";
    private final String totalPages = "//span[@class='-totalPages']";
    private final String actualPageInput = "//div[@class='-pageJump']//child::input";
    private final String rowGrup = "rt-tr-group";
    private final String rowPerPage = "//select[@aria-label='rows per page']";

    public String getDataEdited(String index) {
        return BaseClass.getTextContent("//span[@id='" + index + "']//ancestor::div[@role='rowgroup']");
    }

    public void editUser(String fName, String lName, int age, String email, int salary, String depto) {
        this.createArrayListUserData(fName, lName, age, email, salary, depto);
        this.typeDataUser(fName, lName, age, email, salary, depto);
        this.clickSubmit();
    }

    public void clickEditOrDeleteUserButton(String index) {
        BaseClass.click("//span[@id='" + index + "']");
    }

    public String returnResultSearchDelete(String pers) {
        int rows = BaseClass.returnLength(rowGrup);

        if (BaseClass.getPageSource("-padRow")) {
            int rowsEmpty = BaseClass.returnElements(rowsEmptyTable).size();
            for (int i = 1; i <= (rows - rowsEmpty); i++) {
                if (pers.equals(BaseClass.getTextContent("(//div[@role='rowgroup'])[" + i
                        + "]"))) {
                    return BaseClass.getAttributeId("(//div[@role='rowgroup'])[" + i
                            + "]//child::span[@title='Delete']");
                }
            }
        }
        return "false";
    }

    public String returnResultSearch(String pers) {
        int rows = BaseClass.returnLength(rowGrup);

        if (BaseClass.getPageSource("-padRow")) {
            int rowsEmpty = BaseClass.returnElements(rowsEmptyTable).size();
            for (int i = 1; i <= (rows - rowsEmpty); i++) {
                if (pers.equals(BaseClass.getTextContent("(//div[@role='rowgroup'])[" + i
                        + "]"))) {
                    return BaseClass.getAttributeId("(//div[@role='rowgroup'])[" + i
                            + "]//child::span[@title='Edit']");
                }
            }
        }
        return "false";
    }

    public void search(String text) {
        BaseClass.type(searchInput, text);
    }

    public Boolean returnHaveResult() {
        int rows = BaseClass.returnLength(rowGrup);
        if (BaseClass.getPageSource("-padRow")) {
            int rowsEmpty = BaseClass.returnElements(rowsEmptyTable).size();
            if (!(rows == rowsEmpty)) {
                return true;
            }
        }
        return false;
    }

    public void ClickNextButton() {
        if (this.isEnabledButton(nextButton)) {
            BaseClass.click(nextButton);
        }
    }

    public void ClickPreviousButton() {
        if (this.isEnabledButton(previousButton)) {
            BaseClass.click(previousButton);
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
        List<WebElement> listOptions = BaseClass.selectGetOptions(rowPerPage);
        for (WebElement webElement : listOptions) {
            String text = webElement.getText();
            this.selectRowsPerPageTable(text);
            if (!text.equals(BaseClass.returnLength(rowGrup) + " rows")) {
                return false;
            }
        }
        return true;
    }

    public void selectRowsPerPageTable(String text) {
        BaseClass.selectPerText(rowPerPage, text);
    }

    public String verifyIsSelect() {
        return BaseClass.isSelectValue(rowPerPage);
    }

    public Boolean isEnabledButton(String locator) {
        return BaseClass.isEnabled(locator);
    }

    public void clickAddButton() {
        BaseClass.click(addButton);
    }

    public String returnTextForm() {
        return BaseClass.getTextContent(formModal);
    }

    public void typeFirstName(String text) {
        BaseClass.type(firstNameInput, text);
    }

    public void typeLastName(String text) {
        BaseClass.type(lastNameInput, text);
    }

    public void typeUserEmail(String text) {
        BaseClass.type(userEmailInput, text);
    }

    public void typeAge(int text) {
        BaseClass.type(ageInput, text + "");
    }

    public void typeSalary(int text) {
        BaseClass.type(salaryInput, text + "");
    }

    public void typeDepartment(String text) {
        BaseClass.type(departmentInput, text);
    }

    public void clickSubmit() {
        BaseClass.click(submitButton);
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
        String actualPage = BaseClass.getText(actualPageInput);
        String lastPage = BaseClass.getTextContent(totalPages);
        if (!actualPage.equals(lastPage)) {
            BaseClass.typeAndEnter(actualPageInput, lastPage);
        }
    }

    public Boolean verifyExistsUser(ArrayList<String> pers) {
        this.goToLastPageInput();
        int columns = BaseClass.returnLengthXpath(columnHeader);
        int rows = BaseClass.returnLength(rowGrup);
        if (BaseClass.getPageSource("-padRow")) {
            int rowsEmpty = BaseClass.returnElements(rowsEmptyTable).size();
            for (int i = 1; i <= (columns - 1); i++) {
                if (!pers.get(i - 1).equals(BaseClass.getTextContent("(//div[@role='rowgroup'])[" + (rows - rowsEmpty)
                        + "]//child::div[@role='gridcell'][" + i + "]"))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i <= (columns - 1); i++) {
                if (!pers.get(i - 1).equals(BaseClass.getTextContent("(//div[@role='rowgroup'])[" + (rows)
                        + "]//child::div[@role='gridcell'][" + i + "]"))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void goToWebTables(HomePage homePage) {
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToWebTablesPage();
    }
}
