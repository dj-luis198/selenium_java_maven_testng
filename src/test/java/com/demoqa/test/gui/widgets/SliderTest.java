package com.demoqa.test.gui.widgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.util.AnsiColorUtils;
import com.demoqa.until.dataProvider.SliderData;

@Test(groups = "SliderTest", timeOut = 30000)
public class SliderTest extends BaseTest {
    private SliderPage sliderPage;

    private static Logger logger= LogManager.getLogger(SliderTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            sliderPage = new SliderPage();
            sliderPage.goToSlider();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
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
