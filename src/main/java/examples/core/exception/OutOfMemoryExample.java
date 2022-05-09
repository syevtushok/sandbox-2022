package examples.core.exception;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(1);
        }
    }
}
