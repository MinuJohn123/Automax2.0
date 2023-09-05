package TestCases;

import Pages.user_management_page;
import net.bytebuddy.build.Plugin;
import org.testng.annotations.Test;

public class InviteNewUser_Test extends Baseclass {

    private user_management_page user_manage;

    @Test(priority=3)
    public void inviteNewuser_Test() throws InterruptedException {
        user_manage = new user_management_page(webDriver.get());
        user_manage.inviteNewUser();
    }



}
