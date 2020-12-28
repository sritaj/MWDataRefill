package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MWCommon {

    static WebDriver driver;
    public static void loginMethod(){


        System.setProperty(Constant.chromeSetting, Constant.browserDriver);
        driver = new ChromeDriver();
        driver.get(Constant.buildURL);
        driver.findElement(By.id("txtUserID")).sendKeys(Constant.username);
        driver.findElement(By.id("password")).sendKeys(Constant.password);
        driver.findElement(By.id("btnLogin")).click();
    }

    public static void excelSheetUpload(String formURL, String formExcelSheet) throws InterruptedException {

        driver.get(formURL);
        driver.switchTo().frame("contentFrame");
        driver.findElement(By.xpath("//input[@id='C1_FileUpload1']")).sendKeys(formExcelSheet);
        driver.findElement(By.xpath("//input[@id='C1_btnUpload']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='C1_btnSave1']")).click();
    }

    public static void quit(){
        driver.quit();
    }
}
