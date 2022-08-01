package examples.core;

public class ClassExample {
    public static String type = "new";
    private final int year = 5;

    static class NestedStatic {

        {
            NestedStatic nestedStatic = new NestedStatic();
        }
    }

    class Nested {

        {
            Nested nested = new Nested();
            System.out.println(year);
        }
    }
}
