package ua.port.v3;

import ua.port.v3.consumer.Dock;
import ua.port.v3.data.WaitingZone;
import ua.port.v3.producer.ShipGenerator;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main3 {

    public static void main(String[] args) {
        int shipsToGenerate = 6;
        WaitingZone waitingZone = new WaitingZone();

        ExecutorService service = Executors.newFixedThreadPool(Runtime
                .getRuntime()
                .availableProcessors());

        List<Thread> threads = List.of(
                new Thread(new ShipGenerator(waitingZone, shipsToGenerate)),
                new Thread(new Dock(waitingZone)),
                new Thread(new Dock(waitingZone)),
                new Thread(new Dock(waitingZone)));

        threads.forEach(service::execute);

        service.shutdown();
    }

}
