package ru.inno.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverService {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void quitDriver(){
        if (driver != null){
            driver.quit();
        }
    }
}
