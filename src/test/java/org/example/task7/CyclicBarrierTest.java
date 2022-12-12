package org.example.task7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicBoolean;
import static java.lang.Thread.sleep;

class CyclicBarrierTest {
    @Test
    void testCyclicBarrier() {
        CyclicBarrier barrier = new CyclicBarrier(2);
        AtomicBoolean flag = new AtomicBoolean(false);
        Runnable runnable = () -> {
            try {
                barrier.await();
                flag.set(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        try{
            new Thread(runnable).start();
            sleep(100);
            assertFalse(flag.get());
            new Thread(runnable).start();
            sleep(100);
            assertTrue(flag.get());
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}