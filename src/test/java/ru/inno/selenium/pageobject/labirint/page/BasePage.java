package ru.inno.selenium.pageobject.labirint.page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final WebDriver driver;
    protected HeaderElement header;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderElement getHeader() {
        if (header == null) {
            this.header = new HeaderElement(driver);
        }
        return header;
    }
}
