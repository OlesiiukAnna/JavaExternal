package ua.port.v2.data;

import java.util.LinkedList;
import java.util.Queue;

public class WaitingZone {

    private Queue<Ship> ships;
    private int shipCount;

    public WaitingZone() {
        this.shipCount = 0;
        this.ships = new LinkedList<>();
    }

    public synchronized void add(Ship ship) {
        while (shipCount >= 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ships.add(ship);
        shipCount++;
        notify();
    }

    public synchronized Ship get() {
        while (shipCount == 0) {
            try {
                wait(2000);
                if (shipCount == 0) {
                    return null;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        shipCount--;
        notify();
        return ships.remove();
    }
}
