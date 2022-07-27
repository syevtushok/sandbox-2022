package examples.core;

public class MaxSubArray {

    public static int findMaxSumKadanes(int[] arr) {
        int max = 0;
        int tempMax = 0;

        for (int i : arr) {
            tempMax = Math.max(i, i + tempMax);
            max = Math.max(max, tempMax);
        }

        return max;
    }

    public static int findMaxSum(int[] nums) {
        int max = 0; //max sum to return
        int tempMax = 0; //temporary max sum that I use in the cycle.


        for (int currentElement : nums) { //cycle to iterate the array.
            tempMax += currentElement; // get temp sum for subarray.
            max = Math.max(max, tempMax); // after each iteration check and set the max value.
            if (tempMax < 0) { //by the rules, the sum can't be less than zero.
                tempMax = 0; // if less then zero reset to zero.
            }
        }

        return max; // return max value.
    }

}
