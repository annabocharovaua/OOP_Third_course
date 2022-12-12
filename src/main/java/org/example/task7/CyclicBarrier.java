package org.example.task7;

public class CyclicBarrier {
    private final int countThreads;
    private int countToAwait;
    private final Runnable barrierAction;

    public CyclicBarrier(int countThreads){
        this.countThreads = countThreads;
        this.countToAwait = countThreads;
        barrierAction = null;
    }

    public CyclicBarrier(int countThreads, Runnable barrierAction){
        this.countThreads = countThreads;
        this.countToAwait = countThreads;
        this.barrierAction = barrierAction;
    }

    public synchronized  void await() throws InterruptedException {
        countToAwait--;

        if(countToAwait>0){
            wait();
        } else{
            countToAwait = countThreads;
            if(barrierAction!=null){
                barrierAction.run();
            }
            notifyAll();
        }
    }


}
