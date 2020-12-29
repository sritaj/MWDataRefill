package scripts;

import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class LibraryDataLoadForUsers {

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
    void loadDataInUserAccounts() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String userAccountsURL = PropertiesFile.readProperties("userAccountsURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+userAccountsURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String userAccountsExcelFile = PropertiesFile.readProperties("userAccountsExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +userAccountsExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

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
