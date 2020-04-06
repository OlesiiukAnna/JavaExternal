package ua.port.v1.consumer;

import ua.port.v1.data.Ship;
import ua.port.v1.data.WaitingZone;

public class Dock implements Runnable {
    private WaitingZone waitingZone;

    public Dock(WaitingZone waitingZone) {
        this.waitingZone = waitingZone;
    }

    @Override
    public void run() {
        System.out.println("Dock is ready " + Thread.currentThread().getName());
        while (true) {
            try {
                Thread.sleep(500);
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
        }
    }
}
