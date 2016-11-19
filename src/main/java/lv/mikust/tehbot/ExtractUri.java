/**
 * Created by mikus on 2016.11.11.
 */

package lv.mikust.tehbot;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractUri {

    public String splitText(String fullText) {
        StringTokenizer stringTokenizer = new StringTokenizer(fullText, " ");
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (testURI(token) != null) {
                return token;
            }
        }
        return null;
    }

    // Returns domain name if matches regex
    public String testURI(String word) {
        Pattern pattern = Pattern.compile("^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$");
        Matcher matcher = pattern.matcher(word);
        if (matcher.matches()) {
            return "";
        }
        return null;
    }

}
