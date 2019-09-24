import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayBasic {

    public static void printArray(int[] arr) {
        int len = arr.length;
        StringBuilder sb = new StringBuilder("element: [");
        for (int i = 0; i < len - 1; i++) {
            sb.append(arr[i] + " ");
        }
        sb.append(arr[len - 1] + "]");
        System.out.println(sb.toString());
    }

    // remove element by give index
    public static int[] remove(int[] arr, int i) {
        // If the array is empty or the index is not in array range
        if (arr == null || i < 0 || i >= arr.length) {
            return arr;
        }

        // Create ArrayList from the array
        List<Integer> arrayList = IntStream.of(arr).boxed().collect(Collectors.toList());

        // Remove the specified element
        arrayList.remove(i);

        // return the resultant array
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    // remove duplicated
    public static void removeDuplicates(int[] arr) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int curInt = arr[i];
            if (values.contains(curInt)) {
            } else {
                values.add(curInt);
                curInt = arr[i];
            }
        }
        System.out.println("duplicate removed: " + values.toString());
    }

    // find duplicate numbers when there is many
    public static void printDuplicate(int[] arr) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int cur = arr[i];
            if (values.contains(cur)) {
                count.set(values.indexOf(cur), count.get(values.indexOf(cur)) + 1);
            } else {
                values.add(cur);
                count.add(1);
            }
        }
        for (int i = 0; i < values.size(); i++) {
            if (count.get(i) > 1) {
                System.out.printf("%d: %d\n", values.get(i), count.get(i));
            }
        }
    }

    // find largest and smallest on unsorted
    public static void printMinMax(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            System.out.println("no min nor max in empty array");
        } else {
            int min = arr[0];
            int max = arr[0];
            for (int i = 0; i < len; i++) {
                if (arr[i] < min)
                    min = arr[i];
                if (arr[i] > max)
                    max = arr[i];
            }
            System.out.println("min: " + min + ", max: " + max);
        }
    }

    // reverse
    public static void reverse(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        printArray(arr);
        // can also be done by array list reverse
    }

    // find all pairs of sum to given
    public static void findSumPair(int[] arr, int sum) {
        ArrayList<int[]> pairs = new ArrayList<int[]>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i != j) { // there has to be two different elements
                    if ((arr[i] + arr[j]) == sum) {
                        int[] pairA = new int[] { i, j };
                        int[] pairB = new int[] { j, i };
                        if ((!pairs.contains(pairA)) && (!pairs.contains(pairB))) {
                            pairs.add(new int[] { i, j });
                            pairs.add(new int[] { j, i });
                            System.out.printf("[%d]:%d [%d]:%d sum to %d\n", i, arr[i], j, arr[j], sum);
                        }
                    }
                } else { // there coule be same element
                }
            }
        }
    }

    // binary search in sorted array, base remark the length of array in left
    public static void binarySearch(int[] arr, int v, int left, int right) {
        if ((right - left) <= 1) {
            if (v == arr[left]) {
                System.out.printf("found %d where index:%d\n", v, left);
            } else {
                System.out.printf("NOT found\n");
            }
        } else {
            int mid = (left + right) / 2;
            if (v < arr[mid]) {
                binarySearch(arr, v, left, mid);
            } else {
                binarySearch(arr, v, mid, right);
            }
        }
    }

    // test binary search in array
    public static void binarySearchSample() {
        int[] arr1_9 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr1_6 = new int[] { 1, 2, 3, 4, 5, 6 };
        int[] arr1 = new int[] { 1 };

        binarySearch(arr1_9, 1, 0, arr1_9.length);
        binarySearch(arr1_9, 4, 0, arr1_9.length);
        binarySearch(arr1_9, 8, 0, arr1_9.length);
        binarySearch(arr1_9, 9, 0, arr1_9.length);

        binarySearch(arr1_6, 1, 0, arr1_6.length);
        binarySearch(arr1_6, 6, 0, arr1_6.length);

        binarySearch(arr1, 1, 0, arr1.length);
        binarySearch(arr1, 3, 0, arr1.length);
    }

    public static void main(String[] args) {

        int[] dup1 = new int[] { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5 };
        int[] dup2 = new int[] { 1, 2, 3, 4, 5, 5 };
        int[] dup3 = new int[] { 1, 2, 3, 1, 2, 3, 4, 4, 4, 4, 5, 5 };
        int[] min_max = new int[] { -12, 432, 3, 76, -5000 };
        int[] arr1_9 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr1_5 = new int[] { 1, 2, 3, 4, 5 };
        int[] arr1 = new int[] { 1 };
        int[] arrempty = new int[] {};
        int[] bSearch1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int[] bSearch2 = new int[] { 1, 2, 3, 4, 5, 6 };
        int[] bSearch3 = new int[] { 1, 2 };

        binarySearchSample();

        System.out.println("====array basic done here");

    }
}