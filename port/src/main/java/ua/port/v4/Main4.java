package ua.port.v4;

import ua.port.v4.consumer.Dock;
import ua.port.v4.data.WaitingZone;
import ua.port.v4.producer.ShipGenerator;

public class Main4 {
    public static void main(String[] args) {
        int shipsToGenerate = 6;
        WaitingZone waitingZone = new WaitingZone();

        Thread shipGenerator = new Thread(new ShipGenerator(waitingZone, shipsToGenerate));
        shipGenerator.start();

        Thread dock1 = new Thread(new Dock(waitingZone));
        Thread dock2 = new Thread(new Dock(waitingZone));
        Thread dock3 = new Thread(new Dock(waitingZone));

        dock1.start();
        dock2.start();
        dock3.start();
    }
}
