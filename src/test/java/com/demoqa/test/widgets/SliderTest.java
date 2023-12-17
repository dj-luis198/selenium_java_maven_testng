package com.demoqa.test.widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.util.dataProvider.SliderData;

@Test(groups = "SliderTest")
public class SliderTest extends BaseTest {
    SliderPage sliderPage;

    @BeforeMethod
    public void preconditions() {
        try {
            sliderPage = new SliderPage();
            sliderPage.goToSlider();
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
            String browser = getBrowser();
            setUp(browser);
            sliderPage = new SliderPage();
            sliderPage.goToSlider();
        }
    }

    @Test(dataProvider = "SliderData", dataProviderClass = SliderData.class)
    public void validateMoveSlider(String x, String res) {
        sliderPage.moveSliderTo(x);
    }

}
