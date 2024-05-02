package ru.inno.selenium.pageobject.sampleapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleAppTest {

    private WebDriver driver;
    private SampleAppPage page;

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
        page = new SampleAppPage(driver);
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void happyPathTest(SampleAppPage page, String pass) {
        page.open();
        page.auth("Inno", "pwd");
        page.checkStatusHasText("Welcome, Inno!");
    }

    @Test
    public void wrongPassTest() {
        String login = "Inno";
        String pass = "qwerty";

        page.open();
        page.auth(login, pass);
        assertEquals("Invalid username/password", page.getStatus());
    }

    @Test
    public void blankLoginAndPass() {
        page.open();
        page.clickLogin();

        assertEquals("Invalid username/password", page.getStatus());
    }
}
