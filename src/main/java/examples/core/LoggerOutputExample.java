package examples.core;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoggerOutputExample {
    public static void main(String[] args) {
        log.error("test " + "one" + "two");
    }
}
