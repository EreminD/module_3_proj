package ru.inno.selenide.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderElement {

    private SelenideElement header = $(".top-header");
    private SelenideElement searchInput = header.find("#search-field");
    private SelenideElement searchForm = header.find("#searchform");

    public void search(String term) {
        searchInput.val(term);
        searchForm.submit();
    }
}
