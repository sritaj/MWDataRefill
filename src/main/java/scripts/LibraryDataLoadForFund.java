package scripts;


import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class LibraryDataLoadForFund {

    @BeforeAll
    static void setup(){

        MWCommon.loginMethod();

    }

    @BeforeEach
    void waitForPageLoad() throws InterruptedException {
        Thread.sleep(5000);
    }


    @Test
    @Disabled
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

    }

    @Test
    @Order(2)
    void loadDataInFundCategories() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String fundCategoriesURL = PropertiesFile.readProperties("fundCategoriesURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+fundCategoriesURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String fundCategoriesExcelFile = PropertiesFile.readProperties("fundCategoriesExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +fundCategoriesExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);


    }

    @Test
    @Disabled
    @Order(3)
    void loadDataInFundType() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String fundTypeURL = PropertiesFile.readProperties("fundTypeURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+fundTypeURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String fundTypeExcelFile = PropertiesFile.readProperties("fundTypeExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +fundTypeExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);


    }

    @AfterEach
    void waitAfterEachTest(TestInfo testInfo) throws InterruptedException, IOException {
        Thread.sleep(5000);
        String testName = testInfo.getDisplayName();
        MWCommon.captureScreenshot(testName);

    }

    /*
    @AfterAll
    static void terminate(){
        MWCommon.quit();
    }

     */

}
