package com.demoqa.test.gui.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.WebTablesPage;
import com.demoqa.util.AnsiColorUtils;

import net.datafaker.Faker;

@Test(groups = "WebTablesTest")
public class WebTablesTest extends BaseTest {
    Faker faker = new Faker();
    String firstName, lastName, email, department;
    int salary, age;
    private HomePage homePage;
    private WebTablesPage webTablesPage;

    private static Logger logger= LogManager.getLogger(WebTablesTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            webTablesPage = new WebTablesPage();
            webTablesPage.goToWebTables(homePage);
        } catch (Exception e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
            Assert.fail();
        }
    }

    @Test(description = "Validate enter 10 users")
    public void webTables() {
        for (int i = 1; i <= 10; i++) {
            firstName = faker.name().firstName();
            lastName = faker.name().lastName();
            age = faker.number().numberBetween(18, 100);
            email = faker.internet().emailAddress();
            salary = faker.number().numberBetween(1000, 50000);
            department = faker.name().lastName();

            webTablesPage.clickAddButton();
            Assert.assertEquals(webTablesPage.returnTextForm(), "Registration Form");
            Boolean status = webTablesPage.register(firstName, lastName, age, email, salary, department);
            Assert.assertTrue(status);
        }
    }

    @Test(description = "Validate select rows per page")
    public void selectRowsPerPageTable() {
        Boolean status = webTablesPage.selectRowsPerPage();
        Assert.assertTrue(status);
    }

    @Test(description = "Validate button Next and Previous")
    public void validateNextAndPreviousButton() {
        webTablesPage.selectRowsPerPageManualy("5 rows");
        for (int i = 1; i <= 6; i++) {
            firstName = faker.name().firstName();
            lastName = faker.name().lastName();
            age = faker.number().numberBetween(18, 100);
            email = faker.internet().emailAddress();
            salary = faker.number().numberBetween(1000, 50000);
            department = faker.name().lastName();
            webTablesPage.clickAddButton();
            Assert.assertEquals(webTablesPage.returnTextForm(), "Registration Form");
            webTablesPage.register(firstName, lastName, age, email, salary, department);
        }
        Assert.assertEquals(webTablesPage.verifyIsSelect(), "5");
        Assert.assertTrue(webTablesPage.isEnabledPreviousButton());
        Assert.assertFalse(webTablesPage.isEnabledNextButton());
        webTablesPage.ClickPreviousButton();
        Assert.assertTrue(webTablesPage.isEnabledNextButton());
        Assert.assertFalse(webTablesPage.isEnabledPreviousButton());
        webTablesPage.ClickNextButton();
        Assert.assertTrue(webTablesPage.isEnabledPreviousButton());
        Assert.assertFalse(webTablesPage.isEnabledNextButton());
    }

    @Test(description = "Validate search user")
    public void SearchUser() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        age = faker.number().numberBetween(18, 100);
        email = faker.internet().emailAddress();
        salary = faker.number().numberBetween(1000, 50000);
        department = faker.name().lastName();

        String resultSearch = firstName + lastName + age + email + salary + department + " ";
        webTablesPage.clickAddButton();
        Assert.assertEquals(webTablesPage.returnTextForm(), "Registration Form");
        webTablesPage.register(firstName, lastName, age, email, salary, department);
        String searchText = firstName.substring(0, 3);
        webTablesPage.search(searchText);
        Assert.assertTrue(webTablesPage.returnHaveResult());
        Assert.assertTrue(!(webTablesPage.returnResultSearch(resultSearch).equals("false")));
    }

    @Test(description = "Validate edit user")
    public void editUser() {
        String firstNameEdit = faker.name().firstName();
        String lastNameEdit = faker.name().lastName();
        int ageEdit = faker.number().numberBetween(18, 100);
        String emailEdit = faker.internet().emailAddress();
        int salaryEdit = faker.number().numberBetween(1000, 50000);
        String departmentEdit = faker.name().lastName();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        age = faker.number().numberBetween(18, 100);
        email = faker.internet().emailAddress();
        salary = faker.number().numberBetween(1000, 50000);
        department = faker.name().lastName();

        String searchText = firstName.substring(0, 3);
        String resultSearch = firstName + lastName + age + email + salary + department + " ";
        String resultEdit = firstNameEdit + lastNameEdit + ageEdit + emailEdit + salaryEdit + departmentEdit + " ";
        webTablesPage.clickAddButton();
        Assert.assertEquals(webTablesPage.returnTextForm(), "Registration Form");
        webTablesPage.register(firstName, lastName, age, email, salary, department);
        webTablesPage.search(searchText);
        Assert.assertTrue(webTablesPage.returnHaveResult());
        String index = webTablesPage.returnResultSearch(resultSearch);
        Assert.assertTrue(!(index.equals("false")));
        webTablesPage.clickEditOrDeleteUserButton(index);
        webTablesPage.editUser(firstNameEdit, lastNameEdit, ageEdit, emailEdit, salaryEdit, departmentEdit);
        webTablesPage.search(firstNameEdit);
        Assert.assertTrue(webTablesPage.getDataEdited(index).equals(resultEdit));
    }

    @Test(description = "Validate delete user")
    public void deleteUser() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        age = faker.number().numberBetween(18, 100);
        email = faker.internet().emailAddress();
        salary = faker.number().numberBetween(1000, 50000);
        department = faker.name().lastName();

        String resultSearch = firstName + lastName + age + email + salary + department + " ";
        webTablesPage.clickAddButton();
        Assert.assertEquals(webTablesPage.returnTextForm(), "Registration Form");
        webTablesPage.register(firstName, lastName, age, email, salary, department);
        webTablesPage.search(firstName);
        Assert.assertTrue(webTablesPage.returnHaveResult());
        String index = webTablesPage.returnResultSearchDelete(resultSearch);
        Assert.assertTrue(!(index.equals("false")));
        webTablesPage.clickEditOrDeleteUserButton(index);
        index = webTablesPage.returnResultSearchDelete(resultSearch);
        Assert.assertTrue((index.equals("false")));
    }
}
