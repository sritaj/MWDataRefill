package scripts;

import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class LibraryDataLoadForMisc {

    @BeforeEach
    void init() throws InterruptedException {
        MWCommon.loginMethod();
        MWCommon.waitForPageLoad();
    }

    @Test
    @Order(1)
    void loadDataInMaterials() throws InterruptedException, IOException {
        //Reading the key from config.properties file to get the form specific url
        String materialsURL = PropertiesFile.readProperties("materialsURL");
        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+materialsURL;
        //Reading the key from config.properties file to get the form specific Excel File to upload
        String materialsExcelFile = PropertiesFile.readProperties("materialsExcelFile");
        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +materialsExcelFile;
        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

        String message = MWCommon.checkForConfirmationMsg();

        Assertions.assertEquals("Records Successfully Imported!!", message);
    }
    @Test
    @Order(2)
    void loadDataInAdjustments() throws InterruptedException, IOException {
        //Reading the key from config.properties file to get the form specific url
        String adjustmentsURL = PropertiesFile.readProperties("adjustmentsURL");
        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+adjustmentsURL;
        //Reading the key from config.properties file to get the form specific Excel File to upload
        String adjustmentsExcelFile = PropertiesFile.readProperties("adjustmentsExcelFile");
        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +adjustmentsExcelFile;
        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

        String message = MWCommon.checkForConfirmationMsg();

        Assertions.assertEquals("Records Successfully Imported!!", message);
    }
    @Test
    @Order(3)
    void loadDataInMeasurementsSystem() throws InterruptedException, IOException {
        //Reading the key from config.properties file to get the form specific url
        String measurementsSystemURL = PropertiesFile.readProperties("measurementsSystemURL");
        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+measurementsSystemURL;
        //Reading the key from config.properties file to get the form specific Excel File to upload
        String measurementsSystemsExcelFile = PropertiesFile.readProperties("measurementsSystemsExcelFile");
        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +measurementsSystemsExcelFile;
        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

        String message = MWCommon.checkForConfirmationMsg();

        Assertions.assertEquals("Records Successfully Imported!!", message);
    }
    @Test
    @Order(4)
    void loadDataInStandardItems() throws InterruptedException, IOException {
        String stdTablesURL = PropertiesFile.readProperties("standardTablesURL");
        String completeURL = Constant.buildURL+stdTablesURL;
        //Method defined in MWCommon class to navigate to Standard Items and create a Table
        MWCommon.navigateToStandardTable(completeURL);
        MWCommon.waitForPageLoad();
        //Method defined in MWCommon class to select the newly created Table and navigate to Standard Items for Import
        MWCommon.navigateToStandardItems();
        MWCommon.waitForPageLoad();
        //Reading the key from config.properties file to get the form specific Excel File to upload
        String standardItemsExcelFile = PropertiesFile.readProperties("standardItemsExcelFile");
        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +standardItemsExcelFile;
        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUploadForStdItems(completeExcelFileURL);

        String message = MWCommon.checkForConfirmationMsg();

        Assertions.assertEquals("Successfully imported 953 records.", message);
    }

    @Test
    @Order(5)
    void loadDataInBudgetItems() throws InterruptedException, IOException {

        String budgetEstimateURL = PropertiesFile.readProperties("budgetEstimateURL");
        String completeURL = Constant.buildURL+budgetEstimateURL;
        //Method defined in MWCommon class to navigate to Standard Items and create a Table
        MWCommon.navigateToBudgetTemplate(completeURL);
        MWCommon.waitForPageLoad();
        //Method defined in MWCommon class to select the newly created Table and navigate to Standard Items for Import
        MWCommon.navigateToItems();
        MWCommon.waitForPageLoad();
        //Reading the key from config.properties file to get the form specific Excel File to upload
        String budgetEstimateItemsExcelFile = PropertiesFile.readProperties("budgetEstimateItemsExcelFile");
        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +budgetEstimateItemsExcelFile;
        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUploadForStdItems(completeExcelFileURL);

        String message = MWCommon.checkForConfirmationMsg();

        Assertions.assertEquals("Successfully imported 15 records.", message);
    }

    @AfterEach
    void tearDown(TestInfo testInfo) throws InterruptedException, IOException {
        MWCommon.waitForPageLoad();
        String testName = testInfo.getDisplayName();
        MWCommon.captureScreenshot(testName);
        MWCommon.quit();

    }


}
