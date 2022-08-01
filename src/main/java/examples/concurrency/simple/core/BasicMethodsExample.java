package examples.concurrency.simple.core;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BasicMethodsExample {
    @SneakyThrows
    public static void main(String[] args) {
        log.info("start");
        Thread thread = new Thread(() -> log.info(Thread.currentThread().getName()));
        synchronized (thread) {
            thread.start();
            thread.wait(5000);
        }
        log.info("before");
        Thread.sleep(4000);
        log.info("after");
    }
}
