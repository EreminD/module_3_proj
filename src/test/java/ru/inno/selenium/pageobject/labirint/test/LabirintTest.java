package ru.inno.selenium.pageobject.labirint.test;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.inno.selenium.pageobject.labirint.page.*;

import java.util.List;

@Epic("Каталог")
@Feature("Поиск по сайту")
@ExtendWith(SeleniumJupiter.class)
public class LabirintTest {
    @Story("Как пользователь, я могу искать товары на сайте, чтобы быстрее находить интересный мне товар")
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

    }
}
