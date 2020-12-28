package scripts;

import common.MWCommon;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class LibraryDataLoadForExpenses {

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
