package sorting;

public class BubbleSort {
    public int[] sortArray(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();
        int a[] = {4, 2, 98, 44, 33, 65, 120, 65, 38, 43, 88, 67};
        sorter.sortArray(a);
        for (int num : a) {
            System.out.println(num);
        }
    }
}
