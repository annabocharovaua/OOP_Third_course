package org.example.task5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LockFreeSkipListTest {
    @Test
    void LockFreeSkipListInsertion() {
        LockFreeSkipList<Integer> skipList = new LockFreeSkipList<Integer>();
        assertTrue(skipList.add(10));
        assertTrue(skipList.contains(10));
        assertFalse(skipList.contains(9));
    }

    @Test
    void LockFreeSkipListRemoval() {
        LockFreeSkipList<Integer> skipList = new LockFreeSkipList<Integer>();
        assertTrue(skipList.add(50));
        assertTrue(skipList.contains(50));
        assertTrue(skipList.remove(50));
        assertFalse(skipList.contains(50));
    }

    @Test
    void LockFreeSkipListRemoveNonExistent() {
        LockFreeSkipList<Integer> skipList = new LockFreeSkipList<Integer>();
        assertFalse(skipList.remove(50));
    }
}