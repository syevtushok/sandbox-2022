package examples.concurrency.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
class SynchronizedExampleTest {

    @Test
    @SneakyThrows
    void calculate() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        IntStream.range(0, 1000)
                .forEach(value -> executorService.submit(synchronizedExample::calculate));
        boolean awaitTermination = executorService.awaitTermination(1, TimeUnit.SECONDS);
        log.info("awaitTermination {}", awaitTermination);
        assertEquals(1000, synchronizedExample.getSum());
    }

    @Test
    @SneakyThrows
    void synchronizedCalculate() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        IntStream.range(0, 1000)
                .forEach(value -> executorService.submit(synchronizedExample::synchronizedCalculate));
        boolean awaitTermination = executorService.awaitTermination(1, TimeUnit.SECONDS);
        log.info("awaitTermination {}", awaitTermination);
        assertEquals(1000, synchronizedExample.getSum());
    }
}