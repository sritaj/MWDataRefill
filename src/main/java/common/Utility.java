package common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utility {

    //Method to get the Date in specific format
    public static String getDateTime() {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        df.setTimeZone(TimeZone.getTimeZone("IST"));
        return df.format(new Date());
    }

}
