package org.example.task8;

public class ReentrantLock {
    private int lockCount;
    private boolean isLocked;
    private Thread lockedBy;

    public ReentrantLock() {
        this.lockCount = 0;
        this.isLocked = false;
        this.lockedBy = null;
    }

    public synchronized void lock() throws InterruptedException {
        while(isLocked && lockedBy !=Thread.currentThread()){
            wait();
        }

        isLocked = true;
        lockedBy = Thread.currentThread();
        lockCount++;
    }

    public synchronized void unlock() {
        if(lockedBy == Thread.currentThread()) {
            if(lockCount!=0) {
                lockCount--;
            } else {
                throw new IllegalArgumentException("Error");
            }
        }
        if(lockCount==0) {
            isLocked = false;
            notify();
        }
    }
}
