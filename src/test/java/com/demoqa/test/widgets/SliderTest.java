package com.demoqa.test.widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.util.dataProvider.SliderData;

public class SliderTest extends BaseTest {
    SliderPage sliderPage;

    @BeforeMethod
    public void preconditions() {
        sliderPage = new SliderPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToSliderPage();
        adsFooter.deleteAds();
    }

    @Test(dataProvider = "SliderData", dataProviderClass = SliderData.class)
    public void validateMoveSlider(String x, String res) {
        sliderPage.moveSliderTo(x);
    }

}
