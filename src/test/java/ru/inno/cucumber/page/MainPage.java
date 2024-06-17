package ru.inno.cucumber.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.inno.cucumber.DriverService;

public class MainPage {
    private final WebDriver driver;

    public MainPage(DriverService service) {
        this.driver = service.getDriver();
    }

    public void open() {
        driver.get("https://labirint.ru");
    }

    public void search(String term) {
        WebElement header = driver.findElement(By.cssSelector(".top-header"));
        header.findElement(By.cssSelector("#search-field")).clear();
        header.findElement(By.cssSelector("#search-field")).sendKeys(term);
        header.findElement(By.cssSelector("#searchform")).submit();
    }
}
