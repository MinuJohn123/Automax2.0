package TestCases;

import Heplers.JsonReader;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Home extends BaseTest   {
    private LoginPage loginPage;
    @BeforeClass
    public void init() {
        JsonReader jsonReader = new JsonReader();

    }

    @BeforeClass
    public void login() {
        //open application URL
        webDriver.get().get(System.getProperty("target.homepage"));
        // initialize an object from login page
        loginPage = new LoginPage(webDriver.get());
        // login with username and password provided from test.properties file

        loginPage.Login(System.getProperty("account.username"),
                System.getProperty("account.password"));

    }

    @Test(priority = 1)
    public void HomeLoad() throws InterruptedException {
        System.out.println("Welcome to Automax 2.O");
    }

}
