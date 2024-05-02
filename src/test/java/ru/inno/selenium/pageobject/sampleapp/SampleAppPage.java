package ru.inno.selenium.pageobject.sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleAppPage {
    private final WebDriver driver;

    public SampleAppPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getStatus() {
        return driver.findElement(By.cssSelector("#loginstatus")).getText();
    }

    public void setLogin(String login) {
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys(login);
    }

    public void setPass(String pass) {
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys(pass);
    }

    public void open() {
        driver.get("http://uitestingplayground.com/sampleapp");
    }

    public void clickLogin() {
        driver.findElement(By.cssSelector("#login")).click(); // "надо клик добавить!"
    }

    public void auth(String login, String pass){
        this.setLogin(login);
        this.setPass(pass);
        this.clickLogin();
    }

    // если очень хочется положить проверки в Page-классы
    public void checkStatusHasText(String textToBe){
        assertEquals(textToBe, this.getStatus());
    }
}
