package common;

public class Constant {

    //Defining the path for PropertiesFile class
    public static final String propertiesFilePath = System.getProperty("user.dir") + "//src/main/resources/config.properties";

    //Defining the path for for the excel File Locations
    public static final String excelSheetsFilePath = System.getProperty("user.dir") + "//src/main/resources/data-sheets/";

    //Defining the path for browserPath
    public static final String browserDriver = System.getProperty("user.dir") + "//src/main/resources/browsers-dependency/windows_drivers/chromedriver_v87/chromedriver.exe";

    // ******* Browser specific parameters ******* //
    public static final String chromeSetting = "webdriver.chrome.driver";

    // ******* Build Specific Settings ******* //
    //Build URL
    public static String buildURL = "https://accqa.aurigoessentials.com/#/";

    public static String username = "Administrator";

    public static String password = "Mstwkadm1n@2019";

}
