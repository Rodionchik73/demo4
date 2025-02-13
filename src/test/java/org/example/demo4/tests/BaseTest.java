package org.example.demo4.tests;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private static WebDriver driver;

    @BeforeEach
    public void commonSetUp(){
        driver = new ChromeDriver();
    }
    public static WebDriver getDriver(){
        return driver;
    }

}
