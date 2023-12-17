package com.demoqa.pages.elements;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

import net.datafaker.internal.helper.WordUtils;

public class CheckBoxPage extends BaseClass {
    private final String expandButton = "//button[@title=\"Expand all\"]";
    private final String allToggleColapse = "rct-collapse";
    private final String collapseButton = "//button[@title=\"Collapse all\"]";
    private final String resultText = "//*[@id=\"result\"]";

    public void expandAll() {
        click(expandButton);
    }

    public Boolean allTogle() {
        return returnLength(allToggleColapse) == 17;
    }

    public void collapseAll() {
        click(collapseButton);
    }

    public Boolean allTogleCollapse() {
        return returnLength(allToggleColapse) == 1;
    }

    public void checkOption(String array[]) {
        String options;
        for (int i = 0; i < array.length; i++) {
            options = "//span[@class=\"rct-title\"][text()=\"" + WordUtils.capitalize(array[i]) + "\"]";
            click(options);
        }
    }

    public String returnResp() {
        String resp = getTextContent(resultText);
        return resp.toLowerCase();
    }

    public void goToCheckBox(HomePage homePage) {
        homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToCheckBoxPage();
        adsFooter.deleteAds();
    }
}
