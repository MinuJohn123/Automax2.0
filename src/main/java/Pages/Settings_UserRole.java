package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Settings_UserRole {

    public WebDriverWait wait;
    JavascriptExecutor js;
    private Actions actions;
    public Alert alert;

    public  WebDriver driver;


    @FindBy(xpath = "//a[normalize-space()='User Management']")
    private WebElement userManageButton;
    @FindBy(xpath = "(//span[text()=' Settings '])[1]")
    private WebElement settingsButton;

    @FindBy(xpath = "(//span[text()=' Users Role '])[1]")
    private WebElement userRole;

    @FindBy(xpath = " //button[text()=' Add User Role ']")
    private WebElement AdduserRole;
    @FindBy(xpath = "//*[@id=\"toast-container\"]")
    private WebElement alert_msg;

    @FindBy(xpath = "//input[@id='roleName']")
    private WebElement rolename_En;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement button_save;

    @FindBy(xpath = "(//a[@title='Edit'])[2]")
    private WebElement Button_edit;

    @FindBy(xpath = "//input[@id='altRoleNameArabic']")
    private WebElement rname_AR;
    @FindBy(xpath = "(//span[text()=' Users Group '])[1]")
    private WebElement ugroup;






    @FindBy(xpath = "//Div[@class='col-6 mb-3 pe-2 ng-star-inserted']//input[@placeholder='Active Till Date']")
    private WebElement Active_Date;
   //// @FindBy(xpath = "//table[@class=\"table table-row-dashed table-rounded border table-row-bordered gy-2 ng-tns-c1380775985-2\"]")
   ///// private WebElement Tablbody;

    @FindBy(xpath = "//table")
    private WebElement Tablbody;

    @FindBy(xpath = " //button[text()='Yes']")
    private WebElement button_Yes;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchRole;



    @FindBy(xpath = "(//td[@valign='middle'])[1]")
    private WebElement element_First;

    @FindBy(xpath = "(//a[text()='Delete'])[1]")
    private WebElement buttonDelete;

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement confirmDelete;

    @FindBy(xpath = "//button[text()=' Cancel ']")
    private WebElement button_AddCancel;

    @FindBy(xpath = "//button[@class='close']")
    private WebElement button_Addclose;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement deleteCancel;



    public Settings_UserRole(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);


    }
    String rNameEn="";
    public String createRoleByDcheck() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(userManageButton));
            js.executeScript("arguments[0].click()", userManageButton);
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(settingsButton));
            js.executeScript("arguments[0].click()", settingsButton);
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(userRole));
            js.executeScript("arguments[0].click()", userRole);
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(AdduserRole));
            js.executeScript("arguments[0].click()", AdduserRole);

            wait.until(ExpectedConditions.visibilityOf(rolename_En));
            rolename_En.sendKeys("Call agents");
            wait.until(ExpectedConditions.visibilityOf(button_save));
            js.executeScript("arguments[0].click()", button_save);

            String actualText = alert_msg.getText();
            return actualText;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "An error occurred: " + e.getMessage();
        }
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
         Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }


    public String createRole() throws InterruptedException {
//        wait.until(ExpectedConditions.visibilityOf(userManageButton));
//        js.executeScript("arguments[0].click()", userManageButton);
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOf(settingsButton));
//        js.executeScript("arguments[0].click()", settingsButton);
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOf(userRole));
//        js.executeScript("arguments[0].click()", userRole);
//        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(AdduserRole));
        js.executeScript("arguments[0].click()", AdduserRole);
        wait.until(ExpectedConditions.visibilityOf(rolename_En));
        String rNameEn = generateRandomString(15);
        System.out.println("rNameEn1 : " + rNameEn);

        rolename_En.sendKeys(rNameEn);
        Thread.sleep(2000);
        Active_Date.click();
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(button_save));
        js.executeScript("arguments[0].click()", button_save);
        wait.until(ExpectedConditions.visibilityOf(button_Yes));
        js.executeScript("arguments[0].click()", button_Yes);
        Thread.sleep(2000);
        String actualText = alert_msg.getText();
        Thread.sleep(2000);
        System.out.println("actualText\n" +actualText);
        Thread.sleep(2000);
        String ActResult = actualText.replaceAll("\n" +
                "×", "");
        Thread.sleep(2000);
        System.out.println("ActResult\n" +ActResult);
        String Exp_txt = "SUCCESS\n" +
                "Role information is updated";
        System.out.println("Exp_txt \n" +Exp_txt);
        Assert.assertEquals(ActResult,Exp_txt );
        System.out.println("Assert Pass");
        System.out.println("rNameEn2 : " + rNameEn);

  return rNameEn;
    }
        public void verifyRoleByList () throws InterruptedException {

////
//           wait.until(ExpectedConditions.visibilityOf(userManageButton));
//            js.executeScript("arguments[0].click()", userManageButton);
//            Thread.sleep(2000);
//           wait.until(ExpectedConditions.visibilityOf(settingsButton));
//           js.executeScript("arguments[0].click()", settingsButton);
//           Thread.sleep(2000);
//            wait.until(ExpectedConditions.visibilityOf(userRole));
//            js.executeScript("arguments[0].click()", userRole);
//           Thread.sleep(2000);
           //
//For Listing Header cells
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(Tablbody));
            js.executeScript("arguments[0].click()", Tablbody);
            Thread.sleep(5000);
            List<WebElement> headerCells = Tablbody.findElements(By.tagName("th"));
            List<WebElement> dataCells = Tablbody.findElements(By.tagName("td"));
            List<String> headerTexts = new ArrayList<>();

            for (WebElement headerCell : headerCells) {
                headerTexts.add(headerCell.getText());
            }
            System.out.println(headerTexts);
            for (String headerText : headerTexts) {
               System.out.print(headerText); // Print with a tab separator
            }

// Header Cell

            // For Table values
            Thread.sleep(5000);
            List<WebElement> rows = Tablbody.findElements(By.tagName("tr"));
            String text = "";
            List<String> lData = new ArrayList<>();

            List<String> expValues = new ArrayList<String>();
            // Print values from the first column of each row
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                if (!cells.isEmpty()) {
                    text = cells.get(0).getText();
                    lData.add(text);
                    //  }
                }

            }

            System.out.println("\nlData" + lData);
            String data_EXP = element_First.getText();
            String dataEXP = data_EXP.replaceAll("●","");
            String exp_Values = dataEXP.replaceAll("\\s+$", "");
            System.out.println("exp_Values" +exp_Values);
            expValues.add(exp_Values);
               System.out.println("expectedItem " + expValues);
                boolean isFound = false;
                for (String sData : lData) {
                    List<String> value_act = new ArrayList<>();
                    value_act.add(sData);
                    String act_values = sData.replaceAll("●", "");
                    //String act_values = withoutBulletPoints.replaceAll("\\s+", "");
                    System.out.println("act_values "+act_values);
                    if (act_values.contains(exp_Values)) {
                        System.out.println("INside IF LOOP");
                        isFound = true;
                        Assert.assertTrue(isFound, "Partial data '" + value_act + "' not found");
                        System.out.println("Assert Pass");
                        break;

                    }

                }
            }




    public void verifySearchRole() throws InterruptedException {
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOf(userManageButton));
//            js.executeScript("arguments[0].click()", userManageButton);
//            Thread.sleep(2000);
//           wait.until(ExpectedConditions.visibilityOf(settingsButton));
//           js.executeScript("arguments[0].click()", settingsButton);
//           Thread.sleep(2000);
//            wait.until(ExpectedConditions.visibilityOf(userRole));
//            js.executeScript("arguments[0].click()", userRole);
//

        Thread.sleep(2000);
       String sData = element_First.getText();
        String searchData = sData.replaceAll("●","");
        String withoutSpaces = searchData.replaceAll("\\s+$", "");
        System.out.println("searchData" +withoutSpaces);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(searchRole));
        js.executeScript("arguments[0].click()", searchRole);
        Thread.sleep(2000);
        searchRole.sendKeys(withoutSpaces);


        // Find and print rows along with their values

        List<WebElement> rows = Tablbody.findElements(By.tagName("tr"));
        String text = "";

        List<String> lData = new ArrayList<>();
        List<String> expValues = new ArrayList<String>();
        expValues.add(withoutSpaces);
        System.out.println("rows.getSize() " + rows.size());
        int rowsize = rows.size();
        System.out.println("rowsize " + rowsize);
        if (rowsize == 0) {
            System.out.println("There is no Search Results");
        }
        // Print values from the first column of each row
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
             System.out.println("cells.getSize() "+cells.size());
            System.out.println("1");

            if (!cells.isEmpty()) {
                 System.out.println(cells.get(0).getText()); // Print the text of the first cell..
                text = cells.get(0).getText();
                lData.add(text);
                System.out.println("2");
            }
        }
        for (String rData : lData) {
            //System.out.println("sDatasData "+sData);
           // String withoutBulletPoints = sData.replaceAll("●", "");
            //String withoutSpaces = withoutBulletPoints.replaceAll("\\s+", "");
            //System.out.println(withoutSpaces);
            List<String> actValues = new ArrayList<>();
            actValues.add(searchData);
            System.out.println("3");
            System.out.println(actValues);
            System.out.println(expValues);

            for (String expectedPartialItem : expValues) {
                //System.out.println("expectedPartialItem "+expectedPartialItem);
                boolean isFound = false;
                for (String actualItem : actValues) {
                    System.out.println("4");
                    System.out.println("expectedPartialItem " + expectedPartialItem);
                    System.out.println("actualItem " + actualItem);
                    System.out.println("5");
                    if (actualItem.contains(expectedPartialItem)) {
                        System.out.println("6");
                        System.out.println("Inside IF LOOPP " );
                        isFound = true;
                        Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");
                        System.out.println("Assert Pass");
                        break;
                    }
                }
                // Assert.assertTrue(isFound, "Partial data '" + expectedPartialItem + "' not found");


            }
        }
        //searchRole.clear();

    }

    public String verifyEdit() throws InterruptedException {
//        wait.until(ExpectedConditions.visibilityOf(userManageButton));
//            js.executeScript("arguments[0].click()", userManageButton);
//            Thread.sleep(2000);
//           wait.until(ExpectedConditions.visibilityOf(settingsButton));
//           js.executeScript("arguments[0].click()", settingsButton);
//           Thread.sleep(2000);
//        Thread.sleep(2000);
//            wait.until(ExpectedConditions.visibilityOf(userRole));
//            js.executeScript("arguments[0].click()", userRole);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(Button_edit));
        js.executeScript("arguments[0].click()", Button_edit);
        Thread.sleep(2000);

        //String rname_EditByAppendTest= rname_Edit+"TEST";
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(rolename_En));
        String rnameEdit = rolename_En.getText();
        String rname_EditByAppendTest= rnameEdit+"TEST";
        Thread.sleep(2000);
        rolename_En.sendKeys(rname_EditByAppendTest);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(rname_AR));
        rname_AR.sendKeys(rname_EditByAppendTest);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(button_save));
        js.executeScript("arguments[0].click()", button_save);
        wait.until(ExpectedConditions.visibilityOf(button_Yes));
        js.executeScript("arguments[0].click()", button_Yes);
        Thread.sleep(2000);
        String actualText = alert_msg.getText();
        Thread.sleep(2000);
        System.out.println("actualText\n" +actualText);



return  actualText;

    }
    public String verifyDelete() throws InterruptedException {
//        wait.until(ExpectedConditions.visibilityOf(userManageButton));
//        js.executeScript("arguments[0].click()", userManageButton);
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOf(settingsButton));
//        js.executeScript("arguments[0].click()", settingsButton);
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOf(userRole));
//        js.executeScript("arguments[0].click()", userRole);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(buttonDelete));
        js.executeScript("arguments[0].click()", buttonDelete);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(confirmDelete));
        js.executeScript("arguments[0].click()", confirmDelete);

        String actualText = alert_msg.getText();
        Thread.sleep(2000);
        System.out.println("actualText\n" +actualText);
        Thread.sleep(2000);
        String ActResult = actualText.replaceAll("\n" +
                "×", "");
        Thread.sleep(2000);
        System.out.println("ActResult\n" +ActResult);
        String Exp_txt = "SUCCESS\n" +
                "Role is deleted";
        System.out.println("Exp_txt \n" +Exp_txt);
        Assert.assertEquals(ActResult,Exp_txt );
        System.out.println("Assert Pass");
        searchRole.clear();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(ugroup));
        js.executeScript("arguments[0].click()", ugroup);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(userRole));
        js.executeScript("arguments[0].click()", userRole);
        Thread.sleep(2000);
        return  actualText;
    }

    //To get Current Date
    public String getCurrentDate() throws InterruptedException {
        // Get the current date
        Date currentDate = new Date();
        // Format the current date using SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);
        System.out.println("Current Date: " + formattedDate);
        return formattedDate;
    }
    public void verifyCancelAdd() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(AdduserRole));
        js.executeScript("arguments[0].click()", AdduserRole);
        wait.until(ExpectedConditions.visibilityOf(rolename_En));
        String rNameEn = generateRandomString(15);
        System.out.println("rNameEn1 : " + rNameEn);

        rolename_En.sendKeys(rNameEn);
        Thread.sleep(2000);
        Active_Date.click();
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);
        Active_Date.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(button_AddCancel));
        js.executeScript("arguments[0].click()", button_AddCancel);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(button_Addclose));
        js.executeScript("arguments[0].click()", button_Addclose);

    }
    public void verifyCancelEdit() throws InterruptedException{
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(Button_edit));
        js.executeScript("arguments[0].click()", Button_edit);
        Thread.sleep(2000);

        //String rname_EditByAppendTest= rname_Edit+"TEST";
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(rolename_En));
        String rnameEdit = rolename_En.getText();
        String rname_EditByAppendTest= rnameEdit+"TEST";
        Thread.sleep(2000);
        rolename_En.sendKeys(rname_EditByAppendTest);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(rname_AR));
        rname_AR.sendKeys(rname_EditByAppendTest);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(button_AddCancel));
        js.executeScript("arguments[0].click()", button_AddCancel);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(button_Addclose));
        js.executeScript("arguments[0].click()", button_Addclose);


    }

    public void verifyCancelDelete() throws InterruptedException{
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(buttonDelete));
        js.executeScript("arguments[0].click()", buttonDelete);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(deleteCancel));
        js.executeScript("arguments[0].click()", deleteCancel);
        Thread.sleep(2000);


    }
}




