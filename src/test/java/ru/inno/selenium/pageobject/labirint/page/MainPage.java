package ru.inno.selenium.pageobject.labirint.page;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.labirint.ru/"); // config
        driver.manage().addCookie(new Cookie("cookie_policy", "1"));
        driver.navigate().refresh();
    }
}

