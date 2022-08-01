package examples.core.enums;

import java.util.Random;

import lombok.extern.log4j.Log4j2;

enum DayOfWeek {
    MONDAY(21),
    TUESDAY(33);
    int i;

    DayOfWeek(int i) {
        this.i = i;
    }

    public static void test() {
        System.out.println("inside static");
    }

    public int generate() {
        return new Random().nextInt();
    }
}

@Log4j2
public class EnumExample {
    public static void main(String[] args) {
        log.info(DayOfWeek.MONDAY);
        System.out.println(DayOfWeek.MONDAY.i);
        System.out.println(DayOfWeek.MONDAY.generate());
        DayOfWeek.test();

    }
}
