package org.example.task9;

public class Phaser {
    private int phase;
    private int parties;
    private int partiesToAwait;

    public Phaser() {
        this.phase = 0;
        this.parties = 0;
        this.partiesToAwait = 0;
    }

    public Phaser(int parties) {
        this.parties = parties;
    }

    public synchronized int register() {
        parties++;
        partiesToAwait++;
        return phase;
    }

    public synchronized void arriveAndAwaitAdvance() throws InterruptedException {
        partiesToAwait--;

        if(partiesToAwait > 0) {
            wait();
        }
        notifyAll();;
        partiesToAwait = parties;
        phase++;
    }

    public synchronized void arriveAndDeregister() throws InterruptedException{
        parties--;
        partiesToAwait--;

        if(partiesToAwait==0){
            notifyAll();
            phase++;
            partiesToAwait = parties;
        }

    }
}
