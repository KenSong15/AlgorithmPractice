/*todo: 
QuickSort algorithm:
        把数列范围内的最后一个作为pivot,在前面选择一对错位的数并换位,
        然后在更小的范围内重复这个过程.

 */
public class QuickSort {

    public static void printArray(int[] arr) {
        int len = arr.length;
        StringBuilder sb = new StringBuilder("element: [");
        for (int i = 0; i < len - 1; i++) {
            sb.append(arr[i] + " ");
        }
        sb.append(arr[len - 1] + "]");
        System.out.println(sb.toString());
    }

    public static int[] quickSort(int[] arr) {
        // call the recursive function
        QSrecursive(arr, 0, arr.length - 1);
        return arr;
    }

    public static void QSrecursive(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            // don't need to touch the pivot position any more since the pivot
            // should in the proper place
            QSrecursive(arr, low, pi - 1);
            QSrecursive(arr, pi + 1, high);
        }
    }

    // this function make sure the pivot is in the proper position
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        // put the pivot back to its proper position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] intArray1 = new int[] { 12, 11, 13, 5, 6 };
        int[] intArray2 = new int[] { 4, 3, 2, 10, 12, 1, 5, 6 };
        int[] intArray3 = new int[] { 2, -1 };
        int[] intArray4 = new int[] { -4, 30, 21, 321, -1, 0, 67483219, 5621 };

        printArray(quickSort(intArray1));
        printArray(quickSort(intArray2));
        printArray(quickSort(intArray3));
        printArray(quickSort(intArray4));

        System.out.println("====quick sort done here");

    }
}