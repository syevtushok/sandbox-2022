package examples.core.oop;

public class InheritanceExample {
    public static void main(String[] args) {
        Parent child = new Child();
        System.out.println(child.count);
        System.out.println(child.count);
        child.print();

        Child secondChild = new Child();
        System.out.println(secondChild.count);
        child.print();
    }
}

class Parent {
    public static String type;
    private static String name;
    public int count = 10;
    private int year = 0;

    public void print() {
        System.out.println("parent");
    }
}

class Child extends Parent {
    //    private int count = 1;
    public int count = 1;

    public void print() {
        System.out.println("child");
    }
}