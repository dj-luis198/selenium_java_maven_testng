package com.demoqa.test.gui.widgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.DatePickerPage;
import com.demoqa.util.AnsiColorUtils;
import com.demoqa.util.dataProvider.DatePicker.DatePickerData;
import com.demoqa.util.dataProvider.DatePicker.DatePickerDataTime;
import com.demoqa.util.dataProvider.DatePicker.DatePickerInputData;

@Test(groups = "DatePickerTest", timeOut = 40000)
public class DatePickerTest extends BaseTest {
    private DatePickerPage datePickerPage;

    private static Logger logger= LogManager.getLogger(DatePickerTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            datePickerPage = new DatePickerPage();
            datePickerPage.goToDatePicker();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
            Assert.fail();
        }
    }

    @Test(dataProvider = "DatePickerInputData", dataProviderClass = DatePickerInputData.class)
    public void validateDatePickerMonthYearInput(String date) {
        datePickerPage.typeDate(date);
        Assert.assertEquals(datePickerPage.verifyDate(), date);
    }

    @Test(dataProvider = "DatePickerData", dataProviderClass = DatePickerData.class)
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

    @Test(dataProvider = "DatePickerDataTime", dataProviderClass = DatePickerDataTime.class)
    public void validateDateAndTimePicker(String year, String month, String day, String date, String time) {
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
