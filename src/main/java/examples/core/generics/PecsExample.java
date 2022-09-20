package examples.core.generics;

import java.util.ArrayList;
import java.util.List;

public class PecsExample {
    public static void main(String[] args) {
        List<? extends Number> numbersExtends = new ArrayList<>();
        List<Number> integers = List.of(1.0, 2, 3);
        numbersExtends = integers;

        System.out.println(numbersExtends.get(0).getClass());


        List<? super Number> numbersSuper = new ArrayList<>();
    }
}
