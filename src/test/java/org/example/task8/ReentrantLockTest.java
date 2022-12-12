package org.example.task8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicBoolean;
import static java.lang.Thread.sleep;

class ReentrantLockTest {

    @Test
    void testLockUnlock() throws InterruptedException {
        AtomicBoolean flag = new AtomicBoolean(true);
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        new Thread(() -> {
            try {
                lock.lock();
                flag.set(false);
                lock.unlock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        sleep(10);
        assertTrue(flag.get());
        lock.unlock();

    }

}