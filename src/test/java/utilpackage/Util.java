package utilpackage;

public class Util {
    public static long number;
    public static String baseURI = "https://m3o.com/user/api";
    public static String getRandomNumber(){
        number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        return String.format("%10d", number);
    }
}
