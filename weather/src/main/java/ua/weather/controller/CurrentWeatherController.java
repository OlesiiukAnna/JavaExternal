package ua.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.weather.data.WeatherData;
import ua.weather.data.entity.Current;
import ua.weather.displays.CurrentConditionsDisplay;
import ua.weather.exceptions.URLParserException;
import ua.weather.util.JsonParser;
import ua.weather.util.URLParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CurrentWeatherController {
    private static final Logger logger = LoggerFactory.getLogger(URLParser.class);

    private final static String BASIC_URL =
            "http://api.openweathermap.org/data/2.5/weather?q=CITY&units=metric&units=metricY&appid=KEY";
    private final static String API_KEY = "c1038271de3d977ae1c0830a3028e632";

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private WeatherData weatherData;
    private Current currentWeather;
    private CurrentConditionsDisplay display;

    public CurrentWeatherController(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.display = new CurrentConditionsDisplay(weatherData);
    }

    public void getCurrentWeather() {

        display.getGreeting();
        String city = getCityFromUser();
        String url = getUrl(city);
        String json = null;
        try {
            json = URLParser.getContent(url);
            currentWeather = JsonParser.parseFromJsonToCurrent(json);
            double currentTemp = currentWeather.getMain().getTemp();
            long currentHumidity = currentWeather.getMain().getHumidity();
            long currentPressure = currentWeather.getMain().getPressure();
            weatherData.setMeasurements(currentTemp, currentHumidity, currentPressure);
        } catch (URLParserException e) {
            logger.warn("Wrong city", e);
            display.cityNotFound();
            getCurrentWeather();
        }
    }

    private String getCityFromUser() {
        String incomeValue = null;
        try {
            incomeValue = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return incomeValue;
    }

    private String getUrl(String city) {
        return BASIC_URL.replace("CITY", city).replace("KEY", API_KEY);
    }
}
