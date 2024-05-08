package ru.inno.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ImplicitlyWaits {

    @Test
    public void waitForText() {
        Configuration.timeout = 16_000;

        open("http://uitestingplayground.com/ajax");
        $("#ajaxButton").click();
        $("#content p").shouldHave(text("Data loaded with AJAX get request."));


    }
}
