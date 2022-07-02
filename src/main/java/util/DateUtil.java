package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil{
    public static String timestampToDate(String timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date(Long.parseLong(timestamp)));
        return format;
    }

    public static String currentTimestamp() {
        return new Date().getTime() + "";
    }
}
