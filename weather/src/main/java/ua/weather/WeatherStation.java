package ua.weather;

import ua.weather.controller.CurrentWeatherController;
import ua.weather.data.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentWeatherController controller = new CurrentWeatherController(weatherData);
        controller.getCurrentWeather();
    }
}
