package scripts;


import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class LibraryDataLoad {


    @BeforeAll
    static void setup(){

        MWCommon.loginMethod();

    }

    @BeforeEach
    void waitForPageLoad() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test
    @Order(1)
    void loadDataInFundAgency() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String fundAgencyURL = PropertiesFile.readProperties("fundAgencyURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+fundAgencyURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String fundAgencyExcelFile = PropertiesFile.readProperties("fundAgencyExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +fundAgencyExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

        /*
        driver.get("https://accqa.aurigoessentials.com/#/Common/Import.aspx?xContext=FUNDAGN&Module=LIBRARY&PID=0&ParentID=0&BackURL=%2fCommon%2fBrixListPage.aspx%3fxContext%3dFUNDAGN%26Module%3dLIBRARY%26PID%3d0%26ParentID%3d0&BreadCrumbKeys=cABpAGQAPQAwACYAcABhAHIAZQBuAHQASQBkAD0AMAAmAHgAYwBvAG4AdABlAHgAdAA9AEYAVQBOAEQAQQBHAE4A");
        driver.switchTo().frame("contentFrame");
        driver.findElement(By.xpath("//input[@id='C1_FileUpload1']")).sendKeys("/Users/sritaj/Downloads/LearnAtUdemy/SeleniumPOC/src/main/resources/data-sheets/Fund Agency_Template.xlsx");
        driver.findElement(By.xpath("//input[@id='C1_btnUpload']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='C1_btnSave1']")).click();

         */

    }

    /*
    @Test
    @Order(2)
    void loadDataInFundCategories() throws InterruptedException {

        driver.get("https://accqa.aurigoessentials.com/#/Common/Import.aspx?xContext=FUNDAGN&Module=LIBRARY&PID=0&ParentID=0&BackURL=%2fCommon%2fBrixListPage.aspx%3fxContext%3dFUNDAGN%26Module%3dLIBRARY%26PID%3d0%26ParentID%3d0&BreadCrumbKeys=cABpAGQAPQAwACYAcABhAHIAZQBuAHQASQBkAD0AMAAmAHgAYwBvAG4AdABlAHgAdAA9AEYAVQBOAEQAQQBHAE4A");
        driver.switchTo().frame("contentFrame");
        driver.findElement(By.xpath("//input[@id='C1_FileUpload1']")).sendKeys("/Users/sritaj/Downloads/AZ_104_Project.docx");
        driver.findElement(By.xpath("//input[@id='C1_btnUpload']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='C1_btnSave1']")).click();

    }

    @Test
    @Order(3)
    void loadDataInFundType() throws InterruptedException {

        driver.get("https://accqa.aurigoessentials.com/#/Common/Import.aspx?xContext=FUNDAGN&Module=LIBRARY&PID=0&ParentID=0&BackURL=%2fCommon%2fBrixListPage.aspx%3fxContext%3dFUNDAGN%26Module%3dLIBRARY%26PID%3d0%26ParentID%3d0&BreadCrumbKeys=cABpAGQAPQAwACYAcABhAHIAZQBuAHQASQBkAD0AMAAmAHgAYwBvAG4AdABlAHgAdAA9AEYAVQBOAEQAQQBHAE4A");
        driver.switchTo().frame("contentFrame");
        driver.findElement(By.xpath("//input[@id='C1_FileUpload1']")).sendKeys("/Users/sritaj/Downloads/AZ_104_Project.docx");
        driver.findElement(By.xpath("//input[@id='C1_btnUpload']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='C1_btnSave1']")).click();

    }

     */

    @AfterAll
    static void terminate(){
       // driver.quit();
    }

}
