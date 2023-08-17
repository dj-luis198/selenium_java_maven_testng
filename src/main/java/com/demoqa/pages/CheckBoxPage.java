package com.demoqa.pages;

import com.demoqa.base.BaseClass;

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
}
