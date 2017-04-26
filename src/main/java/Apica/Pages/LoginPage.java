package Apica.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, String baseURL, String user, String pass) {
        super(driver, baseURL, user, pass);
    }

    public void login() {
        acceptAlert();
        openPage(baseURL);
        enterUserName();
        enterPassword();
        submit();
        documentReadyState();
    }

    private void submit() {
        click(By.cssSelector("[type='submit']"));
    }

    private void enterUserName() {
        insertText(findElement(By.id("username")), user);
    }

    private void enterPassword() {
        insertText(findElement(By.id("password")), pass);
    }
}
