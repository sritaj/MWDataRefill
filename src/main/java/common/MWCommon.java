package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

public class MWCommon {

    static WebDriver driver;

    //Method to initialise the WebDriver and to Login to the application
    public static void loginMethod(){

        System.setProperty(Constant.chromeSetting, Constant.browserDriver);
        driver = new ChromeDriver();
        driver.get(Constant.buildURL);
        driver.findElement(By.id("txtUserID")).sendKeys(Constant.username);
        driver.findElement(By.id("password")).sendKeys(Constant.password);
        driver.findElement(By.id("btnLogin")).click();
    }

    //Method to upload the excel sheet by passing the relevant form url and excel sheet path
    public static void excelSheetUpload(String formURL, String formExcelSheet) throws InterruptedException {

        driver.get(formURL);
        driver.switchTo().frame("contentFrame");
        driver.findElement(By.xpath("//input[@id='C1_FileUpload1']")).sendKeys(formExcelSheet);
        driver.findElement(By.xpath("//input[@id='C1_btnUpload']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='C1_btnSave1']")).click();
    }

    //Method to quit the browser
    public static void quit(){
        driver.quit();
    }

    //Method to navigate to standard item table and creation of relevant data
    public static void navigateToStandardTable(String formURL) throws InterruptedException {
        driver.get(formURL);
        driver.switchTo().frame("contentFrame");
        driver.findElement(By.xpath("//body/form[@id='form1']/div[@id='centerContent']/div[@id='toolBarAndTabContent']/div[@id='MainToolBar_upToolbar']/div[@id='ctl00_MainToolBar_RadRibbonBarControl']/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/img[1]")).click();
        driver.findElement(By.xpath("//input[@id='C1_txtStandardTable']")).sendKeys("Standard Items");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//body/form[@id='form1']/div[@id='centerContent']/div[@id='toolBarAndTabContent']/div[@id='MainToolBar_upToolbar']/div[@id='ctl00_MainToolBar_RadRibbonBarControl']/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/img[1]")).click();
    }

    //Method to navigate to standard items after executing the navigateToStandardTable method
    public static void navigateToStandardItems() throws InterruptedException {
        driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[5]/div[3]/span[2]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Standard Items')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Excel Import / Export')]")).click();
        driver.findElement(By.xpath("//body/form[@id='form1']/div[@id='centerContent']/div[@id='toolBarAndTabContent']/div[@id='MainToolBar_upToolbar']/div[@id='ctl00_MainToolBar_RadRibbonBarControl']/div[4]/ul[1]/li[1]/a[1]/span[2]")).click();
    }

    //Method to upload the excel sheet for std items by passing the excel sheet path
    public static void excelSheetUploadForStdItems(String formExcelSheet) throws InterruptedException {


        driver.findElement(By.xpath("//input[@id='C1_FileUpload1']")).sendKeys(formExcelSheet);
        driver.findElement(By.xpath("//input[@id='C1_btnUpload']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='C1_btnSave1']")).click();
    }

    //Method to navigate to Budget Template page and creation of relevant data
    public static void navigateToBudgetTemplate(String formURL) throws InterruptedException {
        //driver.get(formURL);
        driver.get(formURL);
        //driver.get(formURL);
        driver.switchTo().frame("contentFrame");
        driver.findElement(By.xpath("//body/form[@id='form1']/div[@id='centerContent']/div[@id='toolBarAndTabContent']/div[@id='MainToolBar_upToolbar']/div[@id='ctl00_MainToolBar_RadRibbonBarControl']/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/img[1]")).click();
        driver.findElement(By.xpath("//input[@id='BDGTEMP_BudgetTemplateName_Id']")).sendKeys("Engineers Estimate");
        driver.findElement(By.xpath("//textarea[@id='BDGTEMP_Description_Id']")).sendKeys("Engineers Estimate");

        Select drp = new Select(driver.findElement(By.xpath("//select[@id='BDGTEMP_MSystem_Id']")));
        drp.selectByValue("1");

        Thread.sleep(5000);

        driver.findElement(By.xpath("//body/form[@id='form1']/div[@id='centerContent']/div[@id='toolBarAndTabContent']/div[@id='MainToolBar_upToolbar']/div[@id='ctl00_MainToolBar_RadRibbonBarControl']/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/img[1]")).click();

    }

    //Method to navigate to budget items after executing the navigateToBudgetTemplate method
    public static void navigateToItems() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='ctl00_C1_MWGrid_ctl00_ctl04_MultiSelectCheckBox']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@id='lnkstandarditem']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Excel Import / Export')]")).click();
        driver.findElement(By.xpath("//body/form[@id='form1']/div[@id='centerContent']/div[@id='toolBarAndTabContent']/div[@id='MainToolBar_upToolbar']/div[@id='ctl00_MainToolBar_RadRibbonBarControl']/div[4]/ul[1]/li[1]/a[1]/span[2]")).click();
    }

    //Method to capture the screenshot
    public static void captureScreenshot(String testName) throws IOException {

        String dest = null;

        try {
            File scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            dest = System.getProperty("user.dir")+"//src/main/resources/screenshots/"+testName+Utility.getDateTime()+".png";
            File target = new File(dest);
            FileUtils.copyFile(scrShot, target);

        }catch (Exception e) {

            System.out.println("Exception while taking screenshot " + e.getMessage());
        }

    }

}
