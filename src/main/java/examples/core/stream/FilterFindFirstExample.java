package examples.core.stream;

import java.util.List;
import java.util.stream.IntStream;

public class FilterFindFirstExample {
    public static void main(String[] args) {
        List<Integer> collect = IntStream.range(1, 10).boxed().toList();

        int two = collect.stream()
                .filter(integer -> integer % 2 == 0)
                .findFirst()
                .get();

        assert two == 2;

        int one = collect.stream()
                .findFirst()
                .filter(integer -> integer % 2 == 0)
                .get();

        assert one == 1;

    }
}
