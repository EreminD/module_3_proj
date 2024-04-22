package ru.inno.selenium.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

    public static void main(String[] args) {

        // WebDriver
        WebDriver browser = new ChromeDriver();
        browser.get("https://habr.ru");
        // WebElement
        browser.quit();

    }
}
