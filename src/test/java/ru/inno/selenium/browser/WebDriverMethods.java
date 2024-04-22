package ru.inno.selenium.browser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverMethods {

    private WebDriver driver;

    @BeforeEach
    public void setDriver(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void quit(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    public void getAndClose(){
        driver.get("https://ya.ru");  // протокол!
        driver.close(); // закрыть вкладку
    }

    @Test
    public void getInfo(){
        driver.get("http://habr.com/ru");

        String url = driver.getCurrentUrl();
        String title = driver.getTitle();

        assertEquals("https://habr.com/ru/feed/", url);
        assertEquals("Публикации / Моя лента / Хабр", title);
    }

    @Test
    public void navigate(){
        driver.navigate().to("https://habr.com/ru/feed/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @Test
    public void handles(){
        driver.get("http://the-internet.herokuapp.com/windows");

        driver.findElement(By.cssSelector(".example a")).click(); // click

        String currentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        tabs.remove(currentTab);
        String lastTab = new ArrayList<>(tabs).get(0);

        driver.switchTo().window(lastTab);
        String text = driver.findElement(By.cssSelector(".example h3")).getText();

        assertEquals("New Window", text);
    }

    @Test
    public void window(){
        driver.manage().window().maximize(); // use me
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
    }

    @Test
    public void windowManipulation(){
        driver.manage().window().setPosition(new Point(-200,0));
        Point position = driver.manage().window().getPosition();
        System.out.println("position = " + position);

        driver.manage().window().setSize(new Dimension(1500, 1000));
        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size);
    }

    @Test
    public void cookies(){
        driver.get("https://labirint.ru");
        driver.manage().addCookie(new Cookie("cookie_policy", "1"));
        driver.navigate().refresh();
    }

    @Test
    public void authViaCookies(){
        driver.get("https://trello.com/u/eremin_/boards");
        driver.manage().addCookie(new Cookie("cloud.session.token", "12345"));
        driver.navigate().refresh();
        driver.navigate().to("https://trello.com/u/eremin_/boards");
        driver.get("https://trello.com/u/eremin_/boards");
        
        String token = driver.manage().getCookieNamed("cloud.session.token").getValue();
        System.out.println("token = " + token);
    }


}



// Примеры на разницу между navigate.to и get
// https://www.baeldung.com/selenium-webdriver-get-vs-navigate