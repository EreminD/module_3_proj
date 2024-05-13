package ru.inno.selenide.page;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.inno.selenium.pageobject.labirint.page.BookElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {
    private final ElementsCollection elements = $$(".product-card");

    public List<BookComponent> getAllBooks() {
        List<BookComponent> books = new ArrayList<>();
        elements.forEach(e -> {
            books.add(new BookComponent(e));
        });
        return books;
    }
}
