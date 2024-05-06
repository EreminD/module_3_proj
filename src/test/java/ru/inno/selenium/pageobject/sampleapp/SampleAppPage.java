package ru.inno.selenium.pageobject.sampleapp;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleAppPage {
    private final WebDriver driver;

    public SampleAppPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получить статус")
    public String getStatus() {
        getPageScreen();
        saveSQL();
        return driver.findElement(By.cssSelector("#loginstatus")).getText();
    }

    @Attachment(value = "screen.png", type = "image/png", fileExtension = ".png")
    private byte[] getPageScreen(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "select.sql", type = "text/plain", fileExtension = ".sql")
    private String saveSQL(){
        return "SELECT * FROM USERS";
    }

    @Step("Указать логин {login}")
    public void setLogin(String login) {
        driver.findElement(By.cssSelector("[name=UserName]")).sendKeys(login);
    }

    @Step("Указать пароль {pass}")
    public void setPass(String pass) {
        driver.findElement(By.cssSelector("[name=Password]")).sendKeys(pass);
    }

    @Step("Открыть страницу")
    public void open() {
        driver.get("http://uitestingplayground.com/sampleapp");
    }

    @Step("Нажать на кнопку Log In")
    public void clickLogin() {
        driver.findElement(By.cssSelector("#login")).click(); // "надо клик добавить!"
    }

    @Step("Авторизоваться {login}:{pass}")
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
