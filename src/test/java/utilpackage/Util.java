package utilpackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {
    public static String baseUrl = "https://api.m3o.com/v1/user";
    public static String bearerToken = "Bearer ZmQ5YWRmZjItZjg4Yi00ZWNlLTg2OTctNjY5YmFmYTY1M2Ux";

    public static String test() {
        String time = new SimpleDateFormat("hh:mm:ss", Locale.getDefault()).format(new Date());
        time = time.replaceAll(":", "");
        return time;
    }
}
