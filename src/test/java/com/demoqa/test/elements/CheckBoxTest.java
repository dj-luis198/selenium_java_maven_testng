package com.demoqa.test.elements;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.pages.CheckBoxPage;
import com.demoqa.pages.HomePage;
import com.demoqa.test.BaseTest;
import com.demoqa.util.JsonSimple;

public class CheckBoxTest extends BaseTest {
    int i = -1;
    HomePage homePage;
    CheckBoxPage checkBoxPage;
    JsonSimple json;

    @BeforeMethod
    public void initPage() {
        i++;
        json = new JsonSimple();
        homePage = new HomePage();
        checkBoxPage = new CheckBoxPage();
        homePage.goToCheckBoxPage();
    }

    @Test(description = "Validate button expand All")
    public void expandAllButtonTest() {
        checkBoxPage.expandAll();
        Assert.assertTrue(checkBoxPage.allTogle());
    }

    @Test(description = "Validate button collapse All")
    public void collapseAllButtonTest() {
        checkBoxPage.collapseAll();
        Assert.assertTrue(checkBoxPage.allTogleCollapse());
    }

    @Test(description = "Validate check option", invocationCount = 6)
    public void checkTest() throws IOException, ParseException {
        String file = "CheckBox";
        String array[] = json.GetJsonSimple(i, file,"check");
        checkBoxPage.expandAll();
        checkBoxPage.checkOption(array);
        String resp = json.GetJsonSimpleString(i, file,"resp");
        Assert.assertEquals(checkBoxPage.returnResp(), "you have selected :" + resp.replace(" ", ""));
    }

    /*
     @Test(description="Validate check option Documents")
     public void checkDocumentsTest() throws IOException, ParseException{
    String array[]=new String[1];
     array=json.GetJsonSimple(4,"CheckBox");
     checkBoxPage.expandAll();
     checkBoxPage.checkOption(array);
     String resp= json.GetJsonSimpleString(4,"CheckBox" );
     Assert.assertEquals(checkBoxPage.returnResp(),
     "you have selected :"+resp.replace(" ",""));
     } 
     
     @Test(description="Validate check option Downloads")
     public void checkDownloadsTest() throws IOException, ParseException{
     String array[]=json.GetJsonSimple(3,"CheckBox");
     checkBoxPage.expandAll();
     checkBoxPage.checkOption(array);
     String resp= json.GetJsonSimpleString(3,"CheckBox" );
     Assert.assertEquals(checkBoxPage.returnResp(),
     "you have selected :"+resp.replace(" ",""));
     }
     
     @Test(description="Validate check option Private")
     public void checkPrivateTest() throws IOException, ParseException{
     String array[]=json.GetJsonSimple(2,"CheckBox");
     checkBoxPage.expandAll();
     checkBoxPage.checkOption(array);
     String resp= json.GetJsonSimpleString(2,"CheckBox" );
     Assert.assertEquals(checkBoxPage.returnResp(),
     "you have selected :"+resp.replace(" ",""));
     }
     
     @Test(description="Validate check option private,angular,commands")
     public void checkPrivateAngularCommandsTest() throws IOException,
     ParseException{
     String array[]=json.GetJsonSimple(1,"CheckBox");
     checkBoxPage.expandAll();
     checkBoxPage.checkOption(array);
     String resp= json.GetJsonSimpleString(1,"CheckBox" );
     Assert.assertEquals(checkBoxPage.returnResp(),
     "you have selected :"+resp.replace(" ",""));
     }
     
     @Test(description="Validate check option home")
     public void checkHomeTest() throws IOException, ParseException{
     String array[]=json.GetJsonSimple(0,"CheckBox");
     checkBoxPage.expandAll();
     checkBoxPage.checkOption(array);
     String resp= json.GetJsonSimpleString(0,"CheckBox" );
     Assert.assertEquals(checkBoxPage.returnResp(),
     "you have selected :"+resp.replace(" ",""));
     }*/
     
}
