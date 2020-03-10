package ua.weather.displays;

import ua.weather.data.Subject;
import ua.weather.util.ResourceManager;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private ResourceManager resManager = ResourceManager.INSTANCE;

    private double temperature;
    private long humidity;
    private long pressure;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double temp, long humidity, long pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.printf(resManager.getString("display"), temperature, humidity, pressure);
    }

    @Override
    public void getGreeting(){
        System.out.println(resManager.getString("greeting"));
    }

    @Override
    public void cityNotFound(){
        System.out.println(resManager.getString("cityNotFound"));
    }
}
