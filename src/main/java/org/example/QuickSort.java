package org.example;

import java.util.Random;

/**
 * Quicksort is a sorting algorithm which, on average, makes O(n*log n) comparisons to sort
 * n items. In the worst case, it makes O(n^2) comparisons, though this behavior is
 * rare. Quicksort is often faster in practice than other algorithms.
 * <p>
 * Family: Divide and conquer.<br>
 * Space: In-place.<br>
 * Stable: False.<br>
 * <p>
 * Average case = O(n*log n)<br>
 * Worst case = O(n^2)<br>
 * Best case = O(n) [three-way partition and equal keys]<br>
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Quick_sort">Quicksort (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class QuickSort<T extends Comparable<T>> {

    private static final Random RAND = new Random();

    public enum PIVOT_TYPE {
        FIRST, MIDDLE, RANDOM
    }

    public static PIVOT_TYPE type = PIVOT_TYPE.RANDOM;

    private QuickSort() { }

    public static <T extends Comparable<T>> T[] sort(PIVOT_TYPE pivotType, T[] unsorted) {
        if (unsorted == null || unsorted.length <= 1) {
            return unsorted;
        }
        sort(unsorted, 0, unsorted.length - 1, pivotType);
        return unsorted;
    }

    private static <T extends Comparable<T>> void sort(T[] unsorted, int start, int finish, PIVOT_TYPE pivotType) {
        if (start >= finish) {
            return;
        }

        int pivotIndex = selectPivot(start, finish, pivotType);
        T pivot = unsorted[pivotIndex];

        swap(pivotIndex, finish, unsorted);

        int partitionIndex = partition(unsorted, start, finish, pivot);

        sort(unsorted, start, partitionIndex - 1, pivotType);
        sort(unsorted, partitionIndex + 1, finish, pivotType);
    }

    private static <T extends Comparable<T>> int selectPivot(int start, int finish, PIVOT_TYPE pivotType) {
        return switch (pivotType) {
            case FIRST -> start;
            case MIDDLE -> (start + finish) / 2;
            case RANDOM -> start + RAND.nextInt(finish - start + 1);
        };
    }

    private static <T extends Comparable<T>> int partition(T[] unsorted, int start, int finish, T pivot) {
        int low = start;
        int high = finish - 1;

        while (low <= high) {
            while (low <= high && unsorted[low].compareTo(pivot) <= 0) {
                low++;
            }
            while (low <= high && unsorted[high].compareTo(pivot) > 0) {
                high--;
            }
            if (low < high) {
                swap(low, high, unsorted);
            }
        }

        swap(low, finish, unsorted);
        return low;
    }

    private static <T extends Comparable<T>> void swap(int index1, int index2, T[] unsorted) {
        T temp = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = temp;
    }
}
