package ru.inno.selenium.pageobject.sampleapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleAppPage {
    @FindBy(css = "#loginstatus")
    private WebElement status;

    @FindBy(how = How.CSS, using = "[name=UserName]")
    private WebElement username;

    @FindBy(how = How.CSS, using = "[name=Password]")
    private WebElement pass;

    @FindBy(css = "#login")
    private WebElement login;


    public String getStatus() {
        return status.getText();
    }

    public void setLogin(String login) {
        username.sendKeys(login);
    }

    public void setPass(String pass) {
        this.pass.sendKeys(pass);
    }

    public void clickLogin() {
        login.click();
    }

    public void auth(String login, String pass) {
        this.setLogin(login);
        this.setPass(pass);
        this.clickLogin();
    }

    public void checkStatusHasText(String textToBe) {
        assertEquals(textToBe, this.getStatus());
    }
}
