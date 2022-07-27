package examples.core.oop;

import lombok.extern.log4j.Log4j2;

public class OverrideExample {
    public static void main(String[] args) {

    }
}

@Log4j2
abstract class ParentOverride {
    public void print() {
        log.info("parent");
    }

    public abstract void print2() throws Exception;
}

@Log4j2
class ChildOverride extends ParentOverride {
    @Override
    public void print()  {
        log.info("parent");
    }

    /**
     *
     */
    @Override
    public void print2() throws RuntimeException {

    }

}

