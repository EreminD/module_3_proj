package ru.inno.selenide;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.inno.selenide.page.BookComponent;
import ru.inno.selenide.page.HeaderElement;
import ru.inno.selenide.page.MainPage;
import ru.inno.selenide.page.ResultPage;

import java.util.List;


public class LabirintTest {

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @Test
    public void booksTest() {
        MainPage mainPage = new MainPage();
        HeaderElement header = new HeaderElement();
        ResultPage resultPage = new ResultPage();

        mainPage.openPage();
        header.search("java");

        List<BookComponent> books = resultPage.getAllBooks();
        for (BookComponent book : books) {
            book.printInfo();
            book.addToCart();
        }
    }
}
