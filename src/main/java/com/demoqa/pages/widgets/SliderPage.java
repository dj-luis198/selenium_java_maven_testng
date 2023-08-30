package com.demoqa.pages.widgets;
import com.demoqa.base.BaseClass;

public class SliderPage extends BaseClass {
    private final String sliderInput = "//input[@type='range']";
    private final String sliderInputRes = "//input[@id='sliderValue']";

    public String verifySliderValue() {
        return getAttributeDefaultValue(sliderInputRes);
    }

    public void moveSliderTo(String x) {
        int init = Integer.parseInt(getAttributeDefaultValue(sliderInput));
        System.out.println(init);
        System.out.println((Integer.parseInt(x)) - init);
        dragAndDropBy(sliderInput, (Integer.parseInt(x)), 0);
    }
}
