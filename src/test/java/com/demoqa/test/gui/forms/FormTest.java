package com.demoqa.test.gui.forms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.forms.FormPage;
import com.demoqa.util.AnsiColorUtils;
import com.demoqa.util.dataProvider.FormData;

@Test(groups = "FormTest", timeOut = 30000)
public class FormTest extends BaseTest {
    private FormPage formPage;

    private static Logger logger= LogManager.getLogger(FormTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            formPage = new FormPage();
            formPage.goToForms();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
            Assert.fail();
        }
    }

    @Test(dataProvider = "FormData", dataProviderClass = FormData.class)
    public void validatePacticeForm(String name, String lastName, String email, String gender, String number, String year,String month,String day, String subject, String subject2, String hobby, String state, String city) {
        formPage.typeFirstName(name);
        Assert.assertEquals(formPage.verifyFirstName(), name);
        formPage.typeLastName(lastName);
        Assert.assertEquals(formPage.verifyLastName(), lastName);
        formPage.typeUserEmail(email);
        Assert.assertEquals(formPage.verifyEmail(), email);
        formPage.selectRadioGender(gender);
        Assert.assertTrue(formPage.verifySelectedGender(gender));
        formPage.typeUserNumer(number);
        Assert.assertEquals(formPage.verifyUserNumber(), number);
        formPage.clickDatePicker();
        formPage.selectYear(year);
        formPage.selectMonth(month);
        formPage.selectDay(day, month);
        Assert.assertTrue(formPage.verifyDay(day, month));
        Assert.assertEquals(formPage.verifyMonth(), month);
        Assert.assertEquals(formPage.verifyYear(), year);
        formPage.typeSubjectsMultiple(subject);
        formPage.selectSubjects(subject2);
        Assert.assertEquals(formPage.returnSelectOptions(), subject2);
        formPage.selectHobbie(hobby);
        Assert.assertTrue(formPage.verifySelectedHobbies(hobby));
        //formPage.uploadFile();
        //Assert.assertTrue(formPage.verifyuploadedFilePath());
        formPage.selectState(state);
        Assert.assertTrue(formPage.verifyState(state));
        formPage.selectCity(city);
        Assert.assertTrue(formPage.verifyCity(city));
        formPage.clickSubmit();
    }
}
