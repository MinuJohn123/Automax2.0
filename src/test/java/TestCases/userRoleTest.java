package TestCases;

import Heplers.JsonReader;
import Pages.LoginPage;
import Pages.Settings_UserRole;
import Pages.UserManagementPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class userRoleTest extends BaseTest {
    private LoginPage loginPage;
    private Settings_UserRole uRole;


    private JsonObject dataSearch;


    @BeforeClass
    public void init() {
        dataSearch = new JsonObject();
        JsonReader jsonReader = new JsonReader();
        this.uRole = new Settings_UserRole(webDriver.get());

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
    public void assertRole_nameDuplication() throws InterruptedException {
        test = extent.createTest("assertCreateUserRoleTest");
        String result =  uRole.createRoleByDcheck();
        String ActResult = result.replaceAll("\n" +
                "×", "");

        System.out.println("result\n" +ActResult);
        String Exp_txt = "ERROR\n" +
                "This Role already Exists";
        System.out.println("Exp_txt \n" +Exp_txt);
        Assert.assertEquals(ActResult,Exp_txt );
        System.out.println("Assert Pass");

    }
    @Test(priority = 2)
    public void createRoleTest() throws InterruptedException {
        test = extent.createTest("assertCreateUserRoleTest");
        String rnameNew= uRole.createRole();
    }

    @Test(priority = 3)
    public void verifyAddCancel() throws InterruptedException {
        uRole.verifyCancelAdd();
    }

    @Test(priority = 4)
    public void assertRoleList() throws InterruptedException {
        test = extent.createTest("assertCreateUserRoleTest");
        uRole.verifyRoleByList();

    }
    @Test(priority = 5)
    public void assertSearchByRole() throws InterruptedException {
        test = extent.createTest("assertCreateUserRoleTest");
        uRole.verifySearchRole();
    }

    @Test(priority = 6)
    public void assertEdit() throws InterruptedException {
        test = extent.createTest("assertCreateUserRoleTest");
        String result= uRole.verifyEdit();
        String ActResult = result.replaceAll("\n" +
                "×", "");
        Thread.sleep(2000);
        String Exp_txt = "SUCCESS\n" +
                "Role information is updated";
        Assert.assertEquals(ActResult,Exp_txt );
        System.out.println("Assert Pass");
    }
    @Test(priority = 7)
    public void verifyEditCancel() throws InterruptedException {
        uRole.verifyCancelEdit();}

    @Test(priority = 8)
    public void verifyDeleteCancel() throws InterruptedException {
        uRole.verifyCancelDelete();
    }

    @Test(priority = 9)
    public void assertDelete() throws InterruptedException {
        test = extent.createTest("assertCreateUserRoleTest");
        String result = uRole.verifyDelete();;
        String ActResult = result.replaceAll("\n" +
                "×", "");
        Thread.sleep(2000);
        String Exp_txt = "SUCCESS\n" +
                "Role is deleted";
        Assert.assertEquals(ActResult,Exp_txt );

    }

}