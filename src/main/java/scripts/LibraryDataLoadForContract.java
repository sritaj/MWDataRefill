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
        Thread.sleep(5000);
    }


    @AfterEach
    void waitAfterEachTest() throws InterruptedException {
        Thread.sleep(1000);

    }

    @AfterAll
    static void terminate(){
        MWCommon.quit();
    }
}
