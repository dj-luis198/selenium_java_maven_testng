package com.demoqa.test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.widgets.DatePickerPage;
import com.demoqa.util.dataProvider.DatePicker.DatePickerData;
import com.demoqa.util.dataProvider.DatePicker.DatePickerDataTime;
import com.demoqa.util.dataProvider.DatePicker.DatePickerInputData;

@Test(groups = "DatePickerTest")
public class DatePickerTest extends BaseTest {
    DatePickerPage datePickerPage;
    HomePage homePage;

    @BeforeMethod
    public void preconditions() {
        datePickerPage = new DatePickerPage();
        homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToDatePickerPage();
        adsFooter.deleteAds();
    }

    @Test(dataProvider="DatePickerInputData",dataProviderClass = DatePickerInputData.class)
    public void validateDatePickerMonthYearInput(String date) {
        datePickerPage.typeDate(date);
        Assert.assertEquals(datePickerPage.verifyDate(), date);
    }

    @Test(dataProvider="DatePickerData",dataProviderClass = DatePickerData.class)
    public void validateDatePickerMonthYear(String year, String month, String day, String date) {
        datePickerPage.clickDatePicker();
        datePickerPage.selectYear(year);
        Assert.assertEquals(datePickerPage.verifyYear(), year);
        datePickerPage.selectMonth(month);
        Assert.assertEquals(datePickerPage.verifyMonth(), month);
        datePickerPage.selectDay(day, month);
        Assert.assertTrue(datePickerPage.verifyDay(day, month));
        Assert.assertEquals(datePickerPage.verifyDate(), date);
    }

    @Test(dataProvider="DatePickerDataTime",dataProviderClass = DatePickerDataTime.class)
    public void validateDateAndTimePicker(String year, String month, String day, String date,String time) {
        datePickerPage.clickDateAndTimePickerInput();
        datePickerPage.clickYearSelectDateAndTime();
        datePickerPage.clickOptionYear(year);
        Assert.assertEquals(datePickerPage.verifyYearDateAndTime(), year);
        datePickerPage.clickMonth();
        datePickerPage.clickMonthOption(month);
        Assert.assertEquals(datePickerPage.verifyMonthDateAndTime(), month);
        datePickerPage.selectDay(day, month);
        Assert.assertTrue(datePickerPage.verifyDayDateAndTime(day, month));
        datePickerPage.clickTimeOption(time);
        Assert.assertTrue(datePickerPage.verifyTimeDateAndTime(time));
    }

}
