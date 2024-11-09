package com.demoqa.pages.widgets;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class DatePickerPage extends BaseClass {

    private final String datePickerMonthYearInput = "//input[@id='datePickerMonthYearInput']";
    private final String yearSelect = "//select[@class='react-datepicker__year-select']";
    private final String monthSelect = "//select[@class='react-datepicker__month-select']";
    private final String dateAndTimePickerInput = "//input[@id='dateAndTimePickerInput']";
    private final String yearSelectDateAndTime = "//div[@class='react-datepicker__year-read-view']";
    private final String yearOption = "//div[contains(@class,'react-datepicker__year-option')]";
    private final String monthOption = "//div[@class='react-datepicker__month-read-view']";
    private final String selectYear = "//span[@class='react-datepicker__year-read-view--selected-year']";
    private final String selectMonth = "//span[@class='react-datepicker__month-read-view--selected-month']";

    public Boolean verifyDayDateAndTime(String day, String month) {
        if (day.equals(BaseClass.getTextContent("//div[contains(@class,'react-datepicker__day--selected')]"))) {
            return true;
        }
        return false;
    }

    public Boolean verifyTimeDateAndTime(String time) {
        clickDateAndTimePickerInput();
        if (time.equals(BaseClass.getTextContent("//li[contains(@class,'react-datepicker__time-list-item--selected')]"))) {
            return true;
        }
        return false;
    }

    public void clickTimeOption(String time) {
        BaseClass.clickJS("//li[contains(@class,'react-datepicker__time-list-item')][text()='" + time + "']");
    }

    public String verifyMonthDateAndTime() {
        return BaseClass.getTextContent(selectMonth);
    }

    public String verifyYearDateAndTime() {
        return BaseClass.getTextContent(selectYear);
    }

    public void clickMonth() {
        BaseClass.clickJS(monthOption);
    }

    public void clickMonthOption(String month) {
        BaseClass.clickJS("//div[@class='react-datepicker__month-dropdown']//div[text()='" + month + "']");
    }

    public String removeSymbol(String text) {
        return text.replaceAll("\\u2713", "");
    }

    public void clickOptionYear(String year) {
        Boolean flag = false;
        int yearInt = Integer.parseInt(year);
        int sizeYearOptions = BaseClass.returnLengthXpath(yearOption);

        while (flag != true) {
            List<WebElement> yearOptions = BaseClass.returnElements(yearOption);
            int firstYearOption = Integer.parseInt(removeSymbol(BaseClass.getAttributeElementContent(yearOptions.get(1))));
            int lastYearOption = Integer
                    .parseInt(removeSymbol(BaseClass.getAttributeElementContent(yearOptions.get(sizeYearOptions - 2))));
            if ((yearInt >= lastYearOption) && ((Integer.parseInt(year)) <= firstYearOption)) {
                for (int i = 1; i < sizeYearOptions - 1; i++) {
                    if ((year).equals(removeSymbol(BaseClass.getAttributeElementContent(yearOptions.get(i))))) {
                        BaseClass.clickElementJS(yearOptions.get(i));
                        flag = true;
                        break;
                    }
                }
            } else {
                if (yearInt < lastYearOption) {
                    BaseClass.clickElementJS(yearOptions.get(sizeYearOptions - 1));
                } else {
                    if (yearInt > firstYearOption) {
                        BaseClass.clickElementJS(yearOptions.get(0));
                    }
                }
            }
        }
    }

    public void clickYearSelectDateAndTime() {
        BaseClass.clickJS(yearSelectDateAndTime);
    }

    public void clickDateAndTimePickerInput() {
        BaseClass.clickJS(dateAndTimePickerInput);
    }

    public void selectDay(String day, String month) {
        List<WebElement> listDays = BaseClass.returnElements(
                "//div[@class='react-datepicker__week']//child::div[contains(@aria-label,'" + month + "')]");
        int sizeList = BaseClass.returnLengthXpath(
                "//div[@class='react-datepicker__week']//child::div[contains(@aria-label,'" + month + "')]");
        int lastDay = Integer.parseInt(BaseClass.getAttributeElementContent(listDays.get(sizeList - 1)));
        if (Integer.parseInt(day) <= lastDay) {
            for (WebElement elementDay : listDays) {
                if (day.equals(BaseClass.getAttributeElementContent(elementDay))) {
                    BaseClass.clickElementJS(elementDay);
                    break;
                }
            }
        }
    }

    public Boolean verifyDay(String day, String month) {
        BaseClass.clickJS(datePickerMonthYearInput);
        if (day.equals(BaseClass.getTextContent("//div[contains(@class,'react-datepicker__day--selected')]"))) {
            return true;
        }
        return false;
    }

    public void selectMonth(String month) {
        BaseClass.selectPerText(monthSelect, month);
    }

    public String verifyMonth() {
        return BaseClass.isSelectInnerText(monthSelect);
    }

    public void selectYear(String year) {
        BaseClass.selectPerText(yearSelect, year);
    }

    public String verifyYear() {
        return BaseClass.isSelectValue(yearSelect);
    }

    public void clickDatePicker() {
        BaseClass.clickJS(datePickerMonthYearInput);
    }

    public void typeDate(String date) {
        BaseClass.typeDatePicker(datePickerMonthYearInput, date);
    }

    public String verifyDate() {
        return BaseClass.getAttributeDefaultValue(datePickerMonthYearInput);
    }

    public void goToDatePicker(){
        HomePage homePage = new HomePage();
        homePage.goToHome();
        homePage.goToDatePickerPage();
    }
}
