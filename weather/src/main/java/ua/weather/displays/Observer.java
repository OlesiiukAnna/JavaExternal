package ua.weather.displays;

public interface Observer {
    void update(double temp, long humidity, long pressure);
}
