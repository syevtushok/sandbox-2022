package examples.concurrency.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SquareCalculator {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @SneakyThrows
    public static void main(String[] args) {
        Future<Integer> calculate = new SquareCalculator().calculate(15);
        while (!calculate.isDone()) {
            log.info("Calculating...");
            TimeUnit.MILLISECONDS.sleep(300);
        }

        var result = calculate.get();
        log.info("result is {}", result);
    }

    @SneakyThrows
    public Future<Integer> calculate(Integer integer) {
        return executor.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return integer * integer;
        });
    }
}
