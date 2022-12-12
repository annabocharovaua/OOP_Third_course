package org.example.task6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NonBlockingQueueTest {
    @Test
    void testPush() {
        NonBlockingQueue<Integer> nonBlockingQueue = new NonBlockingQueue<Integer>();
        nonBlockingQueue.push(1);
        nonBlockingQueue.push(2);
        nonBlockingQueue.push(3);

        assertEquals(nonBlockingQueue.pop().intValue(), 1);
        assertEquals(nonBlockingQueue.pop().intValue(), 2);
        assertEquals(nonBlockingQueue.pop().intValue(), 3);
    }


}