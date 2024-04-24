package ru.inno.selenium.browser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertPrompts {
    private WebDriver driver;

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void alertTest() {
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

        driver.switchTo().alert().accept();

        String text = driver.findElement(By.cssSelector("#result")).getText();
        assertEquals("You successfully clicked an alert", text);
    }

    @Test
    public void confirmTest() {
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        driver.switchTo().alert().dismiss();

        String text = driver.findElement(By.cssSelector("#result")).getText();
        assertEquals("You clicked: Cancel", text);
    }

    @Test
    public void promptTest() {
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        driver.switchTo().alert().sendKeys("TEST");
        driver.switchTo().alert().accept();

        String text = driver.findElement(By.cssSelector("#result")).getText();
        assertEquals("You entered: TEST", text);
    }
}
