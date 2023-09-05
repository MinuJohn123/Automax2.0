package TestCases;

import Heplers.JsonReader;
import Pages.LoginPage;
import Pages.UserManagementPage;
import com.google.gson.JsonObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserManagementTest extends BaseTest{
    private LoginPage loginPage;
    private UserManagementPage uPage;


    private JsonObject dataSearch;


    @BeforeClass
    public void init() {
        dataSearch = new JsonObject();
        JsonReader jsonReader = new JsonReader();
        this.uPage = new UserManagementPage(webDriver.get());
        dataSearch = jsonReader.getJsonObject(System.getProperty("path.searchData"));

    }

    @BeforeTest
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


    @Test(priority = 1)
    public void assertSearchByNameTest() throws InterruptedException {
        test = extent.createTest("assertSearchByNameTest");
        String searchName = dataSearch.get("search_Name").getAsString();
        uPage.searchByname(searchName);

    }
    @Test(priority = 2)
    public void assertSearchUsertypeTest() throws InterruptedException {
        test = extent.createTest("assertSearchUsertypeTest");
        String searchUserType = dataSearch.get("user_type").getAsString();
        uPage.searchByUserType(searchUserType);

    }
    @Test(priority = 3)
    public void assertSearch_mobNoTest() throws InterruptedException {
        test = extent.createTest("assertSearch_mobNoTest");
        String searchMob = dataSearch.get("mob_no").getAsString();
        uPage.searchByMobileno(searchMob);

    }
    @Test(priority = 4)
    public void assertSearch_EmailTest() throws InterruptedException {
        test = extent.createTest("assertSearch_EmailTest");
        String searchemail = dataSearch.get("email").getAsString();
        uPage.searchByEmail(searchemail);
    }
    @Test(priority = 5)
    public void assertSearch_groupTest() throws InterruptedException {
        test = extent.createTest("assertSearch_groupTest");
        String searchgroup = dataSearch.get("group").getAsString();
        uPage.searchBygroup(searchgroup);
    }
    @Test(priority = 6)
    public void assertSearch_IndividualusergroupTest() throws InterruptedException {
       // test = extent.createTest("assertSearch_groupTest");
       String searchgroup = dataSearch.get("group_Name").getAsString();
        uPage.searchGroup(searchgroup);
    }
}
