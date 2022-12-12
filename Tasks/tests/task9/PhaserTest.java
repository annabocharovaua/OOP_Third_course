package org.example.task9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicBoolean;
import static java.lang.Thread.sleep;

class PhaserTest {

    @Test
    void testArriveAndAwaitAdvance() throws InterruptedException {
        AtomicBoolean flag = new AtomicBoolean(false);
        Phaser phaser = new Phaser();
        phaser.register();
        phaser.register();

        Runnable runnable = () -> {
            try {
                phaser.arriveAndAwaitAdvance();
                flag.set(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        new Thread(runnable).start();
        sleep(10);
        assertFalse(flag.get());

        new Thread(runnable).start();
        sleep(10);
        assertTrue(flag.get());
    }

    @Test
    void testArriveAndDeregister() throws InterruptedException {
        AtomicBoolean flag = new AtomicBoolean(false);
        Phaser phaser = new Phaser();
        phaser.register();
        phaser.register();

        Runnable runnable = () -> {
            try {
                phaser.arriveAndDeregister();
                flag.set(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        new Thread(runnable).start();
        sleep(10);
        assertTrue(flag.get());

        new Thread(runnable).start();
        sleep(10);
        assertTrue(flag.get());
    }

}