package TestCases;

import Heplers.JsonReader;
import Pages.LoginPage;
import Pages.user_management_page;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static TestCases.Baseclass.webDriver;

public class Edit_user_details extends Baseclass {

    private user_management_page user_manage;

    @Test(priority = 2)
    public void edit_user() throws InterruptedException {
        user_manage = new user_management_page(webDriver.get());
        user_manage.edit_user();
    }





}
