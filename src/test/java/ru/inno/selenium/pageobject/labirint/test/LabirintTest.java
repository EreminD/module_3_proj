package ru.inno.selenium.pageobject.labirint.test;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ru.inno.selenium.pageobject.labirint.page.BookElement;
import ru.inno.selenium.pageobject.labirint.page.HeaderElement;
import ru.inno.selenium.pageobject.labirint.page.MainPage;
import ru.inno.selenium.pageobject.labirint.page.SearchResultPage;

import java.util.List;

@Epic("Каталог")
@Feature("Поиск по сайту")
@ExtendWith(SeleniumJupiter.class)
public class LabirintTest {

    private MainPage mainPage;
    private SearchResultPage resultPage;
    private HeaderElement header;

    @BeforeEach
    public void setUp(ChromeDriver driver){
        mainPage = PageFactory.initElements(driver, MainPage.class);
        resultPage = PageFactory.initElements(driver, SearchResultPage.class);
        header = PageFactory.initElements(driver, HeaderElement.class);
    }

    @Test
    public void booksTest() {
        mainPage.open();
        header.search("java");

        List<BookElement> books = resultPage.getAllBooks();
        for (BookElement book : books) {
            book.printInfo();
            book.addToCart();
        }
    }
}
