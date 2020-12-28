package common;

public class Constant {

    // ******* Absolute Path Specific Settings ******* //
    //Defining the Project Abs path for appending with other directories/folders present in the Project
    public static String projectAbsPath = "/Users/sritaj/Downloads/LearnAtUdemy/";

    //Appending projectAbsPath and propertiesFilePath which is used in PropertiesFile class
    public static final String propertiesFilePath = projectAbsPath + "MWDataRefill/src/main/resources/config.properties";

    //Appending the projectAbsPath to create the Abs path for the excel File Locations
    public static final String excelSheetsFilePath = projectAbsPath + "MWDataRefill/src/main/resources/data-sheets/";

    //Appending projectAbsPath and browserPath
    public static final String browserDriver = projectAbsPath + "MWDataRefill/src/main/resources/browsers-dependency/chromedriver";

    // ******* Browser specific parameters ******* //
    public static final String chromeSetting = "webdriver.chrome.driver";

    // ******* Build Specific Settings ******* //
    //Build URL
    public static String buildURL = "https://accqa.aurigoessentials.com/#/";

    public static String username = "sritaj";

    public static String password = "Aurigo@123";

}
