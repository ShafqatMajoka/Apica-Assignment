package Apica.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

abstract class BasePage {
    final String baseURL;
    final String user;
    final String pass;
    final WebDriverWait wait;
    final WebDriver driver;

    BasePage(WebDriver driver, String baseURL, String user, String pass) {
        this.baseURL = baseURL;
        this.user = user;
        this.pass = pass;
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }

    protected WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    protected List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }

    protected void click(By by) {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
        }
    }

    protected void insertText(WebElement webElement, String dataText) {
        webElement.clear();
        webElement.click();
        webElement.sendKeys(dataText);
    }

    protected void documentReadyState() {
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    protected void openPage(String url) {
        driver.get(url);
        documentReadyState();
    }

    public void close() {
        driver.close();
    }

    protected void acceptAlert() {
        ((JavascriptExecutor) driver).executeScript("confirm = function(message){return true;};");
        ((JavascriptExecutor) driver).executeScript("alert = function(message){return true;};");
        ((JavascriptExecutor) driver).executeScript("prompt = function(message){return true;}");
    }

    protected void waitUntilDOMUpdated() {
        //bad practice to use hardcoded wait and will find way to fix it later if get time.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //bad practice to use hardcoded wait and will find way to fix it later if get time.
    }
}
