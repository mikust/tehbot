/**
 * Created by mikus on 2016.11.19.
 */

package lv.mikust.tehbot;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import com.google.gson.*;

public class GetOpenWeather {

    private String city;

    public String slurpData() throws IOException {
        String URL = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=c08ab94a307b060f1f1e91fb8d30e3e5&units=metric";
        URL url = new URL(URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        Gson gson = new Gson();
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream) request.getContent());
        OpenWeatherData openWeatherData = gson.fromJson(inputStreamReader, OpenWeatherData.class);
        String WindArrow = getWindDirecton(openWeatherData.getWind().getDeg());
        String result = "\nCity: " + openWeatherData.getName()
                + "\nWeather: " + openWeatherData.getWeather().get(0).getDescription()
                + "\nTemperature: " + openWeatherData.getMain().getTemp()
                + "\nWind speed: " + openWeatherData.getWind().getSpeed() + WindArrow
                + "\nSunrise: " + getSun(openWeatherData.getSys().getSunrise())
                + "\nSunset: " + getSun(openWeatherData.getSys().getSunset());
        return result;
    }

    public String getWindDirecton(Double winDegrees) {
        WindDirection windDirection = new WindDirection();
        HashMap<Integer, String> hashMap = windDirection.getHashmap();
        // https://www.campbellsci.com/blog/convert-wind-directions
        Long windDir = Math.round((winDegrees % 360 / 45) % 8);
        // stupid workaround, but its 1AM :)
        int stupid = windDir.intValue();
        return hashMap.get(stupid);
    }

    public String getSun(long unixTime) {
        Date date = new Date(unixTime * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("EET"));
        String formattedDate = simpleDateFormat.format(date);
        return formattedDate;
    }

    public void setCity(String myCity) {
        city = myCity;
    }
}

