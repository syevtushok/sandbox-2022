package examples.concurrency.simple;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        executor();
        executorService();
        future();
        cyclicBarrier();
    }

    private static void cyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            log.info("All previous tasks are completed");
        });
        Thread t1 = new Thread(new TaskCyclicBarier(cyclicBarrier), "T1");
        Thread t2 = new Thread(new TaskCyclicBarier(cyclicBarrier), "T2");
        Thread t3 = new Thread(new TaskCyclicBarier(cyclicBarrier), "T3");

        if (!cyclicBarrier.isBroken()) {
            t1.start();
            t2.start();
            t3.start();
        }
    }

    private static void future() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return "Hello from " + Thread.currentThread().getName();
        });
        while (!future.isDone() || future.isCancelled()) {
            try {
                String str = future.get();
                log.info(str);
            } catch (InterruptedException | ExecutionException e) {
                log.throwing(e);
            }

        }
        executorService.shutdown();
    }

    private static void executor() {
        Executor executor = new Invoker();
        executor.execute(() -> log.info(Thread.currentThread().getName()));
    }

    private static void executorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Task());
        executorService.shutdown();
    }
}
