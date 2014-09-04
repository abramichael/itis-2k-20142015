import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExample {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d+");       
        Matcher m = p.matcher("123");
        while (m.matches()) {
            System.out.println("YEAH!");
        }
    }
}
