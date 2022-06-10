package examples.concurrency.core;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ControlSubThread implements Runnable {
    private final AtomicBoolean running = new AtomicBoolean(false);
    private Thread worker;
    private int interval;

    public ControlSubThread(int interval) {
        this.interval = interval;
    }

    @SneakyThrows
    public static void main(String[] args) {
        ControlSubThread controlSubThread = new ControlSubThread(1);
        controlSubThread.start();
        TimeUnit.SECONDS.sleep(1);
        controlSubThread.stop();
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        running.set(false);
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            try {
                TimeUnit.SECONDS.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Thread was interrupted, Failed to complete operation");
            }
        }
    }
}
