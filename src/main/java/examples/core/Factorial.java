package examples.core;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(findFactorial(5));
        System.out.println(findFactorial(7));
    }

    private static long findFactorial(int i) {
        if (i < 2) {
            return i;
        }

        return i * findFactorial(i - 1);
    }
}
