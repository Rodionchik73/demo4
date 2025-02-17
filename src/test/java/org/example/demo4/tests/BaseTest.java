package org.example.demo4.tests;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    private static WebDriver driver;

    @BeforeEach
    public void commonSetUp() {
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public String getCurrentUrl() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return driver.getCurrentUrl();
    }

}