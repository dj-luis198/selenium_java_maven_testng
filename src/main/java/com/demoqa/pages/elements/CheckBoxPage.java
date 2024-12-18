package com.demoqa.pages.elements;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

import net.datafaker.internal.helper.WordUtils;

public class CheckBoxPage extends BaseClass {
    private final String expandButton = "//button[@title=\"Expand all\"]";
    private final String allToggleColapse = "rct-collapse";
    private final String collapseButton = "//button[@title=\"Collapse all\"]";
    private final String resultText = "//*[@id=\"result\"]";

    public void expandAll() {
        BaseClass.click(expandButton);
    }

    public Boolean allTogle() {
        return BaseClass.returnLength(allToggleColapse) == 17;
    }

    public void collapseAll() {
        BaseClass.click(collapseButton);
    }

    public Boolean allTogleCollapse() {
        return BaseClass.returnLength(allToggleColapse) == 1;
    }

    public void checkOption(String array[]) {
        String options;
        for (int i = 0; i < array.length; i++) {
            options = "//span[@class=\"rct-title\"][text()=\"" + WordUtils.capitalize(array[i]) + "\"]";
            BaseClass.click(options);
        }
    }

    public String returnResp() {
        String resp = BaseClass.getTextContent(resultText);
        return resp.toLowerCase();
    }

    public void goToCheckBox(HomePage homePage) {
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToCheckBoxPage();
    }
}
