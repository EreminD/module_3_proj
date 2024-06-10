package ru.inno.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.inno.selenium.pageobject.labirint.page.MainPage;

public class MainPagestepdefs {
    private WebDriver driver;

    public MainPagestepdefs(DriverService service) {
        this.driver = service.getDriver();
    }


    @Дано("я на главной странице")
    public void openMainPage() {
        driver.get("https://labirint.ru");
    }

    @Дано("я на странице корзины")
    public void openCartPage() {
        driver.get("https://labirint.ru/cart");
    }

    @Когда("я выполняю поиск по слову {string}")
    public void searchByTerm(String keyword) {

        WebElement header = driver.findElement(By.cssSelector(".top-header"));
        header.findElement(By.cssSelector("#search-field")).clear();
        header.findElement(By.cssSelector("#search-field")).sendKeys(keyword);
        header.findElement(By.cssSelector("#searchform")).submit();
    }
}
