package com.demoqa.test.elements;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.AdsFooter;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.CheckBoxPage;
import com.demoqa.test.BaseTest;
import com.demoqa.util.JsonSimple;

public class CheckBoxTest extends BaseTest {
    HomePage homePage;
    CheckBoxPage checkBoxPage;
    JsonSimple json;

    @BeforeMethod
    public void initPage() {
        json = new JsonSimple();
        homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        checkBoxPage = new CheckBoxPage();
        homePage.goToCheckBoxPage();
        adsFooter.deleteAds();
    }

    @Test(description = "Validate button expand All")
    public void expandAllButtonTest() {
        checkBoxPage.expandAll();
        Assert.assertTrue(checkBoxPage.allTogle());
    }

    @Test(description = "Validate button collapse All")
    public void collapseAllButtonTest() {
        checkBoxPage.collapseAll();
        Assert.assertTrue(checkBoxPage.allTogleCollapse());
    }

    @Test(description = "Validate check option")
    public void checkTest() throws IOException, ParseException {
        String array[] = new String[1];
        array = json.GetJsonSimple(5, "CheckBox", "check");
        checkBoxPage.expandAll();
        checkBoxPage.checkOption(array);
        String resp = json.GetJsonSimpleString(5, "CheckBox", "resp");
        Assert.assertEquals(checkBoxPage.returnResp(),
                "you have selected :" + resp.replace(" ", ""));
    }

    @Test(description = "Validate check option Documents")
    public void checkDocumentsTest() throws IOException, ParseException {
        String array[] = new String[1];
        array = json.GetJsonSimple(4, "CheckBox", "check");
        checkBoxPage.expandAll();
        checkBoxPage.checkOption(array);
        String resp = json.GetJsonSimpleString(4, "CheckBox", "resp");
        Assert.assertEquals(checkBoxPage.returnResp(),
                "you have selected :" + resp.replace(" ", ""));
    }

    @Test(description = "Validate check option Downloads")
    public void checkDownloadsTest() throws IOException, ParseException {
        String array[] = json.GetJsonSimple(3, "CheckBox", "check");
        checkBoxPage.expandAll();
        checkBoxPage.checkOption(array);
        String resp = json.GetJsonSimpleString(3, "CheckBox", "resp");
        Assert.assertEquals(checkBoxPage.returnResp(),
                "you have selected :" + resp.replace(" ", ""));
    }

    @Test(description = "Validate check option Private")
    public void checkPrivateTest() throws IOException, ParseException {
        String array[] = json.GetJsonSimple(2, "CheckBox", "check");
        checkBoxPage.expandAll();
        checkBoxPage.checkOption(array);
        String resp = json.GetJsonSimpleString(2, "CheckBox", "resp");
        Assert.assertEquals(checkBoxPage.returnResp(),
                "you have selected :" + resp.replace(" ", ""));
    }

    @Test(description = "Validate check option private,angular,commands")
    public void checkPrivateAngularCommandsTest() throws IOException,
            ParseException {
        String array[] = json.GetJsonSimple(1, "CheckBox", "check");
        checkBoxPage.expandAll();
        checkBoxPage.checkOption(array);
        String resp = json.GetJsonSimpleString(1, "CheckBox", "resp");
        Assert.assertEquals(checkBoxPage.returnResp(),
                "you have selected :" + resp.replace(" ", ""));
    }

    @Test(description = "Validate check option home")
    public void checkHomeTest() throws IOException, ParseException {
        String array[] = json.GetJsonSimple(0, "CheckBox", "check");
        checkBoxPage.expandAll();
        checkBoxPage.checkOption(array);
        String resp = json.GetJsonSimpleString(0, "CheckBox", "resp");
        Assert.assertEquals(checkBoxPage.returnResp(),
                "you have selected :" + resp.replace(" ", ""));
    }

}
