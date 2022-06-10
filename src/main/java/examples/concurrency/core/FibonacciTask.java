package examples.concurrency.core;

import java.time.Instant;
import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Integer> {
    private final int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        FibonacciTask task = new FibonacciTask(40);
        Instant start = Instant.now();
        simple(task);
        Instant end = Instant.now();
        System.out.println(end.toEpochMilli() - start.toEpochMilli());

        Instant start2 = Instant.now();
        forkJoin(task);
        Instant end2 = Instant.now();
        System.out.println(end2.toEpochMilli() - start2.toEpochMilli());
    }

    private static void forkJoin(FibonacciTask task) {
        System.out.println(task.compute());
    }

    private static void simple(FibonacciTask task) {
        System.out.println(task.fibonacci(40));
    }

    @Override
    protected Integer compute() {
        if (n < 2) {
            return n;
        }

        FibonacciTask task1 = new FibonacciTask(n - 1);
        FibonacciTask task2 = new FibonacciTask(n - 2);
        task1.fork();

        return task2.compute() + task1.join();
    }

    private int fibonacci(int value) {
        if (value < 2) {
            return value;
        }

        return fibonacci(value - 1) + fibonacci(value - 2);
    }
}
