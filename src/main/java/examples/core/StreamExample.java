package examples.core;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamExample {
    public static void main(String[] args) {
        int[] gen = generate(5);
        System.out.println(Arrays.toString(gen));
    }

    private static int[] generate(int i) {
        return IntStream.iterate(i, operand -> operand - 1).limit(5).toArray();

    }
}
