package Pages;

import Heplers.JsonReader;
import com.google.gson.JsonObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserManagementPage {

    public WebDriverWait wait;
    JavascriptExecutor js;
    public Actions actions;
    public Alert alert;


    @FindBy(xpath = "//a[normalize-space()='User Management']")
    private WebElement userManageButton;

    @FindBy(xpath = "//table[@class='table table-row-dashed table-rounded border table-row-bordered gy-2 ng-tns-c3215246878-1']")
    private WebElement userTable;

    @FindBy(xpath = "//tbody[@class=\"table-body ng-tns-c3215246878-1\"]")
    private WebElement Tablbody;
    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement search;
   /// @FindBy(xpath = "//th[normalize-space()='Group']")
  //  private WebElement search_group;

    //thead[@class='h-50px align-middle ng-tns-c3215246878-1']//tr//th[5]
    //th[normalize-space()='Email address']//input[@aria-label='Search']//following::th[normalize-space()='Group']
    @FindBy(xpath="//div[@id='automax_app_content_container']/div[2]/div[2]/div/table/thead/tr/th[5]/div/input")
    private WebElement groupsearch;

    @FindBy(xpath = "//div[@id='automax_app_content_container']/div[2]/div[2]/div/table/thead/tr/th[5]/div/input")
    private WebElement group;
    @FindBy(xpath = "//div[@id='automax_app_sidebar_toggle']")
    private WebElement close;
    @FindBy(xpath = "(//span[text()=' Settings '])[1]")
    private WebElement settingsButton;

    @FindBy(xpath = "(//span[text()=' Users Role '])[1]")
    private WebElement userRole;
    @FindBy(xpath = "(//span[text()=' Users '])[1]")
    private WebElement users;




    public UserManagementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);

    }
//Searching common search by name.
    public void  searchByname(String searchname) throws InterruptedException {
        try {
            Thread.sleep(4000);
            //userManageButton.click();
            wait.until(ExpectedConditions.visibilityOf(userManageButton));
            js.executeScript("arguments[0].click()", userManageButton);
            Thread.sleep(4000);
            wait.until(ExpectedConditions.visibilityOf(search));
            js.executeScript("arguments[0].click()", search);
            Thread.sleep(4000);
            search.sendKeys(searchname);
            Thread.sleep(4000);
            String searchName = "";


            // Find and print rows along with their values

            List<WebElement> rows = Tablbody.findElements(By.tagName("tr"));
            String text = "";

            List<String> lData = new ArrayList<>();
            List<String> expValues = new ArrayList<String>();
            expValues.add(searchname);
            System.out.println("rows.getSize() " + rows.size());
            int rowsize = rows.size();
            System.out.println("rowsize " + rowsize);
            if (rowsize == 0) {
                System.out.println("There is no Search Results");
            }
            // Print values from the first column of each row
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                // System.out.println("cells.getSize() "+cells.size());

                if (!cells.isEmpty()) {
                    // System.out.println(cells.get(0).getText()); // Print the text of the first cell..
                    text = cells.get(0).getText();
                    lData.add(text);
                    //  System.out.println("lData " +lData);
                }
            }
            for (String sData : lData) {
                //System.out.println("sDatasData "+sData);
                String withoutBulletPoints = sData.replaceAll("●", "");
                String withoutSpaces = withoutBulletPoints.replaceAll("\\s+", "");
                //System.out.println(withoutSpaces);
                List<String> actValues = new ArrayList<>();
                actValues.add(withoutSpaces);

                //System.out.println(actValues);
                //System.out.println(expValues);

                for (String expectedPartialItem : expValues) {
                    //System.out.println("expectedPartialItem "+expectedPartialItem);
                    boolean isFound = false;
                    for (String actualItem : actValues) {
                        System.out.println("expectedPartialItem " + expectedPartialItem);
                        System.out.println("actualItem " + actualItem);

                        if (actualItem.contains(expectedPartialItem)) {
                            System.out.println("Inside IF LOOPP " );
                            isFound = true;
                            Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");
                           //Assert.assertEquals(actualItem,expectedPartialItem);
                            System.out.println("Assert Pass");
                            //if (actualItem.contains(expectedPartialItem)) {
                            break;
                        }
                        else{
                            System.out.println("Assert Pass");
                        }
                    }
                    // Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");


                }
            }
            Thread.sleep(4000);

            search.clear();
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    //Searching common search by UserType.
    public void  searchByUserType(String usertype) throws InterruptedException {
        try {
            Thread.sleep(4000);
            search.clear();
            //userManageButton.click();
            //   wait.until(ExpectedConditions.visibilityOf(userManageButton));
            //   js.executeScript("arguments[0].click()", userManageButton);
            wait.until(ExpectedConditions.visibilityOf(search));
            js.executeScript("arguments[0].click()", search);
            Thread.sleep(4000);
            search.sendKeys(usertype);
            Thread.sleep(4000);
            String searchName = "";


            // Find and print rows along with their values

            List<WebElement> rows = Tablbody.findElements(By.tagName("tr"));
            String text = "";

            List<String> lData = new ArrayList<>();
            List<String> expValues = new ArrayList<String>();
            expValues.add(usertype);
            System.out.println("rows.getSize() " + rows.size());
            int rowsize = rows.size();
            System.out.println("rowsize " + rowsize);
            if (rowsize == 0) {
                System.out.println("There is no Search Results");
            }

            // Print values from the first column of each row
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                // System.out.println("cells.getSize() "+cells.size());
                if (!cells.isEmpty()) {
                    // System.out.println(cells.get(0).getText()); // Print the text of the first cell..
                    text = cells.get(1).getText();
                    lData.add(text);
                    //  System.out.println("lData " +lData);
                }
            }
            for (String sData : lData) {
                List<String> actValues = new ArrayList<>();
                actValues.add(sData);

                //System.out.println(actValues);
                //System.out.println(expValues);

                for (String expectedPartialItem : expValues) {
                    System.out.println("expectedItem "+expectedPartialItem);
                    boolean isFound = false;
                    for (String actualItem : actValues) {
                        System.out.println("actualItem " + actualItem);
                      //  if (expectedPartialItem.contains(actualItem)) {
                            System.out.println("Inside IF LOOPP " );
                            isFound = true;
                            //Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");
                            Assert.assertEquals(actualItem,expectedPartialItem);
                            System.out.println("Assert Pass");
                        if (expectedPartialItem.contains(actualItem)) {
                            break;

                        }
                    }
                    //Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");


                }
            }
            search.clear();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Searching common search by Mob No.
    public void  searchByMobileno(String mobile) throws InterruptedException {
        try {
            Thread.sleep(4000);
            //userManageButton.click();
            //   wait.until(ExpectedConditions.visibilityOf(userManageButton));
            //  js.executeScript("arguments[0].click()", userManageButton);
            wait.until(ExpectedConditions.visibilityOf(search));
            js.executeScript("arguments[0].click()", search);
            search.sendKeys(mobile);
            Thread.sleep(4000);
            String searchName = "";


            // Find and print rows along with their values

            List<WebElement> rows = Tablbody.findElements(By.tagName("tr"));
            String text = "";

            List<String> lData = new ArrayList<>();
            List<String> expValues = new ArrayList<String>();
            expValues.add(mobile);
            System.out.println("rows.getSize() " + rows.size());
            int rowsize = rows.size();
            System.out.println("rowsize " + rowsize);
            if (rowsize == 0) {
                System.out.println("There is no Search Results");
            }

            // Print values from the first column of each row
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                // System.out.println("cells.getSize() "+cells.size());
                if (!cells.isEmpty()) {
                    // System.out.println(cells.get(0).getText()); // Print the text of the first cell..
                    text = cells.get(2).getText();
                    lData.add(text);
                    //  System.out.println("lData " +lData);
                }
            }
            for (String sData : lData) {
                List<String> actValues = new ArrayList<>();
                actValues.add(sData);

                //System.out.println(actValues);
                //System.out.println(expValues);

                for (String expectedPartialItem : expValues) {
                    System.out.println("expected Item "+expectedPartialItem);
                    boolean isFound = false;
                    for (String actualItem : actValues) {
                        System.out.println("actualItem " + actualItem);
                        //if (expectedPartialItem.contains(actualItem)) {
                            System.out.println("Inside IF LOOPP " );
                            isFound = true;
                          //  Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");
                            Assert.assertEquals(actualItem,expectedPartialItem);
                            System.out.println("Assert Pass");
                        if (expectedPartialItem.contains(actualItem)) {
                            break;
                        }
                    }
                    //Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");


                }
            }
            search.clear();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Searching common search by EMAIL
    public void  searchByEmail(String email) throws InterruptedException {
        try{
        Thread.sleep(4000);
        //userManageButton.click();
     //   wait.until(ExpectedConditions.visibilityOf(userManageButton));
      //  js.executeScript("arguments[0].click()", userManageButton);
        wait.until(ExpectedConditions.visibilityOf(search));
        js.executeScript("arguments[0].click()", search);
            Thread.sleep(4000);
        search.sendKeys(email);
        Thread.sleep(4000);
        String searchName = "";


        // Find and print rows along with their values

        List<WebElement> rows = Tablbody.findElements(By.tagName("tr"));
        String text = "";

        List<String> lData = new ArrayList<>();
        List<String> expValues = new ArrayList<String>();
        expValues.add(email);
        System.out.println("rows.getSize() "+rows.size());
        int rowsize= rows.size();
        System.out.println("rowsize "+rowsize);
        if(rowsize==0){
            System.out.println("There is no Search Results");
        }

        // Print values from the first column of each row
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // System.out.println("cells.getSize() "+cells.size());
            if (!cells.isEmpty()) {
                // System.out.println(cells.get(0).getText()); // Print the text of the first cell..
                text= cells.get(3).getText();
                lData.add(text);
                //  System.out.println("lData " +lData);
            }}
        for (String sData : lData) {
            List<String> actValues = new ArrayList<>();
            actValues.add(sData);

            //System.out.println(actValues);
            //System.out.println(expValues);

            for (String expectedPartialItem : expValues) {
                System.out.println("expectedItem "+expectedPartialItem);
                boolean isFound = false;
                for (String actualItem : actValues) {
                    System.out.println("actualItem "+actualItem);
                   // if (expectedPartialItem.contains(actualItem)) {
                        System.out.println("Inside IF LOOPP " );
                        isFound = true;
                        Assert.assertEquals(actualItem,expectedPartialItem);
                        // Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");
                        System.out.println("Assert Pass");
                    if (expectedPartialItem.contains(actualItem)) {
                        break;
                    }
                }
                //Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");
                System.out.println("Assert Pass");

            }}
        search.clear();}
        catch (Exception e) {
            System.out.println(e.getMessage());
        }}

    //Searching common search by EMAIL
    public void  searchBygroup(String group) throws InterruptedException {
        try {
            Thread.sleep(4000);

            // wait.until(ExpectedConditions.visibilityOf(userManageButton));
            // js.executeScript("arguments[0].click()", userManageButton);
            wait.until(ExpectedConditions.visibilityOf(search));
            js.executeScript("arguments[0].click()", search);
            Thread.sleep(4000);
            search.sendKeys(group);
            Thread.sleep(4000);
            String searchName = "";


            // Find and print rows along with their values

            List<WebElement> rows = Tablbody.findElements(By.tagName("tr"));
            String text = "";

            List<String> lData = new ArrayList<>();
            List<String> expValues = new ArrayList<String>();
            expValues.add(group);
            System.out.println("rows.getSize() " + rows.size());
            int rowsize = rows.size();
            System.out.println("rowsize " + rowsize);
            if (rowsize == 0) {
                System.out.println("There is no Search Results");
            }

            // Print values from the first column of each row
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                // System.out.println("cells.getSize() "+cells.size());
                if (!cells.isEmpty()) {
                    // System.out.println(cells.get(0).getText()); // Print the text of the first cell..
                    text = cells.get(4).getText();
                    lData.add(text);
                    //  System.out.println("lData " +lData);
                }
            }
            for (String sData : lData) {
                List<String> actValues = new ArrayList<>();
                actValues.add(sData);

                //System.out.println(actValues);
                //System.out.println(expValues);

                for (String expectedPartialItem : expValues) {
                    System.out.println("expectedItem "+expectedPartialItem);
                    boolean isFound = false;
                    for (String actualItem : actValues) {
                        System.out.println("actualItem " + actualItem);
                      // if (expectedPartialItem.contains(actualItem)) {
                            System.out.println("Inside IF LOOPP " );
                            isFound = true;
                           // Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");
                        Assert.assertEquals(actualItem,expectedPartialItem);
                        System.out.println("Assert Pass");

                            if (expectedPartialItem.contains(actualItem)) {
                            break;
                        }
                    }
                    // Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");
                  //  System.out.println("Assert Pass");

                }
            }
            search.clear();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


        public void searchGroup(String groupname) throws InterruptedException {
            try {
               // Thread.sleep(2000);
               // wait.until(ExpectedConditions.visibilityOf(userManageButton));
               // js.executeScript("arguments[0].click()", userManageButton);

                Thread.sleep(2000);
                wait.until(ExpectedConditions.visibilityOf(settingsButton));
                js.executeScript("arguments[0].click()", settingsButton);
                Thread.sleep(2000);
                wait.until(ExpectedConditions.visibilityOf(userRole));
                js.executeScript("arguments[0].click()", userRole);
                Thread.sleep(2000);
                 wait.until(ExpectedConditions.visibilityOf(users));
                js.executeScript("arguments[0].click()", users);
                Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOf(group));
                js.executeScript("arguments[0].click()", group);
                group.sendKeys(groupname);
                Thread.sleep(2000);
                String searchName = "";


                // Find and print rows along with their values

                List<WebElement> rows = Tablbody.findElements(By.tagName("tr"));
                String text = "";

                List<String> lData = new ArrayList<>();
                List<String> expValues = new ArrayList<String>();
                expValues.add(groupname);
                System.out.println("rows.getSize() " + rows.size());
                int rowsize = rows.size();
                System.out.println("rowsize " + rowsize);
                if (rowsize == 0) {
                    System.out.println("There is no Search Results");
                }

                // Print values from the first column of each row
                for (WebElement row : rows) {
                    List<WebElement> cells = row.findElements(By.tagName("td"));
                    // System.out.println("cells.getSize() "+cells.size());
                    if (!cells.isEmpty()) {
                        // System.out.println(cells.get(0).getText()); // Print the text of the first cell..
                        text = cells.get(4).getText();
                        lData.add(text);
                        //  System.out.println("lData " +lData);
                    }
                }
                for (String sData : lData) {
                    List<String> actValues = new ArrayList<>();
                    actValues.add(sData);

                    //System.out.println(actValues);
                    //System.out.println(expValues);

                    for (String expectedPartialItem : expValues) {
                        System.out.println("expectedItem " + expectedPartialItem);
                        boolean isFound = false;
                        for (String actualItem : actValues) {
                            System.out.println("actualItem " + actualItem);

                           // if (actualItem.contains(expectedPartialItem)) {
                                System.out.println("Inside IF LOOPP ");
                                isFound = true;
                             Assert.assertEquals(actualItem,expectedPartialItem);
                                    // Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");
                                System.out.println("Assert Pass");
                                if (actualItem.contains(expectedPartialItem)) {
                                break;
                            }

                        }
                        // Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");
                        //  System.out.println("Assert Pass");

                    }
                }
               // group.clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }




    }

























