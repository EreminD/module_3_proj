package ru.inno.selenium.pageobject.labirint.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderElement {
    private final WebElement header;

    public HeaderElement(WebDriver driver) {
        this.header = driver.findElement(By.cssSelector(".top-header"));
    }

    public void search(String term) {
        header.findElement(By.cssSelector("#search-field")).clear();
        header.findElement(By.cssSelector("#search-field")).sendKeys(term);
        header.findElement(By.cssSelector("#searchform")).submit();
    }
}
