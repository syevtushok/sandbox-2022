package examples.core;

public final class ImmutableExample {
    private final int count;

    public ImmutableExample(int count) {
        this.count = count;
    }

    public static void main(String[] args) {

    }

    public int getCount() {
        return count;
    }
}
