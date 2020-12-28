package scripts;

import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class LibraryDataLoadForBudget {

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
    void loadDataInBudgetEstimateType() throws InterruptedException, IOException {

        //Reading the key from config.properties file to get the form specific url
        String budgetEstimateTypeURL = PropertiesFile.readProperties("budgetEstimateTypeURL");

        //appending the build/env specific URL with the form URL
        String completeFormURL = Constant.buildURL+budgetEstimateTypeURL;

        //Reading the key from config.properties file to get the form specific Excel File to upload
        String budgetEstimateTypeExcelFile = PropertiesFile.readProperties("budgetEstimateTypeExcelFile");

        //appending the excel file name at the end of the excel file absolute paths
        String completeExcelFileURL =  Constant.excelSheetsFilePath +budgetEstimateTypeExcelFile;

        //common method defined in the MWCommon class to redirect to particular form Upload page and perform operations
        MWCommon.excelSheetUpload(completeFormURL, completeExcelFileURL);

    }



    @AfterEach
    void waitAfterEachTest() throws InterruptedException {
        Thread.sleep(5000);

    }

    @AfterAll
    static void terminate(){
        MWCommon.quit();
    }
}
