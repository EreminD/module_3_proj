package ru.inno.cucumber.page;

import org.openqa.selenium.WebDriver;
import ru.inno.cucumber.DriverService;

public class CartPage {

    private final WebDriver driver;

    public CartPage(DriverService service) {
        this.driver = service.getDriver();
    }
    public void open() {
        driver.get("https://labirint.ru/cart");
    }
}
