package examples.core;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("1111");
        builder.append(123434);

        System.out.println(builder.toString().replace("dd","ddd"));
    }
}
