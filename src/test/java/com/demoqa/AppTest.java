package com.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest 
{
    WebDriver driver;

    @Test
    public void shouldAnswerWithTrue()
    {
        driver= new ChromeDriver();
    

    };
}
