package ru.inno.cucumber;

import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.inno.cucumber.page.ResultPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultPagestepdefs {
    private final ResultPage page;

    public ResultPagestepdefs(ResultPage page) {
        this.page = page;
    }

    @Тогда("я вижу список товаров со словом {string}")
    public void checkISeeItems(String searchTerm) {
        List<WebElement> books = page.getBooks();
        books.forEach(book -> {
            String title = book.findElement(By.cssSelector(".product-card__name")).getText();
            System.out.println(title);
            assertTrue(title.contains(searchTerm));
        });
        assertTrue(books.size() > 0);
    }

    @Тогда("я вижу сообщение {string}")
    public void checkISeeEmptyResultMessage(String message) {
        assertEquals(message, page.getErrorMessage());
    }
}

