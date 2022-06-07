package examples.concurrency.simple;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TaskCyclicBarier implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public TaskCyclicBarier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            log.info(Thread.currentThread().getName() + " is waiting");
            cyclicBarrier.await();
            log.info(Thread.currentThread().getName() + " is released");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
