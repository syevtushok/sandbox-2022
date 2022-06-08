package examples.concurrency.core;

import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ThreadStateExample {

    @SneakyThrows
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("inside thread");
        });
        log.info("1 - {}", thread.getState());
        thread.start();
        log.info("2 - {}", thread.getState());
        TimeUnit.SECONDS.sleep(2);
        log.info("3 - {}", thread.getState());
    }
}
