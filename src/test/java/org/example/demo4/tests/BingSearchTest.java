package org.example.demo4.tests;

import org.example.demo4.pages.MainPage;
import org.example.demo4.pages.ResultsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BingSearchTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchResultsTest() {
        String input = "Selenium";
        MainPage mp = new MainPage(driver);
        mp.sendText(input);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.attributeContains(By.cssSelector("h2 > a[href]"), "href", "selenium"),
                ExpectedConditions.elementToBeClickable(By.cssSelector("h2 > a[href]"))
        ));

        ResultsPage rp = new ResultsPage(driver);
        rp.clickElement(0);

        ArrayList tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) driver.switchTo().window(tabs.get(1).toString());

        assertEquals("https://www.selenium.dev/", driver.getCurrentUrl(), "Открылась не верная ссылка");
    }

    @Test
    public void searchFieldTest() {
        String input = "Selenium";

        MainPage mp = new MainPage(driver);
        mp.sendText(input);

        ResultsPage rp = new ResultsPage(driver);

        assertEquals(input, rp.getTextFromSearchField(), "Текст не совпал");
    }


}



