package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    @FindBy(xpath = "(//input[@type='text'])[1]")
    private WebElement input_edit_firstname;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement confirm_button;

    @FindBy(xpath = "(//td)[1]")
    private WebElement first_name;

    private WebDriverWait wait;
    JavascriptExecutor js;

    Actions actions;
    public user_management_page(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public void edit_user() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(user_management));
        js.executeScript("arguments[0].click()", user_management);
        wait.until(ExpectedConditions.visibilityOf(search_button));
        Thread.sleep(1000);
        js.executeScript("arguments[0].click()", search_button);
        search_button.sendKeys("Raheem");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(edit_button));
        js.executeScript("arguments[0].click()", edit_button);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(input_edit_firstname));
        actions.doubleClick(input_edit_firstname).perform();
        input_edit_firstname.sendKeys("Raheem");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(confirm_button));
        js.executeScript("arguments[0].click()", confirm_button);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(first_name));
        String edited_name=first_name.getText();
        String trimmed_edited_Text = edited_name.substring(0, edited_name.length() - 2);
        System.out.println(trimmed_edited_Text);
        Assert.assertEquals("Raheem",trimmed_edited_Text);
    }
}
