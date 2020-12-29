package scripts;

import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class LibraryDataLoadForProject {

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
    void loadDataInProjectPhase() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String projectPhaseURL = PropertiesFile.readProperties("projectPhaseURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+projectPhaseURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String projectPhaseExcelFile = PropertiesFile.readProperties("projectPhaseExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +projectPhaseExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

    }

    @Test
    @Order(2)
    void loadDataInScoringDept() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String scoringDeptURL = PropertiesFile.readProperties("scoringDeptURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+scoringDeptURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String scoringDeptExcelFile = PropertiesFile.readProperties("scoringDeptExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +scoringDeptExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

    }

    @Test
    @Order(3)
    void loadDataInScoringCategory() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String scoringCategoryURL = PropertiesFile.readProperties("scoringCategoryURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+scoringCategoryURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String scoringCategoryExcelFile = PropertiesFile.readProperties("scoringCategoryExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +scoringCategoryExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

    }

    @Test
    @Order(4)
    void loadDataInScoringCriteria() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String scoringCriteriaURL = PropertiesFile.readProperties("scoringCriteriaURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+scoringCriteriaURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String scoringCriteriaExcelFile = PropertiesFile.readProperties("scoringCriteriaExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +scoringCriteriaExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

    }


    @AfterEach
    void waitAfterEachTest(TestInfo testInfo) throws InterruptedException, IOException {
        Thread.sleep(5000);
        String testName = testInfo.getDisplayName();
        MWCommon.captureScreenshot(testName);

    }

    @AfterAll
    static void terminate(){
        MWCommon.quit();
    }
}
