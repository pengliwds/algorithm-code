import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {
        Pattern p = Pattern.compile("(cat)(s)");
        Matcher m = p.matcher("one cat two cats in the yard");
//        while (m.find()) {
//            m.appendReplacement(sb, "dog");
//        }
//        m.appendTail(sb);

        String result =  m.replaceAll("$1\u200B$2");
        System.out.println(result);
    }
}
