package sorting;

public class QuickSort {
    public void sortArray(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    private void quickSort(int[] array, int start, int end) {
        if(start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot-1);
            quickSort(array, pivot+1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int pivot = end;
        int i = start;
        for(int j=start; j<end; j++) {
            if(array[j] < array[pivot]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[pivot];
        array[pivot] = temp;
        return i;
    }

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int a[] = {4, 2, 98, 44, 33, 953, 120, 65, 38, 43, 88, 67};
        sorter.sortArray(a);
        for (int num : a) {
            System.out.println(num);
        }
    }
}
