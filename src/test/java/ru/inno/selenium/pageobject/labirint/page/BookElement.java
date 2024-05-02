package ru.inno.selenium.pageobject.labirint.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// PageElements
public class BookElement {

    private final WebElement element;

    public BookElement(WebElement element) {
        this.element = element;
    }

    public void addToCart() {
        element.findElement(By.cssSelector(".btn-tocart.buy-link")).click();
    }

    public void printInfo() {
        String price = element.findElement(By.cssSelector(".product-card__price-current")).getText();
        String title = element.findElement(By.cssSelector(".product-card__name")).getText();
        System.out.println(price + "\t" + title);
    }
}
