package scripts;

import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class LibraryDataLoadForProgram {

    @BeforeEach
    void init() throws InterruptedException {
        MWCommon.loginMethod();
        MWCommon.waitForPageLoad();
    }

    @Test
    @Order(1)
    void loadDataInProgramCategory() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String programCatrgoryURL = PropertiesFile.readProperties("programCatrgoryURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+programCatrgoryURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String programCatrgoryExcelFile = PropertiesFile.readProperties("programCatrgoryExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +programCatrgoryExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

        String message = MWCommon.checkForConfirmationMsg();

        Assertions.assertEquals("Records Successfully Imported!!", message);

    }

    @AfterEach
    void tearDown(TestInfo testInfo) throws InterruptedException, IOException {
        MWCommon.waitForPageLoad();
        String testName = testInfo.getDisplayName();
        MWCommon.captureScreenshot(testName);
        MWCommon.quit();

    }
}
