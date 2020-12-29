package scripts;

import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class LibraryDataLoadForExpenses {

    @BeforeAll
    static void setup(){

        MWCommon.loginMethod();

    }

    @BeforeEach
    void waitForPageLoad() throws InterruptedException {
        MWCommon.waitForPageLoad();
    }


    @Test
    @Order(1)
    void loadDataInExpense() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String expenseURL = PropertiesFile.readProperties("expenseURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+expenseURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String expenseExcelFile = PropertiesFile.readProperties("expenseExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +expenseExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

        String message = MWCommon.checkForConfirmationMsg();

        Assertions.assertEquals("Records Successfully Imported!!", message);

    }

    @Test
    @Order(2)
    void loadDataInPOType() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String purchaseOrderTypeURL = PropertiesFile.readProperties("purchaseOrderTypeURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+purchaseOrderTypeURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String purchaseOrderTypeExcelFile = PropertiesFile.readProperties("purchaseOrderTypeExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +purchaseOrderTypeExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

        String message = MWCommon.checkForConfirmationMsg();

        Assertions.assertEquals("Records Successfully Imported!!", message);

    }

    @AfterEach
    void waitAfterEachTest(TestInfo testInfo) throws InterruptedException, IOException {
        MWCommon.waitForPageLoad();
        String testName = testInfo.getDisplayName();
        MWCommon.captureScreenshot(testName);

    }

    @AfterAll
    static void terminate(){
        MWCommon.quit();
    }
}
