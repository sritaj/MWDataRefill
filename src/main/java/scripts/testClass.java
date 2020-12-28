package scripts;

import common.MWCommon;

import java.io.IOException;

public class testClass {

    public static void main(String[] args) throws IOException, InterruptedException {

        MWCommon.loginMethod();
        MWCommon.navigateToBudgetTemplate("https://accqa.aurigoessentials.com/Default.aspx#/Common/BrixListPage.aspx?xcontext=BDGTEMP&module=LIBRARY&PID=0&parentid=0");
        MWCommon.navigateToItems();
    }
}
