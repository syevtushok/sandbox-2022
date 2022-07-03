package examples.grokking.chapter1;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BinaryExample {
    public static void main(String[] args) {
        List<Integer> list = prepareList();
        int index = findIndex(list, 2500);
        log.info("index is {}", index);
        log.info(list.indexOf(2500));
    }

    private static int findIndex(List<Integer> list, int number) {
        int low = 0;
        int high = list.size();
        int iteration = 0;
        while (true) {
            ++iteration;
            int middle = (high + low) / 2;
            int elementByIndex = list.get(middle);
            if (low >= middle) {
                return -1;
            } else if (elementByIndex < number) {
                low = middle;
                continue;
            } else if (elementByIndex > number) {
                high = middle;
                continue;
            } else {
                log.info("iterations - {}", iteration);
                return middle;
            }
        }
    }

    private static List<Integer> prepareList() {
        return IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10000)).limit(10000)
                .distinct().sorted().boxed().toList();

    }

    private static List<Integer> prepareSimpleList() {
        return IntStream.range(0, 10001).boxed().toList();
    }
}
