package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class user_management_page {


    @FindBy(xpath = "//a[normalize-space()='User Management']")
    private WebElement user_management;
    @FindBy(xpath = "//th[normalize-space()='First Name']//input[@aria-label='Search']")
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


// ** Elements to find  Invite New User **

    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement HomeBtn;

    @FindBy(xpath = "//button[contains(text(),' Invite New User ')]")
    private WebElement inviteNewUserBtn;

    @FindBy(xpath = "//input[@placeholder='User Type']//following::span")
    private WebElement UserType;

    @FindBy(xpath = "//*/text()[normalize-space(.)='Normal']/parent::*")
    private WebElement UserType_dropdown;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName_NewUser;

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement Username_NewUser;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password_NewUser;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email_NewUser;

    @FindBy(xpath = "//input[@placeholder='mobile Number']")
    private WebElement mobileNumber_NewUser;

    @FindBy(xpath = "//kendo-dropdowntree/span/span")
    private WebElement group_NewUser;
    @FindBy(xpath = "//*/text()[normalize-space(.)='Test Group']/parent::*")
    private WebElement group_NewUserDP;

    @FindBy(xpath = "//input[@placeholder='Gender']//following::span")
    private WebElement gender_NewUser;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Female'])[1]/preceding::li[1]")
    private WebElement gender_NewUserDP;

    @FindBy(xpath = "//input[@placeholder='Report To']//following::span")
    private WebElement reportTo_NewUser;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Jack'])[1]/following::li[1]")
    private WebElement reportTo_NewUserDp;

    @FindBy(xpath = "//input[@placeholder='Nationality']//following::span")
    private WebElement Nationality_NewUser;

    @FindBy(xpath = "//li[10]")
    private WebElement Nationality_NewUserDp;

    @FindBy(xpath = "//button[contains(text(),' Confirm ')]")
    private WebElement confirmBtn;


    // Webelements to delete an user

    @FindBy(xpath = "//td[contains(text(),'axionictest@gmail.com')]//following::button[contains(text(),'Delete')][1]")
    private WebElement DeleteBtn;

    @FindBy(tagName = "table")
    private WebElement UserTable;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement DeleteBtn_confirm;




    private WebDriverWait wait;
    JavascriptExecutor js;

    Actions actions;
    Robot robot;

    public user_management_page(WebDriver driver) {
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
        String edited_name = first_name.getText();
        String trimmed_edited_Text = edited_name.substring(0, edited_name.length() - 2);
        System.out.println(trimmed_edited_Text);
        Assert.assertEquals("Raheem", trimmed_edited_Text);
        wait.until(ExpectedConditions.visibilityOf(HomeBtn));
        js.executeScript("arguments[0].click()", HomeBtn);

    }


    public void inviteNewUser() {

        wait.until(ExpectedConditions.visibilityOf(user_management));
        js.executeScript("arguments[0].click()", user_management);

        wait.until(ExpectedConditions.visibilityOf(inviteNewUserBtn));
        js.executeScript("arguments[0].click()", inviteNewUserBtn);
      /*  try {
            robot=new Robot();
            robot.keyPress(KeyEvent.VK_F5);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }*/

        wait.until(ExpectedConditions.visibilityOf(UserType));
        js.executeScript("arguments[0].click()", UserType);
        wait.until(ExpectedConditions.visibilityOf(UserType_dropdown));
        js.executeScript("arguments[0].click()", UserType_dropdown);
        wait.until(ExpectedConditions.visibilityOf(firstName_NewUser));
        firstName_NewUser.sendKeys("Abinesh");
        Username_NewUser.sendKeys("Abinesh");
        password_NewUser.sendKeys("Leader$2023");
        email_NewUser.sendKeys("axionictest@gmail.com");
        mobileNumber_NewUser.sendKeys("8877665544");
        wait.until(ExpectedConditions.visibilityOf(group_NewUser));
        js.executeScript("arguments[0].click()", group_NewUser);
        wait.until(ExpectedConditions.visibilityOf(group_NewUserDP));
        js.executeScript("arguments[0].click()", group_NewUserDP);
        wait.until(ExpectedConditions.visibilityOf(gender_NewUser));
        js.executeScript("arguments[0].click()", gender_NewUser);
        wait.until(ExpectedConditions.visibilityOf(gender_NewUserDP));
        js.executeScript("arguments[0].click()", gender_NewUserDP);
        wait.until(ExpectedConditions.visibilityOf(reportTo_NewUser));
        js.executeScript("arguments[0].click()", reportTo_NewUser);
        wait.until(ExpectedConditions.visibilityOf(reportTo_NewUserDp));
        js.executeScript("arguments[0].click()", reportTo_NewUserDp);
        wait.until(ExpectedConditions.visibilityOf(Nationality_NewUser));
        js.executeScript("arguments[0].click()", Nationality_NewUser);
        wait.until(ExpectedConditions.visibilityOf(Nationality_NewUserDp));
        js.executeScript("arguments[0].click()", Nationality_NewUserDp);
        wait.until(ExpectedConditions.visibilityOf(confirmBtn));
        js.executeScript("arguments[0].click()", confirmBtn);

        //Assert new user
        wait.until(ExpectedConditions.visibilityOf(search_button));
        js.executeScript("arguments[0].click()", search_button);
        search_button.sendKeys("Abinesh");
        wait.until(ExpectedConditions.visibilityOf(first_name));
        String edited_name = first_name.getText();
        String trimmed_edited_Text = edited_name.substring(0, edited_name.length() - 2);
        System.out.println("New user " + trimmed_edited_Text + " has been created successfully ");
        Assert.assertEquals("Abinesh", trimmed_edited_Text);
        wait.until(ExpectedConditions.visibilityOf(HomeBtn));
        js.executeScript("arguments[0].click()", HomeBtn);


    }


    public void deleteNewUser() {

        wait.until(ExpectedConditions.visibilityOf(user_management));
        js.executeScript("arguments[0].click()", user_management);
        wait.until(ExpectedConditions.visibilityOf(search_button));
        js.executeScript("arguments[0].click()", search_button);
        search_button.sendKeys("Abinesh");
        wait.until(ExpectedConditions.visibilityOf(first_name));
        String edited_name = first_name.getText();
        String trimmed_edited_Text = edited_name.substring(0, edited_name.length() - 2);
        System.out.println("New user " + trimmed_edited_Text + " Found");
        Assert.assertEquals("Abinesh", trimmed_edited_Text);

        wait.until(ExpectedConditions.visibilityOf(DeleteBtn));
        js.executeScript("arguments[0].click()", DeleteBtn);

        wait.until(ExpectedConditions.visibilityOf(DeleteBtn_confirm));
        js.executeScript("arguments[0].click()", DeleteBtn_confirm);

        try {
            robot=new Robot();
            robot.keyPress(KeyEvent.VK_F5);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        wait.until(ExpectedConditions.visibilityOf(search_button));
        js.executeScript("arguments[0].click()", search_button);
        search_button.sendKeys("Abinesh");

       List<WebElement> tdElements= UserTable.findElements(By.tagName("td"));
        if (tdElements.size() > 0) {
            System.out.println("Selected User has been deleted and removed from the user table");
        } else {
            System.out.println("The page contain table with data.");
        }

        wait.until(ExpectedConditions.visibilityOf(HomeBtn));
        js.executeScript("arguments[0].click()", HomeBtn);


    }


}
