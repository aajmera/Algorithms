package sorting;

import java.time.Duration;
import java.time.Instant;

public class InsertionSort {
    public int[] sortArray(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int currentValue = num[i];
            int j = i - 1;
            while (j >= 0 && num[j] > currentValue) {
                num[j + 1] = num[j];
                j--;
            }
            num[j + 1] = currentValue;
        }
        return num;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        int a[] = new int[100000];
        int b[] = new int[100000];
        int c[] = new int[100000];
        System.out.println("Generating numbers");
        Instant start = Instant.now();
        for(int i=0; i<100000; i++) {
            int pow = (int)Math.abs(Math.random()*10);
            int val = (int)Math.abs(Math.random() * (10^pow)) + 1;
            a[i] = b[i] = c[i] = val;
        }
        Instant end = Instant.now();
        System.out.println("Generated numbers, time taken - " + Duration.between(start, end));

        System.out.print("Bubble sort:");
        start = Instant.now();
        bubbleSort.sortArray(a);
        end = Instant.now();

        System.out.println("Bubble sort time - " + Duration.between(end, start));

        System.out.print("selection sort:");
        start = Instant.now();
        selectionSort.sortArray(b);
        end = Instant.now();

        System.out.println("Selection sort time - " + Duration.between(end, start));

        System.out.print("insertion sort:");
        start = Instant.now();
        insertionSort.sortArray(c);
        end = Instant.now();

        System.out.println("Insertion sort time - " + Duration.between(end, start));
    }
}
