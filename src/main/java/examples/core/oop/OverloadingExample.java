package examples.core.oop;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class OverloadingExample {
    public static void main(String[] args) {
        Over over = new Over();
        over.print(1.5);
        over.print('c');
        over.print(14);
    }
}

@Log4j2
class Over {
    public void print(double d) {
        log.info("double {}", d);
    }

    public void print(float d) {
        log.info("float {}", d);

    }

    public void print(int d) {
        log.info("int {}", d);
    }

    public void print(char d) {
        log.info("char {}", d);
    }

    public void print(char d, String s) {
        log.info("char2 {}", d);
        log.info("string {}", s);
    }
}
