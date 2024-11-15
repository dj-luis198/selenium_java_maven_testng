package com.demoqa.test.gui.elements;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.CheckBoxPage;
import com.demoqa.util.AnsiColorUtils;
import com.demoqa.util.JsonSimple;

@Test(groups = "CheckBoxTest",timeOut = 30000)
public class CheckBoxTest extends BaseTest {
    private HomePage homePage;
    private CheckBoxPage checkBoxPage;
    JsonSimple json;

    private static Logger logger= LogManager.getLogger(CheckBoxTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            json = new JsonSimple();
            checkBoxPage = new CheckBoxPage();
            checkBoxPage.goToCheckBox(homePage);
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
            Assert.fail();
        }
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
