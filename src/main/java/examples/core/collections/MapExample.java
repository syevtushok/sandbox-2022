package examples.core.collections;

import java.util.HashMap;

import lombok.Setter;

public class MapExample {
    public static void main(String[] args) {
        var map = new HashMap<>();

        MyUser myUser = new MyUser();
        myUser.setName("Sergey");
        map.put(myUser, 1);

        System.out.println(map.get(myUser)); // 1. что будет напечатано здесь?
        myUser.setYear(1993);

        System.out.println(map.get(myUser)); // 1. что будет напечатано здесь?
    }
}

@Setter
class MyUser {
    private String name;
    private int year;
}
