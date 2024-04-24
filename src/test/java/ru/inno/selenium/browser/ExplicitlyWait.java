package ru.inno.selenium.browser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// ЯВНЫЕ ОЖИДАНИЯ
public class ExplicitlyWait {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, ofSeconds(40), ZERO);
        driver.get("http://uitestingplayground.com/progressbar");
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void progressTest() {
        WebElement progressBar = driver.findElement(By.cssSelector("#progressBar"));

        driver.findElement(By.cssSelector("#startButton")).click();

        wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "75"));

        driver.findElement(By.cssSelector("#stopButton")).click();

        assertTrue(driver.findElement(By.cssSelector("#result")).getText().startsWith("Result: 0"));
        assertEquals("75", driver.findElement(By.cssSelector("#progressBar")).getAttribute("aria-valuenow"));
    }
}

// проблема с перелетом

//
//long interval = 200L;
//    long timeout = 20*1000;
//
//    long timeToStop = System.currentTimeMillis() + timeout;
//        while (!progressBar.getAttribute("aria-valuenow").equals("75")) {
//                System.out.println("Ждем");
//                Thread.sleep(interval);
//
//                if (System.currentTimeMillis() > timeToStop){
//                break;
//                }
//                }
