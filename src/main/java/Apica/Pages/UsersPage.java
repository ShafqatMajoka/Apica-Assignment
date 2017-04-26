package Apica.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersPage extends BasePage {
    public UsersPage(WebDriver driver, String baseURL, String user, String pass) {

        super(driver, baseURL, user, pass);
    }

    public void createNewUser(String userName, String fullName, String pass, String repeatPas) {
        gotoUserPage();
        fillUserDetail(userName, fullName, pass, repeatPas);
        submit();
        documentReadyState();
    }

    private void fillUserDetail(String userName, String fullName, String pass, String repeatPas) {
        insertText(findElement(By.id("username")), userName);
        insertText(findElement(By.id("fullname")), fullName);
        insertText(findElement(By.id("password")), pass);
        insertText(findElement(By.id("password-2")), repeatPas);
    }

    private void gotoUserPage() {
        openPage(baseURL + "Users");
        documentReadyState();
        click(By.id("new-user-btn"));
    }

    private void submit() {
        click(By.id("create-user-btn"));
    }


    public String findFullNameOfUser(String userName) {
        waitUntilDOMUpdated();
        WebElement webElement = getUserData(userName);
        if (webElement == null) {
            return "User Does Not Exit";
        }
        return webElement.findElement(By.cssSelector("[data-bind*='fullname']")).getText();
    }

    private WebElement getUserData(String userName) {
        for (WebElement webElement : getUsersList()) {
            if (webElement.findElement(By.cssSelector("[data-bind*='userName']")).getText().equalsIgnoreCase(userName)) {
                return webElement;
            }
        }
        return null;
    }

    private List<WebElement> getUsersList() {
        documentReadyState();
        waitUntilDOMUpdated();
        return findElements(By.cssSelector("#usertable tbody [name='user-info']"));
    }

    public void deleteUser(String userName) {
        openPage(baseURL + "Users");
        WebElement webElement = getUserData(userName);
        By editButtonLocator = By.cssSelector("[title='Edit'] span");
        WebElement editButton = webElement.findElement(editButtonLocator);
        editButton.click();
        WebElement deleteButton = findElement(By.id("delete-user-btn"));
        acceptAlert();
        deleteButton.click();
    }
}
