package examples.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MaxSubArrayTest {


    @Test
    public void first() {
        int[] arr = { -1, 2, 3, -9 };
        int actual = MaxSubArray.findMaxSum(arr);
        assertEquals(5, actual);
    }

    @Test
    public void second() {
        int[] arr = { 2, -1, 2, 3, -9 };
        int actual = MaxSubArray.findMaxSum(arr);
        assertEquals(6, actual);
    }

    @Test
    public void third() {
        int[] arr = { -1, 2, 3, -9, 11 };
        int actual = MaxSubArray.findMaxSum(arr);
        assertEquals(11, actual);
    }

    @Test
    public void fourth() {
        int[] arr = { -2, -1, 1, 2 };
        int actual = MaxSubArray.findMaxSum(arr);
        assertEquals(3, actual);
    }

    @Test
    public void fifth() {
        int[] arr = { 100, -9, 2, -3, 5 };
        int actual = MaxSubArray.findMaxSum(arr);
        assertEquals(100, actual);
    }

    @Test
    public void sixth() {
        int[] arr = { 1, 2, 3 };
        int actual = MaxSubArray.findMaxSum(arr);
        assertEquals(6, actual);
    }

    @Test
    public void seventh() {
        int[] arr = { -1, -2, -3 };
        int actual = MaxSubArray.findMaxSum(arr);
        assertEquals(0, actual);
    }
}