package ru.inno.selenide.page;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class MainPage {
    public void openPage(){
        open("https://www.labirint.ru/"); // config
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("cookie_policy", "1"));
        refresh();
    }
}
