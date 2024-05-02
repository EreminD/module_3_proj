package ru.inno.selenium.pageobject.labirint.test;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.inno.selenium.pageobject.labirint.page.*;

import java.util.List;

@ExtendWith(SeleniumJupiter.class)
public class LabirintTest {

    @Test
    public void booksTest(ChromeDriver driver) {
        MainPage mainPage = new MainPage(driver);
        SearchResultPage resultPage = new SearchResultPage(driver);

        mainPage.open();
        mainPage.getHeader().search("java");

        List<BookElement> books = resultPage.getAllBooks();
        for (BookElement book : books) {
            book.printInfo();
            book.addToCart();
        }

        resultPage.getHeader().search("python");
        books = resultPage.getAllBooks();
        for (BookElement book : books) {
            book.printInfo();
            book.addToCart();
        }

    }

    @Test
    public void test(ChromeDriver driver){
        Helpers helpers = new Helpers(driver);

        helpers.click(ResultPageR.books);
        helpers.sendKeys(ResultPageR.books, "tesxt");

    }
}
