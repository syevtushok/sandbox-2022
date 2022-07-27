package examples.data.structure.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        Object[] array = { 12, 3, 4, 45, 5, };
        int[] array2 = { 12, 3, 4, 45, 5, };

        List<String> list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        Object[] objects = list.toArray();
        Object[] objects2 = list.toArray(new String[0]);

        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(objects2));
    }
}
