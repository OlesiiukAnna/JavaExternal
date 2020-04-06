package ua.port.v2;

import ua.port.v2.consumer.Dock;
import ua.port.v2.producer.ShipGenerator;
import ua.port.v2.data.WaitingZone;

import java.util.concurrent.Semaphore;

public class Main2 {
    private static final Semaphore SEMAPHORE = new Semaphore(3);

    public static void main(String[] args) {
        WaitingZone waitingZone = new WaitingZone();

        int shipsToGenerate = 6;
        Thread shipGenerator = new Thread(new ShipGenerator(waitingZone, shipsToGenerate));
        shipGenerator.start();

        Thread dock1 = new Thread(new Dock(waitingZone, SEMAPHORE));
        Thread dock2 = new Thread(new Dock(waitingZone, SEMAPHORE));
        Thread dock3 = new Thread(new Dock(waitingZone, SEMAPHORE));

        dock1.start();
        dock2.start();
        dock3.start();
    }
}
