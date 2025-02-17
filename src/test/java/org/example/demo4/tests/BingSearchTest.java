package org.example.demo4.tests;

import org.example.demo4.pages.MainPage;
import org.example.demo4.pages.ResultsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BingSearchTest extends BaseTest {
    private WebDriver driver;
    private MainPage mp;
    private ResultsPage rp;


    @BeforeEach
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");
        mp = new MainPage(driver);
        rp = new ResultsPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchResultsTest() {
        String input = "Selenium";
        mp.sendText(input);
        rp.clickElement(0);
        ArrayList tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) driver.switchTo().window(tabs.get(1).toString());
        assertEquals("https://www.selenium.dev/", getCurrentUrl(), "Открылась неверная ссылка");
    }

    @Test
    public void searchFieldTest() {
        String input = "Selenium";
        mp.sendText(input);
        assertEquals(input, rp.getTextFromSearchField(), "Текст не совпал");
    }
}



