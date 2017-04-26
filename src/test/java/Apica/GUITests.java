package Apica;

import Apica.Pages.ApicaObjects;
import Apica.TestData.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GUITests extends ApicaObjects {
    private final String userName;
    private final String fullName;
    private final String password;

    GUITests() {
        super("chrome", "http://wpm-trial.apicasystem.com/"
                , "hshafqat@outlook.com", "apica2017");
        TestData testData = new TestData();
        userName = testData.getUserName();
        fullName = testData.getFullName();
        password = testData.getPassword();
    }

    @Test
    public void createUser() {
        users.createNewUser(userName, fullName, password, password);
        Assert.assertEquals(users.findFullNameOfUser(userName), fullName);
    }

    @Test(dependsOnMethods = "createUser")
    public void deleteUser() {
        users.deleteUser(userName);
        Assert.assertEquals(users.findFullNameOfUser(userName), "User Does Not Exit");
    }

    @BeforeClass
    public void login() {
        apica.login();
    }

    @AfterClass
    public void teardown() {
        apica.close();
    }
}
