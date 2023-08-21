package Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Userpage {

    private WebDriverWait wait;



    JavascriptExecutor js;
    // @FindBy(xpath="//*[text()=' User Management ']")
    @FindBy(xpath="//a[normalize-space()='User Management']")
    private WebElement usermngmod ;


    @FindBy(xpath="/html/body/app-root/ng-component/div/div/div/div/div/app-user-list/div[1]/div/div[2]/div[2]/div/table/thead/tr/th[1]/div/input")
    private WebElement search;


    @FindBy(xpath="//*[starts-with(text(),' Syed')]")
    private WebElement namefirst;
    //public  UserPage(WebDriver driver)
    public Userpage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60)) ;
        js = (JavascriptExecutor) driver  ;

    }

    public void namesearch() throws InterruptedException
    {

        // wait.until(ExpectedConditions.elementToBeClickable(usermngmod));
        //js.executeScript("arguments[0].click()", usermngmod);
        wait.until(ExpectedConditions.elementToBeClickable(search));
        js.executeScript("arguments[0].click()", search);
        search.sendKeys("Syed");
        Thread.sleep(1000);
        String actual="Syed";
        String originalstring=namefirst.getText();
        System.out.println(originalstring);
        String expected=originalstring.substring(0,4);
        Thread.sleep(1000);
        Assert.assertEquals(actual,expected);
        System.out.println("First name search is done succesfully ");

    }

}
