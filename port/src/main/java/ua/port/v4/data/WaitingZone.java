package ua.port.v4.data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaitingZone {

    private Queue<Ship> ships;
    private int shipCount;
    ReentrantLock locker;
    Condition condition;

    public WaitingZone() {
        this.shipCount = 0;
        this.ships = new LinkedList<>();
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public synchronized void add(Ship ship) {
        locker.lock();
        try {
            while (shipCount >= 1) {
                condition.await();
            }
            ships.add(ship);
            shipCount++;
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public synchronized Ship get() {
        locker.lock();
        try {
            while (shipCount == 0) {
                condition.await(2, TimeUnit.SECONDS);
                if (shipCount == 0) {
                    return null;
                }
            }
            shipCount--;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
        return ships.remove();
    }
}

