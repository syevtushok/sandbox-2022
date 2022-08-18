package examples.patterns.singleton;

public class Singleton {
    private static volatile Singleton singleton;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        Singleton result = singleton;
        if (result != null) {
            return result;
        }

        synchronized (Singleton.class) {
            if (singleton == null) {
                singleton = new Singleton(value);
            }
            return singleton;
        }
    }
}
