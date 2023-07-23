package com.demoqa.pages;

import org.openqa.selenium.WebDriver;

import com.demoqa.base.BaseClass;

public class CheckBoxPage extends BaseClass{
    private static String expandButton="//button[@title=\"Expand all\"]";
    private static String allToggleColapse="rct-collapse";
    private static String collapseButton="//button[@title=\"Collapse all\"]";


    public CheckBoxPage(WebDriver driver){
        BaseClass.driver=driver;
    }
public void expandAll(){
click(expandButton);
}

public Boolean allTogle(){
    System.out.println(returnLength(allToggleColapse));
    return returnLength(allToggleColapse)==17;
}

public void collapseAll(){
click(collapseButton);
}

public Boolean allTogleCollapse(){
    System.out.println(returnLength(allToggleColapse));
    return returnLength(allToggleColapse)==1;
}
    
}
