package examples.concurrency.core;

import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MergeSortConcurrencyExample extends RecursiveAction {
    private final int[] arr;

    public MergeSortConcurrencyExample(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {

        int length = 100_000_000;
        int[] array = generateArray(length);
        MergeSortConcurrencyExample task = new MergeSortConcurrencyExample(Arrays.copyOf(array, array.length));

        Instant forkStart = Instant.now();
        task.compute();
        Instant forkEnd = Instant.now();
        log.info("fork - {}", forkEnd.toEpochMilli() - forkStart.toEpochMilli());

        Instant simpleStart = Instant.now();
        task.mergeSortSimple(task.arr, 0, length - 1);
        Instant simpleEnd = Instant.now();
        log.info("simple - {}", simpleEnd.toEpochMilli() - simpleStart.toEpochMilli());

    }

    private static int[] generateArray(int length) {
        int[] testArray = new int[length];
        for (int i = 0; i < length; i++) {
            testArray[i] = ThreadLocalRandom.current().nextInt(length);
        }

        return testArray;
    }

    @Override
    protected void compute() {
        if (arr.length < 2) {
            return;
        }

        int middle = arr.length / 2;
        int[] left = new int[middle];
        System.arraycopy(arr, 0, left, 0, middle);

        int[] right = new int[arr.length - middle];
        System.arraycopy(arr, middle, right, 0, arr.length - middle);

        invokeAll(new MergeSortConcurrencyExample(left), new MergeSortConcurrencyExample(right));
        mergeFork(left, right);
    }

    private void mergeFork(int[] left, int[] right) {
        int i = 0;
        int k = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    private void mergeSortSimple(int[] array, int low, int high) {
        if (high <= low) {
            return;
        }
        int middle = (low + high) / 2;


        mergeSortSimple(array, low, middle);
        mergeSortSimple(array, middle + 1, high);
        merge(array, low, middle, high);
    }

    private void merge(int[] array, int low, int middle, int high) {
        int[] leftArray = new int[middle - low + 1];
        int[] rightArray = new int[high - middle];

        System.arraycopy(array, low, leftArray, 0, leftArray.length);
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[middle + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }

    }
}
