package ua.port.v3.producer;

import ua.port.v3.data.Capacity;
import ua.port.v3.data.Ship;
import ua.port.v3.data.WaitingZone;

import java.util.Random;

public class ShipGenerator implements Runnable {

    private final Random random = new Random();
    private WaitingZone waitingZone;
    private int shipsToGenerate;

    public ShipGenerator(WaitingZone waitingZone, int shipsToGenerate) {
        this.waitingZone = waitingZone;
        this.shipsToGenerate = shipsToGenerate;
    }

    @Override
    public void run() {
        for (int i = 1; i <= shipsToGenerate; i++) {
            System.out.println("Ship generation in process");
            waitingZone.add(generateShip());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Ship generateShip() {
        Capacity capacity = getRandomCapacity();
        int initLoad = 0;
        if (random.nextInt(10) <= 5) {
            initLoad = capacity.getContainers();
        }
        return new Ship(initLoad, capacity);
    }

    private Capacity getRandomCapacity() {
        int x = random.nextInt(Capacity.values().length);
        return Capacity.values()[x];
    }
}
