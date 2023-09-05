package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class Userpage {

    private WebDriverWait wait;



    JavascriptExecutor js;

//Firstname search
    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement HomeBtn;
    @FindBy(xpath="//a[normalize-space()='User Management']")
    private WebElement usermngmod ;


    @FindBy(xpath="/html/body/app-root/ng-component/div/div/div/div/div/app-user-list/div[1]/div/div[2]/div[2]/div/table/thead/tr/th[1]/div/input")
    private WebElement search;

    @FindBy(xpath="//*[starts-with(text(),' Syed')]")
    private WebElement namefirst;

    //Add user Nationality
  @FindBy(xpath="/html/body/app-root/ng-component/div/div/div/app-sidebar/div/app-sidebar-menu/div/div/div/div[1]/div/div[2]/span/span[2]")
private WebElement settingsicn;


  @FindBy(xpath="/html/body/app-root/ng-component/div/div/div/app-sidebar/div/app-sidebar-menu/div/div/div/div[1]/div/div[2]/div/div[4]/a/span[2]")
  private WebElement natnbtn;

  @FindBy(xpath="//button[text()=' Add User Nationality ']")
  private WebElement addusrntn;

  @FindBy(xpath = "//input[@id=\"nationalityName\"]")
  private WebElement natnnameeng;

  @FindBy(xpath = "//button[text()=' Save ']")
  private WebElement savebtn;
  @FindBy(xpath = "//input[@placeholder='Search']")
  private WebElement srchicn;

    @FindBy(tagName = "table")
    private WebElement Table;
    //Edit usr Natinality
    @FindBy(xpath="/html/body/app-root/ng-component/div/div/div/div/div/app-nationality/div[1]/div/div[3]/div/table/tbody/tr[1]/td[4]/a[1]")
    private WebElement editbtn;

    @FindBy(xpath="//input[@id='nationalityName']")
    private WebElement ntnedt;

    //Delete user Nationality
    //@FindBy(xpath="/html/body/app-root/ng-component/div/div/div/div/div/app-nationality/div[1]/div/div[3]/div/table/tbody/tr[2]/td[4]/a[2]")
    @FindBy(xpath="/html/body/app-root/ng-component/div/div/div/div/div/app-nationality/div[1]/div/div[3]/div/table/tbody/tr[8]/td[4]/a[2]")
    private WebElement delbtn;



    @FindBy(xpath="//*[text()='Confirm']")
    private WebElement confrmbtn;





    //public  UserPage(WebDriver driver)
    public Userpage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60)) ;
        js = (JavascriptExecutor) driver  ;

    }

    public void namesearch() throws InterruptedException
    {

         wait.until(ExpectedConditions.elementToBeClickable(usermngmod));
        js.executeScript("arguments[0].click()", usermngmod);
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
        wait.until(ExpectedConditions.visibilityOf(HomeBtn));
        js.executeScript("arguments[0].click()", HomeBtn);
        Thread.sleep(2000);

    }

    public void usernation()  throws InterruptedException
    {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(usermngmod));
        js.executeScript("arguments[0].click()", usermngmod);
        wait.until(ExpectedConditions.elementToBeClickable(settingsicn));
        js.executeScript("arguments[0].click()", settingsicn);
        wait.until(ExpectedConditions.elementToBeClickable(natnbtn));
        js.executeScript("arguments[0].click()", natnbtn);
        wait.until(ExpectedConditions.elementToBeClickable(addusrntn));
        js.executeScript("arguments[0].click()", addusrntn);
        wait.until(ExpectedConditions.elementToBeClickable(natnnameeng));
        js.executeScript("arguments[0].click()", natnnameeng);
      natnnameeng.sendKeys("India");
        wait.until(ExpectedConditions.elementToBeClickable(savebtn));
        js.executeScript("arguments[0].click()", savebtn);
        wait.until(ExpectedConditions.elementToBeClickable(srchicn));
        js.executeScript("arguments[0].click()", srchicn);
        srchicn.sendKeys("India");
       List<WebElement> tdElements= Table.findElements(By.tagName("td"));
        if (tdElements.size() > 0) {
            System.out.println("Add user Nationality is added");
        } else {
            System.out.println("Add user Nationality is not  added");
        }
        wait.until(ExpectedConditions.visibilityOf(HomeBtn));
        js.executeScript("arguments[0].click()", HomeBtn);
        Thread.sleep(2000);






    }
    public void usrntnedit()  throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(usermngmod));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", usermngmod);
        wait.until(ExpectedConditions.elementToBeClickable(settingsicn));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", settingsicn);
        wait.until(ExpectedConditions.elementToBeClickable(natnbtn));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", natnbtn);
        wait.until(ExpectedConditions.elementToBeClickable(editbtn));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", editbtn);
        wait.until(ExpectedConditions.elementToBeClickable(ntnedt));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", ntnedt);
        ntnedt.sendKeys("cde");
        wait.until(ExpectedConditions.elementToBeClickable(savebtn));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", savebtn);
        wait.until(ExpectedConditions.elementToBeClickable(srchicn));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", srchicn);
        srchicn.sendKeys("cde");
        Thread.sleep(2000);
        List<WebElement> tdElements= Table.findElements(By.tagName("td"));
        if (tdElements.size() > 0) {
            System.out.println("User Nationality is edited suceesfully");
        } else {
            System.out.println("User Nationality is not  edited ");
        }
        wait.until(ExpectedConditions.visibilityOf(HomeBtn));
        js.executeScript("arguments[0].click()", HomeBtn);


    }

    public void usrntndel()  throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(usermngmod));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", usermngmod);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(settingsicn));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", settingsicn);
        wait.until(ExpectedConditions.elementToBeClickable(natnbtn));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", natnbtn);
        wait.until(ExpectedConditions.elementToBeClickable(delbtn));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", delbtn);
        wait.until(ExpectedConditions.elementToBeClickable(confrmbtn));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", confrmbtn);
        wait.until(ExpectedConditions.elementToBeClickable(srchicn));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", srchicn);
        srchicn.sendKeys("Indian");
        Thread.sleep(2000);
        List<WebElement> tdElements= Table.findElements(By.tagName("td"));
        if (tdElements.size() >0) {
            System.out.println("User Nationality is  deleted");
        } else {
            System.out.println("User Nationality is not  deleted ");
        }
        wait.until(ExpectedConditions.visibilityOf(HomeBtn));
        js.executeScript("arguments[0].click()", HomeBtn);
        Thread.sleep(2000);


    }






}
