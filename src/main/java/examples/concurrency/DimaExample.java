package examples.concurrency;

public class DimaExample {
    public static void main(String[] args) {
        System.out.println("main " + Thread.currentThread().getName());
        First first = new First();
        first.start();

        Thread second = new Thread(new Second());
        Thread third = new Thread(() -> System.out.println("third"));
        second.setDaemon(true);

        second.start();
        third.start();
    }
}

class First extends Thread {

    @Override
    public void run() {
        System.out.println("first " + Thread.currentThread().getName());
    }
}

class Second implements Runnable {

    @Override
    public void run() {
        System.out.println("second " + Thread.currentThread().getName());

    }
}