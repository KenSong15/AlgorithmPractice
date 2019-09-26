/* InsertionSort algorithm: 
    Sort an arr[] of size n insertionSort(arr, n) Loop
    from i = 1 to n-1. ……a) Pick element arr[i] and insert it into sorted
    sequence arr[0…i-1]
    
    把每一个元素都插到前面已经排列好了的数列中,通过recursion一直到最后一个元素.
 */
public class InsertionSort {

    public static void printArray(int[] arr) {
        int len = arr.length;
        StringBuilder sb = new StringBuilder("element: [");
        for (int i = 0; i < len - 1; i++) {
            sb.append(arr[i] + " ");
        }
        sb.append(arr[len - 1] + "]");
        System.out.println(sb.toString());
    }

    public static int[] inserationSort(int[] arr) {
        return sortRecursion(arr, 0);
    }

    public static int[] sortRecursion(int[] arr, int pos) {
        if (pos == arr.length) {
            return arr;
        } else {
            // int current = arr[pos];
            for (int i = 0; i < pos; i++) {
                if (arr[pos] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[pos];
                    arr[pos] = temp;
                }
            }
            return sortRecursion(arr, pos + 1);
        }
    }

    public static void main(String[] args) {

        int[] intArray1 = new int[] { 12, 11, 13, 5, 6 };
        int[] intArray2 = new int[] { 4, 3, 2, 10, 12, 1, 5, 6 };
        int[] intArray3 = new int[] { 2, -1 };
        int[] intArray4 = new int[] { -4, 30, 21, 321, -1, 0, 67483219, 5621 };

        printArray(inserationSort(intArray1));
        printArray(inserationSort(intArray2));
        printArray(inserationSort(intArray3));
        printArray(inserationSort(intArray4));

        System.out.println("====insertion sort done here");
    }
}