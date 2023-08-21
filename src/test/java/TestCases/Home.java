package TestCases;

import Heplers.JsonReader;

import Pages.LoginPage;

import Pages.Userpage;
import TestCases.Baseclass;
import com.google.gson.JsonObject;
import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static TestCases.Baseclass.extent;
import static TestCases.Baseclass.webDriver;

import com.aventstack.extentreports.ExtentTest;


public class Home extends Baseclass {
    private LoginPage loginPage;
    private Userpage userpg;

    @BeforeClass
    public void init() {
        JsonReader jsonReader = new JsonReader();

    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        test = extent.createTest("LOGIN");
        //open application URL
        webDriver.get().get(System.getProperty("target.homepage"));
        // Reload the page
        webDriver.get().navigate().refresh();
        // initialize an object from login page
        loginPage = new LoginPage(webDriver.get());
        // login with username and password provided from test.properties file

        loginPage.Login(System.getProperty("account.username"),
                System.getProperty("account.password"));

    }
    @Test(priority=5)
    public void Namesearched() throws InterruptedException
    {


        userpg =new Userpage(webDriver.get());
        userpg.namesearch() ;



    }


}
