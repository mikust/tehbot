/**
 * Created by mikus on 2016.11.20.
 */

package lv.mikust.tehbot;

import java.util.HashMap;

public class WindDirection {
    public static final HashMap<Integer, String> hashMap;

    static {
        hashMap = new HashMap<Integer, String>();
        hashMap.put(0, "\u21D1");
        hashMap.put(1, "\u21D7");
        hashMap.put(2, "\u21D2");
        hashMap.put(3, "\u21D8");
        hashMap.put(4, "\u21D3");
        hashMap.put(5, "\u21D9");
        hashMap.put(6, "\u21D0");
        hashMap.put(7, "\u21D6");
    }

    public HashMap<Integer, String> getHashmap() {
        return hashMap;
    }
}
