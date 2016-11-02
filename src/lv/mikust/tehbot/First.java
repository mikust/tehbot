/**
 * Created by mikus on 02/11/2016.
 */

package lv.mikust.tehbot;
import twitter4j.*;

public class First {
    public static void main(String args[]) throws Exception {

        String latestStatus = "testing 321";
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(latestStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
}