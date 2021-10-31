package utilpackage;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class Util {
    public static String baseUrl = "https://api.m3o.com/v1/user";
    public static String bearerToken = token();
    public static JSONObject jsonObject;

    public static String token() {
        Properties prop = new Properties();
        try{
            FileInputStream fis;
            //select the OS and read the config file to choose browser
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties");
            } else {
                fis = new FileInputStream(System.getProperty("user.dir") + "/config/config.properties");
            }
            prop.load(fis);
        } catch (Exception e){
            System.out.println("Could not read property file");
        }
        return prop.getProperty("bearerToken");
    }


    public static String time() {
        String time = new SimpleDateFormat("hh:mm:ss", Locale.getDefault()).format(new Date());
        time = time.replaceAll(":", "");
        return time;
    }

    public static void readJson(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object object;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            fileName = System.getProperty("user.dir") + "\\testData\\" + fileName + ".json";
        } else {
            fileName = System.getProperty("user.dir") + "/testData/" + fileName + ".json";
        }
        object = parser.parse(new FileReader(fileName));
        //convert Object to JSONObject
        jsonObject = (JSONObject) object;
    }
}
