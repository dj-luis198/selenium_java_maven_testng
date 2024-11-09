package com.demoqa.test.gui.widgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.AutoCompletePage;
import com.demoqa.util.AnsiColorUtils;
import com.demoqa.until.dataProvider.AutoCompleteData;

@Test(groups = "AutoCompleteTest", timeOut = 30000)
public class AutoCompleteTest extends BaseTest {
    private AutoCompletePage autoCompletePage;
    private static Logger logger= LogManager.getLogger(AutoCompleteTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            autoCompletePage = new AutoCompletePage();
            autoCompletePage.goToAutoComplete();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
            String browser = getBrowser();
            setUp(browser);
            autoCompletePage = new AutoCompletePage();
            autoCompletePage.goToAutoComplete();
        }
    }

    @Test(dataProvider = "MultipleSelecColorData", dataProviderClass = AutoCompleteData.class)
    public void validateTypeMultipleColorNames(String partialText1, String text1, String partialText2, String text2) {
        autoCompletePage.typeColorMultiple(partialText1);
        autoCompletePage.selectColor(text1);
        autoCompletePage.typeColorMultiple(partialText2);
        autoCompletePage.selectColor(text2);
        Assert.assertEquals(autoCompletePage.returnSelectOptions(), text1 + text2);
    }

    @Test(dataProvider = "MultipleSelecColorData", dataProviderClass = AutoCompleteData.class)
    public void validateDeleteColorName(String partialText1, String text1, String partialText2, String text2) {
        autoCompletePage.typeColorMultiple(partialText1);
        autoCompletePage.selectColor(text1);
        autoCompletePage.typeColorMultiple(partialText2);
        autoCompletePage.selectColor(text2);
        Assert.assertEquals(autoCompletePage.returnSelectOptions(), text1 + text2);
        autoCompletePage.deleteColor(text1);
        Assert.assertEquals(autoCompletePage.returnSelectOptions(), text2);
    }

    @Test(dataProvider = "MultipleSelecColorData", dataProviderClass = AutoCompleteData.class)
    public void validateDeleteAllColorNames(String partialText1, String text1, String partialText2, String text2) {
        autoCompletePage.typeColorMultiple(partialText1);
        autoCompletePage.selectColor(text1);
        autoCompletePage.typeColorMultiple(partialText2);
        autoCompletePage.selectColor(text2);
        Assert.assertEquals(autoCompletePage.returnSelectOptions(), text1 + text2);
        autoCompletePage.deleteAllColors();
        Assert.assertEquals(autoCompletePage.returnSelectOptions(), "");
    }

    @Test(dataProvider = "MultipleSelecColorData", dataProviderClass = AutoCompleteData.class)
    public void validateTypeSingleColorName(String partialText1, String text1, String partialText2, String text2) {
        autoCompletePage.typeColorSingle(partialText1);
        autoCompletePage.selectSingleColor(text1);
        Assert.assertEquals(autoCompletePage.returnSelectOption(), text1);
    }

    @Test(dataProvider = "MultipleSelecColorData", dataProviderClass = AutoCompleteData.class)
    public void validateChangeTypeSingleColorName(String partialText1, String text1, String partialText2,
            String text2) {
        autoCompletePage.typeColorSingle(partialText2);
        autoCompletePage.selectSingleColor(text2);
        Assert.assertEquals(autoCompletePage.returnSelectOption(), text2);
        autoCompletePage.typeColorSingle(partialText1);
        autoCompletePage.selectSingleColor(text1);
        Assert.assertEquals(autoCompletePage.returnSelectOption(), text1);
    }

}
