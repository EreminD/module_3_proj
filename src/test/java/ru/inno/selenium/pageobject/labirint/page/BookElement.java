package ru.inno.selenium.pageobject.labirint.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/#page-component-objects
public class BookElement {

    @FindBy(css = ".btn-tocart.buy-link")
    private WebElement addToCartButton;
    @FindBy(css = ".product-card__price-current")
    private WebElement bookPrice;
    @FindBy(css = ".product-card__name")
    private WebElement bookName;

    public void addToCart() {
        addToCartButton.click();
    }

    public void printInfo() {
        String price = bookPrice.getText();
        String title = bookName.getText();
        System.out.println(price + "\t" + title);
    }
}
