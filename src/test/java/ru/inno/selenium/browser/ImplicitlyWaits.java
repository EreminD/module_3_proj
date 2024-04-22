package ru.inno.selenium.browser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

// НЕЯВНЫЕ ожидания
public class ImplicitlyWaits {

    private WebDriver driver;

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void getText() {
        driver.get("http://uitestingplayground.com/ajax");

        driver.findElement(By.cssSelector("#ajaxButton")).click(); // NoSuchElementException

        String text = driver.findElement(By.cssSelector("#content p")).getText();

        assertEquals("Data loaded with AJAX get request.", text);
    }
}
