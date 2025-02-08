package org.example.demo4.tests;

import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class MyWait {
    private final Logger LOG = (Logger) LoggerFactory.getLogger(MyWait.class);
    private WebDriverWait wait;
    private int secondsToWait;

    public static MyWait myWait(int seconds) {
        return new MyWait(seconds);
    }

    public MyWait(int seconds) {
        secondsToWait = seconds;
        wait = new WebDriverWait(BingSearchTest.getDriver(), Duration.ofSeconds(seconds));
    }

    public WebElement clickable(WebElement element) {
        LOG.info("Ждем " + secondsToWait + "секунд, пока элемент не станет кликабельным: " + element.toString());
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement visible(WebElement element) {
        LOG.info("Ждем " + secondsToWait + "секунд, пока элемент не станет видимым: " + element.toString());
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean invisible(WebElement element) {
        LOG.info("Ждем " + secondsToWait + "секунд, пока элемент не станет видимым: " + element.toString());
        return wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }


}
