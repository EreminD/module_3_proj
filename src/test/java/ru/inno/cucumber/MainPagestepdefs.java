package ru.inno.cucumber;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import ru.inno.cucumber.page.MainPage;

public class MainPagestepdefs {

    private final MainPage page;

    public MainPagestepdefs(MainPage page) {
        this.page = page;
    }

    @Дано("я на главной странице")
    public void openMainPage() {
        page.open();
    }

    @Когда("я выполняю поиск по слову {string}")
    public void searchByTerm(String keyword) {
        page.search(keyword);
    }

}
