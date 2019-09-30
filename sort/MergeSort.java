//todo: mergesort: 
public class MergeSort {

    public static void printArray(int[] arr) {
        int len = arr.length;
        StringBuilder sb = new StringBuilder("element: [");
        for (int i = 0; i < len - 1; i++) {
            sb.append(arr[i] + " ");
        }
        sb.append(arr[len - 1] + "]");
        System.out.println(sb.toString());
    }

    public static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays and Copy data */
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array and Merge*/
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void MSrecursive(int[] arr, int l, int r) {

        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            MSrecursive(arr, l, m);
            MSrecursive(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }

    }

    public static int[] mergeSort(int[] arr) {
        // fire the recursive call
        MSrecursive(arr, 0, arr.length - 1);
        return arr;
    }

    public static void main(String[] args) {

        int[] intArray1 = new int[] { 12, 11, 13, 5, 6 };
        int[] intArray2 = new int[] { 4, 3, 2, 10, 12, 1, 5, 6 };
        int[] intArray3 = new int[] { 2, -1 };
        int[] intArray4 = new int[] { -4, 30, 21, 321, -1, 0, 67483219, 5621 };

        printArray(mergeSort(intArray1));
        printArray(mergeSort(intArray2));
        printArray(mergeSort(intArray3));
        printArray(mergeSort(intArray4));

        System.out.println("====merge sort done here");

    }
}