package sorting;

public class SelectionSort {
    public int[] sortArray(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = num[i];
                num[i] = num[minIndex];
                num[minIndex] = temp;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        SelectionSort sorter = new SelectionSort();
        int a[] = {4, 2, 98, 44, 33, 953, 120, 65, 38, 43, 88, 67};
        sorter.sortArray(a);
        for (int num : a) {
            System.out.println(num);
        }
    }
}
