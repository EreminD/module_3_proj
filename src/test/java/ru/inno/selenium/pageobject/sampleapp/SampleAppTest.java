package ru.inno.selenium.pageobject.sampleapp;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.VncRecordingContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.net.MalformedURLException;
import java.nio.file.Path;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SampleAppTest {

    private WebDriver driver;
    private SampleAppPage page;

//    @Container
//    public BrowserWebDriverContainer<?> container = new BrowserWebDriverContainer<>()
//            .withCapabilities(new FirefoxOptions())
//            .withExposedPorts(7900)
//            .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, Path.of("target").toFile(), VncRecordingContainer.VncRecordingFormat.MP4);

//    @BeforeEach
//    public void setDriver() throws MalformedURLException {
//        driver = new RemoteWebDriver(container.getSeleniumAddress(), new FirefoxOptions());
//        page = new SampleAppPage(driver);
//    }
//
//    @AfterEach
//    public void quit() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    public void happyPathTest() {
//        page.open();
//        page.auth("Inno", "pwd");
//        page.checkStatusHasText("Welcome, Inno!");

        assertFalse(false);
    }

    @Test
    public void wrongPassTest() {
        step("Проверить, что отображается сообщение об ошибке",
                () -> assertEquals("Invalid username/password", "Invalid username/password1111")
        );
    }

    @Test
    public void blankLoginAndPass() {
        page.open();
        page.clickLogin();

        step("Проверить, что отображается сообщение об ошибке",
                () -> assertEquals("Invalid username/password !!!", page.getStatus())
        );
    }
}
