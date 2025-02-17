package org.example.demo4.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class MyWait {
    private final Logger LOG = LoggerFactory.getLogger(MyWait.class);
    private WebDriverWait wait;
    private int secondsToWait;

    public static MyWait myWait(int seconds) {
        return new MyWait(seconds);
    }

    public MyWait(int seconds) {
        secondsToWait = seconds;
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(seconds));
    }

    public WebElement clickable(WebElement element) {
        LOG.info("Ждем {} секунд, пока элемент не станет кликабельным: {}", secondsToWait, element.toString());
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement visible(WebElement element) {
        LOG.info("Ждем {} секунд, пока элемент не станет видимым: {}", secondsToWait, element.toString());
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean invisible(WebElement element) {
        LOG.info("Ждем {} секунд, пока элемент не станет не видимым: {}", secondsToWait, element.toString());
        return wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }
}
