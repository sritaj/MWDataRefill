package scripts;

import common.Constant;
import common.MWCommon;
import common.PropertiesFile;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebElement;

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

        Boolean output = MWCommon.createTemplateProject(createProjectCompleteURL, "TemplateProject", "TemplateProject", "Aurigo");

        if(output = true){
            Assertions.assertTrue(true);
        }else{
            Assertions.assertTrue(false);
        }

    }

    @AfterEach
    void tearDown(TestInfo testInfo, ExtensionContext extensionContext) throws InterruptedException, IOException {

        MWCommon.waitForPageLoad();
        String testName = testInfo.getDisplayName();
        MWCommon.captureScreenshot(testName);
        MWCommon.quit();

    }

}
