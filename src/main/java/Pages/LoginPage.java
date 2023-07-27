package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    @FindBy(xpath="//input[@placeholder='User Name']")
    private WebElement userNameTxt;
    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement passWordTxt;
    @FindBy(xpath = "//button[@id='automax_sign_in_submit']")
    private WebElement loginBtn;
    private WebDriverWait wait;


    public  LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void Login(String username, String password) {

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(userNameTxt),
                ExpectedConditions.visibilityOf(passWordTxt),
                ExpectedConditions.visibilityOf(loginBtn)));


        this.userNameTxt.sendKeys(username);
        this.passWordTxt.sendKeys(password);

        this.loginBtn.click();
    }

}
