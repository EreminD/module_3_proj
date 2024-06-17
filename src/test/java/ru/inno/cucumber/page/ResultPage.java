package ru.inno.cucumber.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.inno.cucumber.DriverService;

import java.util.List;

public class ResultPage {

    private final WebDriver driver;

    public ResultPage(DriverService service) {
        this.driver = service.getDriver();
    }

    public List<WebElement> getBooks(){
        return driver.findElements(By.cssSelector(".product-card"));
    }

    public String getErrorMessage(){
        return driver.findElement(By.cssSelector("#search h1")).getText();
    }

}
