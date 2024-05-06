package ru.inno.selenium.pageobject.sampleapp;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Пользователи")
@Feature("Блокировка пользователей")
@Story("Как админ, я могу блокировать пользователя, чтобы ограничить ему доступ")
@Owner("Дмитрий Еремин")
@DisplayName("Тесты на SampleApp")
@ExtendWith(TgWatcher.class)
public class SampleAppTest {

    private WebDriver driver;
    private SampleAppPage page;

    @BeforeEach
    public void setDriver() {
        driver = new ChromeDriver();
        page = new SampleAppPage(driver);
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Успешная авторизация")
    @Description("Проверяем успешную авторизацию с паролем pwd")
    @Tags({@Tag("авторизация"), @Tag("позитивный")})
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("INNO-137")
    public void happyPathTest() {
        page.open();
        page.auth("Inno", "pwd");
        page.checkStatusHasText("Welcome, Inno!");
    }

    @Test
    @DisplayName("Вход с неправильным паролем")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("авторизация"), @Tag("негативной")})
    @TmsLink("INNO-138")
    public void wrongPassTest() {
        String login = "Inno";
        String pass = "qwerty";

        page.open();
        page.auth(login, pass);
        step("Проверить, что отображается сообщение об ошибке",
                () -> assertEquals("Invalid username/password", page.getStatus())
        );
    }

    @Test
    @DisplayName("Сабмит пустой формы")
    @Description("Проверяем, что нельзя зайти в ЛК с пустыми логином и паролем")
    @Severity(SeverityLevel.BLOCKER)
    @Tags({@Tag("авторизация"), @Tag("негативный")})
    @TmsLink("INNO-142")
    @Issue("JIRA-63")
    @Link(name = "how to", url = "https://ya.ru")
    public void blankLoginAndPass() {
        page.open();
        page.clickLogin();

        step("Проверить, что отображается сообщение об ошибке",
                () -> assertEquals("Invalid username/password !!!", page.getStatus())
        );
    }
}
