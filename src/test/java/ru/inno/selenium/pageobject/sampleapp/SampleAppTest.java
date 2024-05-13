package ru.inno.selenium.pageobject.sampleapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleAppTest {

    private WebDriver driver;
    private SampleAppPage page;

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
        driver.get("http://uitestingplayground.com/sampleapp");
        page = PageFactory.initElements(driver, SampleAppPage.class);
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void happyPathTest() {
        page.auth("Inno", "pwd");
        page.checkStatusHasText("Welcome, Inno!");
    }

    @Test
    public void wrongPassTest() {
        String login = "Inno";
        String pass = "qwerty";

        page.auth(login, pass);
        step("Проверить, что отображается сообщение об ошибке",
                () -> assertEquals("Invalid username/password", page.getStatus())
        );
    }

    @Test
    public void blankLoginAndPass() {
        page.clickLogin();

        step("Проверить, что отображается сообщение об ошибке",
                () -> assertEquals("Invalid username/password", page.getStatus())
        );
    }
}


//6.683