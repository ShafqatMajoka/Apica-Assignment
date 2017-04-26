package Apica.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    protected WebDriver driver;

    public Driver(String driverName) {
        init(driverName);
    }

    void init(String driverName) {
        if (driverName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C://Webdrivers/chromedriver.exe");
            this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();
        }

    }

    public WebDriver getDriver() {
        return driver;
    }
}
