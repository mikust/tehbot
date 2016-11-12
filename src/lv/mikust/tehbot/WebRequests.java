/**
 * Created by mikus on 2016.11.11.
 */
package lv.mikust.tehbot;

import java.net.HttpURLConnection;
import java.net.URL;

public class WebRequests extends TweetBot {


    public static String getGet(String url) throws Exception {  // getter
        String fullURI = "http://" + url;
        try {
            sendGet(fullURI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendGet(fullURI);
    }

    private static String sendGet(String url) throws Exception {
        String UA = "TweetBot/0.1";
        URL url1 = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", UA);
        String server = httpURLConnection.getHeaderField("Server");
        String response = " Server runs " + server;
        return response;

    }


}

