package ua.port.v2.data;

public enum Capacity {

    SMALL(600),
    MEDIUM(800),
    LARGE(1000);

    int containers;

    Capacity(int containers) {
        this.containers = containers;
    }

    public int getContainers() {
        return containers;
    }
}
