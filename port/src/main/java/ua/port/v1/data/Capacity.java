package ua.port.v1.data;

public enum Capacity {

    SMALL(500),
    MEDIUM(700),
    LARGE(900);

    private int containers;

    Capacity(int containers) {
        this.containers = containers;
    }

    public int getContainers() {
        return containers;
    }
}
