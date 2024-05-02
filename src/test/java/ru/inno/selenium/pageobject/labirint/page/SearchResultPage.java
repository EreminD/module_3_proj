package ru.inno.selenium.pageobject.labirint.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage{


    public SearchResultPage(WebDriver driver) {
       super(driver);
    }

    public List<BookElement> getAllBooks() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".product-card"));
        List<BookElement> books = new ArrayList<>();
        for (WebElement element : elements) {
            books.add(new BookElement(element));
        }
        return books;
    }

    public HeaderElement getHeader() {
        if (header == null) {
            this.header = new HeaderElement(driver);
        }
        return header;
    }
}
