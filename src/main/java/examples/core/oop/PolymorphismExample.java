package examples.core.oop;

public class PolymorphismExample {
    public static void main(String[] args) {
        Runnable first = new First();
        Runnable second = new Second();
        first.run();
        second.run();
        startRunnable(first);
        startRunnable(second);

    }

    private static void startRunnable(Runnable task) {
        new Thread(task).start();
    }
}

class First implements Runnable {

    /**
     *
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class Second implements Runnable {

    /**
     *
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
