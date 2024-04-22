package ru.inno.selenium.browser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebElementMethods {
    private WebDriver driver;

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void iCanFindAnElementAndFillIt() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement element = driver.findElement(By.cssSelector("input[type=number]"));
        element.sendKeys("200");
    }

    @Test
    public void iCanClickOnElement() {
        driver.get("http://uitestingplayground.com/click");
        driver.findElement(By.cssSelector("#badButton")).click();
    }

    @Test
    public void fillForm() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");

        driver.findElement(By.cssSelector("input[name=first-name]")).sendKeys("Дмитрий");
        driver.findElement(By.cssSelector("input[name=zip-code]")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        String fontSize = driver.findElement(By.cssSelector("#zip-code")).getCssValue("font-size");

        assertEquals("16px", fontSize);
    }

    @Test
    public void getText() {
        driver.get("http://uitestingplayground.com/verifytext");
        List<WebElement> spans = driver.findElements(By.cssSelector(".badge-secondary")); // 4;
        String text = spans.get(1).getText();

        assertTrue(text.contains("Hello UserName!"));
    }

    @Test
    public void searchContextDemo() {
        driver.get("http://uitestingplayground.com/verifytext");

        // Вариант 1
        //        WebElement p = driver.findElement(By.cssSelector(".bg-warning"));
        //        String text = p.findElement(By.cssSelector("span")).getText();

        // Вариант 2
        String text = driver.findElement(By.cssSelector(".bg-warning span")).getText();
        assertTrue(text.contains("Hello UserName!"));
    }

    @Test
    public void submit() {
        driver.get("https://www.labirint.ru/");
        WebElement form = driver.findElement(By.cssSelector("#searchform"));
        form.findElement(By.cssSelector("input")).sendKeys("Java");
//        form.submit();
        form.findElement(By.cssSelector("button")).click();
    }

    @Test
    public void pressKeys() {
        driver.get("http://uitestingplayground.com/textinput");
        WebElement input = driver.findElement(By.cssSelector("#newButtonName"));

        input.sendKeys("Test");
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys("t");

        input.sendKeys(Keys.chord(Keys.LEFT_SHIFT, Keys.ARROW_UP)); // выделить текст
        input.sendKeys(Keys.chord(Keys.COMMAND, "CVVV")); // скопировать и вставить
    }

    @Test
    public void isMethods() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement cb = driver.findElement(By.cssSelector("#checkbox input"));
        System.out.println(cb.isSelected());
        cb.click();
        System.out.println(cb.isSelected());

        WebElement input = driver.findElement(By.cssSelector("#input-example input"));
        System.out.println(input.isEnabled());
        driver.findElement(By.cssSelector("#input-example button")).click();
        Thread.sleep(5000L); // не круто!
        System.out.println(input.isEnabled());
    }

    @Test
    public void getAttributes(){
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement form = driver.findElement(By.cssSelector("#login"));

        WebElement button = form.findElement(By.cssSelector("button"));

        String border = button.getCssValue("webkit-border-radius");
        String clsss = button.getDomAttribute("class");
        String type = button.getDomAttribute("type");
        String href = button.getDomAttribute("href");

        String inner = button.getAttribute("innerHTML");

        System.out.println("inner = " + inner);
        System.out.println("border = " + border);

        System.out.println("1 = " + clsss);
        System.out.println("2 = " + type);
        System.out.println("3 = " + href);

    }

}

