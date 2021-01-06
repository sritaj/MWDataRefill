package scripts;

import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class TemplateProjectCreation {

    @BeforeEach
    void init() throws InterruptedException {
        MWCommon.loginMethod();
        MWCommon.waitForPageLoad();
    }


    @Test
    @Order(1)
    void createTemplateProject() throws InterruptedException, IOException {

        String createProjectCompleteURL = Constant.buildURL + PropertiesFile.readProperties("newPlanningPageURL");

        MWCommon.createTemplateProject(createProjectCompleteURL, "SP1", "SP1", "Aurigo");


    }

/*
    @AfterEach
    void tearDown(TestInfo testInfo) throws InterruptedException, IOException {
        MWCommon.waitForPageLoad();
        String testName = testInfo.getDisplayName();
        MWCommon.captureScreenshot(testName);
        MWCommon.quit();

    }

 */
}
