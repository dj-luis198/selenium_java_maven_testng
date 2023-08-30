package com.demoqa.test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.widgets.DatePickerPage;
import com.demoqa.test.base.BaseTest;

public class DatePickerTest extends BaseTest {
    DatePickerPage datePickerPage;

    @BeforeMethod
    public void preconditions() {
        datePickerPage = new DatePickerPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToDatePickerPage();
        adsFooter.deleteAds();
    }

    @Test
    public void validateDatePickerMonthYearInput() {
        datePickerPage.typeDate("05/10/2020");
        Assert.assertEquals(datePickerPage.verifyDate(), "05/10/2020");
    }

    @Test
    public void validateDatePickerMonthYear() {
        datePickerPage.clickDatePicker();
        datePickerPage.selectYear("2018");
        Assert.assertEquals(datePickerPage.verifyYear(), "2018");
        datePickerPage.selectMonth("May");
        Assert.assertEquals(datePickerPage.verifyMonth(), "May");
        datePickerPage.selectDay("5", "May");
        Assert.assertTrue(datePickerPage.verifyDay("5", "May"));
        Assert.assertEquals(datePickerPage.verifyDate(), "05/05/2018");
    }

    @Test
    public void validateDateAndTimePicker() {
        datePickerPage.clickDateAndTimePickerInput();
        datePickerPage.clickYearSelectDateAndTime();
        datePickerPage.clickOptionYear("2023");
        Assert.assertEquals(datePickerPage.verifyYearDateAndTime(), "2023");
        datePickerPage.clickMonth();
        datePickerPage.clickMonthOption("August");
        Assert.assertEquals(datePickerPage.verifyMonthDateAndTime(), "August");
        datePickerPage.selectDay("5", "August");
        Assert.assertTrue(datePickerPage.verifyDayDateAndTime("5", "August"));
        datePickerPage.clickTimeOption("06:45");
        Assert.assertTrue(datePickerPage.verifyTimeDateAndTime("06:45"));
    }

}
