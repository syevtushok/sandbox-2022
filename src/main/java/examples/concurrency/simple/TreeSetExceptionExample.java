package examples.concurrency.simple;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExceptionExample {
    public static void main(String[] args) {
        Set<Integer> integers = new TreeSet<>(List.of(1, 2, 3, 4, 5, 6));
        integers.removeIf(integer -> integer % 2 == 0);
        for (Integer integer : integers) {
            if (integer % 2 == 1) {
                integers.remove(integer);
            }
        }
    }
}
