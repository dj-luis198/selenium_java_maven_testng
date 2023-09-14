package com.demoqa.pages.widgets;
import com.demoqa.base.BaseClass;

public class SliderPage extends BaseClass {
    private final String sliderInput = "//input[@type='range']";

    public void moveSliderTo(String x) {
        dragAndDropBy(sliderInput, (Integer.parseInt(x)), 0);
    }
}
