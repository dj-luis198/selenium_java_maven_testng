package com.demoqa.pages.widgets;
import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

public class SliderPage extends BaseClass {
    private final String sliderInput = "//input[@type='range']";

    public void moveSliderTo(String x) {
        dragAndDropBy(sliderInput, (Integer.parseInt(x)), 0);
    }

    public void goToSlider(){
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToSliderPage();
        adsFooter.deleteAds();
    }
}
