package ua.port.v2.consumer;

import ua.port.v2.data.Ship;
import ua.port.v2.data.WaitingZone;

import java.util.concurrent.Semaphore;

public class Dock implements Runnable {
    private WaitingZone waitingZone;
    private Semaphore semaphore;

    public Dock(WaitingZone waitingZone, Semaphore semaphore) {
        this.waitingZone = waitingZone;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Dock is ready " + Thread.currentThread().getName());
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " ожидает разрешение");
                semaphore.acquire();
                Ship ship = waitingZone.get();
                if (ship != null) {
                    System.out.println("Ship is arrived ");
                    if (ship.getContainersNow() == 0) {
                        while (ship.isFull()) {
                            Thread.sleep(100);
                            ship.addContainers(100);
                            System.out.println(ship.getContainersNow() + " Loading ship... "
                                    + Thread.currentThread().getName());
                        }
                    } else {
                        while (!ship.isEmpty()) {
                            Thread.sleep(100);
                            ship.removeContainers(100);
                            System.out.println(ship.getContainersNow() + " Unloading ship... "
                                    + Thread.currentThread().getName());
                        }
                    }
                } else {
                    System.out.println("No ships to take any more "
                            + Thread.currentThread().getName());
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " освобождает разрешение");
            semaphore.release();
        }
    }
}
