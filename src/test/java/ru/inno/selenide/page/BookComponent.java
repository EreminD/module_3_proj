package ru.inno.selenide.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BookComponent {
    private SelenideElement addToCartButton;
    private final SelenideElement bookPrice;
    private final SelenideElement bookName;

    public BookComponent(SelenideElement card){
        this.addToCartButton = card.find(".btn-tocart.buy-link");
        this.bookPrice = card.find(".product-card__price-current");
        this.bookName = card.find(".product-card__name");
    }
    public void addToCart() {
        addToCartButton.click();
    }

    public void printInfo() {
        String price = bookPrice.text();
        String title = bookName.text();
        System.out.println(price + "\t" + title);
    }
}
