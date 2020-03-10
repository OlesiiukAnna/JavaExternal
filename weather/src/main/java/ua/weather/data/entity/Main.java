package ua.weather.data.entity;

public class Main {

    private double temp;
    private long pressure;
    private long humidity;

    public Main() {
    }

    public Main(double temp, long pressure, long humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp + " °С" +
                ", pressure=" + pressure + " hpa" +
                ", humidity=" + humidity + " %"+
                '}';
    }
}
