package ru.inno.selenium.pageobject.labirint.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {
    @FindBy(css = ".product-card")
    private List<WebElement> elements;

    public List<BookElement> getAllBooks() {
        List<BookElement> books = new ArrayList<>();
        for (WebElement element : elements) {
            books.add(PageFactory.initElements(element, BookElement.class));
        }
        return books;
    }
}
