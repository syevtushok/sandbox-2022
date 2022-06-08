package examples.concurrency.core;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<Integer> value = new ThreadLocal<>();
        value.set(100);
        log.info("basic {}", value.get());

        ThreadLocal<Integer> withInitial = ThreadLocal.withInitial(() -> 22);
        log.info("withInitial {}", withInitial.get());
        withInitial.remove();
        log.info("withInitial {}", withInitial.get());


    }
}
