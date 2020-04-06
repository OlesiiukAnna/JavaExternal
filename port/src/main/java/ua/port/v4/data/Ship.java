package ua.port.v4.data;

public class Ship {

    private int containersNow;
    private Capacity capacity;

    public Ship(int containersNow, Capacity capacity) {
        this.containersNow = containersNow;
        this.capacity = capacity;
    }

    public void addContainers(int count) {
        this.containersNow += count;
    }

    public void removeContainers(int count) {
        this.containersNow -= count;
    }

    public boolean isFull() {
        return containersNow < capacity.getContainers();
    }

    public boolean isEmpty() {
        return containersNow == 0;
    }

    public int getContainersNow() {
        return containersNow;
    }
}
