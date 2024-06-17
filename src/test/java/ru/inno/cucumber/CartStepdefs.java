package ru.inno.cucumber;

import io.cucumber.java.ru.Тогда;
import ru.inno.cucumber.page.CartPage;

public class CartStepdefs {
    private final CartPage page;

    public CartStepdefs(CartPage page) {
        this.page = page;
    }

    @Тогда("я на странице корзины")
    public void open() {
        page.open();
    }
}
