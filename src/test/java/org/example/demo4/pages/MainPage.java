package org.example.demo4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.demo4.tests.MyWait.myWait;

//https://www.bing.com/
public class MainPage {
    @FindBy(css = "#sb_form_q")
    private WebElement searchField;

    public void sendText(String text) {
        searchField.sendKeys(text);
        searchField.submit();
        myWait(6).clickable(searchField);
        System.out.println("Введен текст: " + text);
    }

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
