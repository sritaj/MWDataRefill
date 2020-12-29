package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    //Method to read key value from Properties file
    public static String readProperties(String key) throws IOException {

        FileReader reader= null;
        try {
            reader = new FileReader(Constant.propertiesFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties p=new Properties();
        p.load(reader);

        String value = p.getProperty(key);

        return value;

    }
}
