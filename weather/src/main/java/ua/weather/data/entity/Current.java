package ua.weather.data.entity;

public class Current {

    private Main main;
    private long cod;

    public Current() {
    }

    public Current(long cod) {
        this.cod = cod;
    }

    public Current(Main main, long cod) {
        this.main = main;
        this.cod = cod;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Current{" +
                "main=" + main +
                ", cod=" + cod +
                '}';
    }
}
