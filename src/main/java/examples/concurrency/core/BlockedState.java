package examples.concurrency.core;

import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BlockedState {

    @SneakyThrows
    public static void main(String[] args) {
        Thread t1 = new Thread(new DemoThread());
        Thread t2 = new Thread(new DemoThread());
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        log.info("1 - {}", t1.getState());
        log.info("2 - {}", t2.getState());
    }
}

@Log4j2
class DemoThread implements Runnable {

    @SneakyThrows
    public static synchronized void commonResource() {
        while (true) {
            log.info("Thread {} in state - {}", Thread.currentThread().getName(), Thread.currentThread().getState());
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Override
    public void run() {
        commonResource();
    }
}