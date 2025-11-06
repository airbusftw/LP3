import java.util.Arrays;
import java.util.Random;

public class quickSort_Striver {

    static int dPartition(int low, int high, int arr[]) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high-1) i++;
            while (arr[j] > pivot && j >= low+1) j--;

            if (i < j) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot (arr[low]) with arr[j]
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    static void dQuickSort(int low, int high, int arr[]) {
        if (low < high) {
            int pIdx = dPartition(low, high, arr);
            dQuickSort(low, pIdx - 1, arr);
            dQuickSort(pIdx + 1, high, arr);
        }
    }



    static int rPartition(int low, int high, int arr[]) {
        Random rand = new Random();

        // Choose random pivot and swap with first element
        int randomPivot = low + rand.nextInt(high - low + 1);
        int temp = arr[randomPivot];
        arr[randomPivot] = arr[low];
        arr[low] = temp;

        int i = low;
        int j = high;
        int pivot = arr[low];

        while (i < j) {
            while (i <= high-1 && arr[i] <= pivot) i++;
            while (j >= low+1 && arr[j] > pivot) j--;

            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    static void rQuickSort(int low, int high, int arr[]) {
        if (low < high) {
            int pIdx = rPartition(low, high, arr);
            rQuickSort(low, pIdx - 1, arr);
            rQuickSort(pIdx + 1, high, arr);
        }
    }



    public static void main(String[] args) {
        int[] arr1 = {4, 6, 2, 5, 7, 9, 1, 3};
        int[] arr2 = arr1.clone();

        dQuickSort(0, arr1.length - 1, arr1);
        System.out.println(Arrays.toString(arr1));

        rQuickSort(0, arr2.length-1, arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
