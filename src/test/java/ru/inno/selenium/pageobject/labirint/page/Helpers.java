package ru.inno.selenium.pageobject.labirint.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helpers {
    private final WebDriver driver;

    public Helpers(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

}
