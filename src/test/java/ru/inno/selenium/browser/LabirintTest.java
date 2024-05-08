package ru.inno.selenium.browser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabirintTest {

    private WebDriver driver;

    @BeforeEach
    public void setDriver() {

    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    public void checkCookieMessage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(ofSeconds(4));
        driver.get("https://www.labirint.ru/");
        String textToBe = """
                Мы используем файлы cookie и другие средства сохранения предпочтений и анализа действий посетителей сайта. Подробнее в пользовательском соглашении. Нажмите «Принять», если даете согласие на это.
                Принять""";

        String text = driver.findElement(By.cssSelector(".cookie-policy")).getText();
        assertEquals(textToBe, text);
    }
}
