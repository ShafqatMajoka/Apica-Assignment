package Apica.Pages;

import Apica.Driver.Driver;

public abstract class ApicaObjects {
    protected LoginPage apica;
    protected UsersPage users;

    public ApicaObjects(String driverName, String baseURL, String user, String pass) {
        Driver browser = new Driver(driverName);
        apica = new LoginPage(browser.getDriver(), baseURL, user, pass);
        users = new UsersPage(browser.getDriver(), baseURL, user, pass);
    }
}