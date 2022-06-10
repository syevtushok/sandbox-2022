package examples.concurrency.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ThreadPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> log.info("Hello from {}", Thread.currentThread().getName()));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> submit = executorService.submit(() -> "Hello from " + Thread.currentThread().getName());
        String result = submit.get();
        log.info(result);
    }
}
