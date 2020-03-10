package ua.weather.util;

import com.google.gson.Gson;
import ua.weather.data.entity.Current;

public class JsonParser {
    public static Current parseFromJsonToCurrent(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Current.class);
    }
}
