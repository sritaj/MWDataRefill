package scripts;

import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class LibraryDataLoadForExpenses {

    @BeforeEach
    void init() throws InterruptedException {
        MWCommon.loginMethod();
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

        if(message.contains("Imported successfully!")){
            Assertions.assertTrue(true);
        }else{
            Assertions.assertTrue(false);
        }

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

        if(message.contains("Imported successfully!")){
            Assertions.assertTrue(true);
        }else{
            Assertions.assertTrue(false);
        }

    }

    @AfterEach
    void tearDown(TestInfo testInfo) throws InterruptedException, IOException {
        MWCommon.waitForPageLoad();
        String testName = testInfo.getDisplayName();
        MWCommon.captureScreenshot(testName);
        MWCommon.quit();

    }
}
