package examples.core;

public class CoreExample {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
    }
}
