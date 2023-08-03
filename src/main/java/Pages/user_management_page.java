package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class user_management_page {


    @FindBy(xpath="//a[normalize-space()='User Management']")
    private WebElement user_management;
    @FindBy(xpath="//th[normalize-space()='First Name']//input[@aria-label='Search']")
    private WebElement firstname;
    @FindBy(xpath = "//button[@class='btn btn-sm text-primary btn-bg-white p-2 me-1 ng-tns-c3215246878-1 ng-star-inserted']")
    private WebElement edit_button;

    @FindBy(xpath = "(//input[@type='search'])[1]")
    private WebElement search_button;


    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement confirm_button;

    private WebDriverWait wait;
    JavascriptExecutor js;
    public user_management_page(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;

    }

    public void edit_user(){

        wait.until(ExpectedConditions.visibilityOf(user_management));
        js.executeScript("arguments[0].click()", user_management);
        wait.until(ExpectedConditions.visibilityOf(search_button));
        js.executeScript("arguments[0].click()", search_button);
        search_button.sendKeys("Raheem");

        wait.until(ExpectedConditions.visibilityOf(edit_button));
        js.executeScript("arguments[0].click()", edit_button);

        wait.until(ExpectedConditions.visibilityOf(confirm_button));
        js.executeScript("arguments[0].click()", confirm_button);

    }
}
