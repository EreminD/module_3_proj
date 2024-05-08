package ru.inno.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static java.time.Duration.ofSeconds;


public class LabirintTest {

    @BeforeAll
    public static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @Test
    public void checkCookieMessage() {
        step("Открыть страницу", ()-> open("https://www.labirint.ru/"));


        $(".cookie-policy").shouldHave(text("""
                Мы используем файлы cookie и другие средства сохранения предпочтений и анализа действий посетителей сайта. Подробнее в пользовательском соглашении. Нажмите «Принять», если даете согласие на это.
                Принять!!!"""));
    }

    @Test
    public void books() {

        Configuration.baseUrl = "https://www.labirint.ru"; // test / preprod / prod
        Configuration.fastSetValue = false;
        Configuration.headless = true;
        Configuration.browser = "firefox";


//        Browser =


        open("/cart");

        $("#search-field").setValue("Java").pressEnter();
        $("#search-field").highlight();

//        String screenshot = Selenide.screenshot("inno");

        $("#search-field").should(exist, ofSeconds(10));
//        $$(".product-card").shouldHave(CollectionCondition.texts("A", "B", "C"), Duration.ofSeconds(6));
    }
}
