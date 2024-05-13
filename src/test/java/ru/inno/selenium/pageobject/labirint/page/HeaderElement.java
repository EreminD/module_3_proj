package ru.inno.selenium.pageobject.labirint.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderElement {
    @FindBy(css = ".top-header")
    private WebElement header;

    public void search(String term) {
        header.findElement(By.cssSelector("#search-field")).clear();
        header.findElement(By.cssSelector("#search-field")).sendKeys(term);
        header.findElement(By.cssSelector("#searchform")).submit();
    }
}
