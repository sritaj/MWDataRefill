package scripts;

import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class LibraryDataLoadForContract {

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
    void loadDataInContractors() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String contractorsURL = PropertiesFile.readProperties("contractorsURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+contractorsURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String contractorsExcelFile = PropertiesFile.readProperties("contractorsExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +contractorsExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

    }

    @Test
    @Order(2)
    void loadDataInContractType() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String contractTypeURL = PropertiesFile.readProperties("contractTypeURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+contractTypeURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String contractTypeExcelFile = PropertiesFile.readProperties("contractTypeExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +contractTypeExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

    }

    @Test
    @Order(3)
    void loadDataInContractorType() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String contractorTypeURL = PropertiesFile.readProperties("contractorTypeURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+contractorTypeURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String contractorTypeExcelFile = PropertiesFile.readProperties("contractorTypeExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +contractorTypeExcelFile;

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
