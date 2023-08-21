package TestCases;

import Pages.user_management_page;
import org.testng.annotations.Test;

public class DeleteNewUser_Test extends Baseclass{

    private user_management_page user_manage;

    @Test(priority=4)
    public void deleteNewUser_Test() throws InterruptedException {
        user_manage = new user_management_page(webDriver.get());
        user_manage.deleteNewUser();
    }



}
