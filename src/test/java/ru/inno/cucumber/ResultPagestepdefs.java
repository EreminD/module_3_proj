package ru.inno.cucumber;

import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultPagestepdefs {
    private WebDriver driver;

    public ResultPagestepdefs(DriverService service) {
        this.driver = service.getDriver();
    }

    @Тогда("я вижу список товаров со словом {string}")
    public void checkISeeItems(String searchTerm) {
        List<WebElement> books = driver.findElements(By.cssSelector(".product-card"));

        books.forEach(book -> {
            String title = book.findElement(By.cssSelector(".product-card__name")).getText();
            System.out.println(title);
            assertTrue(title.contains(searchTerm));
        });

        assertTrue(books.size() > 0);
    }
}

