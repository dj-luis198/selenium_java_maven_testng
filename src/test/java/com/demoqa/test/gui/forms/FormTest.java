package com.demoqa.test.gui.forms;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.forms.FormPage;

@Test(groups = "FormTest")
public class FormTest extends BaseTest {
    FormPage formPage;

    @BeforeMethod
    public void preconditions() {
        try {
            formPage = new FormPage();
            formPage.goToForms();
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
            String browser = getBrowser();
            setUp(browser);
            formPage = new FormPage();
            formPage.goToForms();
        }
    }

    @Test
    public void validatePacticeForm() {
        formPage.typeFirstName("Daniel");
        Assert.assertEquals(formPage.verifyFirstName(), "Daniel");
        formPage.typeLastName("Farias");
        Assert.assertEquals(formPage.verifyLastName(), "Farias");
        formPage.typeUserEmail("dj.luis198@gmail.com");
        Assert.assertEquals(formPage.verifyEmail(), "dj.luis198@gmail.com");
        formPage.selectRadioGender("Female");
        Assert.assertTrue(formPage.verifySelectedGender("Female"));
        formPage.typeUserNumer("1234567891");
        Assert.assertEquals(formPage.verifyUserNumber(), "1234567891");
        formPage.clickDatePicker();
        formPage.selectYear("1984");
        formPage.selectMonth("May");
        formPage.selectDay("21", "May");
        Assert.assertTrue(formPage.verifyDay("21", "May"));
        Assert.assertEquals(formPage.verifyMonth(), "May");
        Assert.assertEquals(formPage.verifyYear(), "1984");
        formPage.typeSubjectsMultiple("s");
        formPage.selectSubjects("Arts");
        Assert.assertEquals(formPage.returnSelectOptions(), "Arts");
        formPage.selectHobbie("Music");
        Assert.assertTrue(formPage.verifySelectedHobbies("Music"));
        formPage.uploadFile();
        Assert.assertTrue(formPage.verifyuploadedFilePath());
        formPage.selectState("NCR");
        Assert.assertTrue(formPage.verifyState("NCR"));
        formPage.selectCity("Delhi");
        Assert.assertTrue(formPage.verifyCity("Delhi"));
        formPage.clickSubmit();
    }
}
