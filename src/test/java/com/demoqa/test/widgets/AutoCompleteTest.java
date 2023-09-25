package com.demoqa.test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.widgets.AutoCompletePage;
import com.demoqa.util.dataProvider.AutoCompleteData;

@Test(groups = "AutoCompleteTest")
public class AutoCompleteTest extends BaseTest {
    AutoCompletePage autoCompletePage;

    @BeforeMethod
    public void preconditions() {
        autoCompletePage = new AutoCompletePage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToAutoCompletePage();
        adsFooter.deleteAds();
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
