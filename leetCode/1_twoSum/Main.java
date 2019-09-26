import java.io.*;
import java.util.*;

class Main {

    public static void printArray(int[] na, String name) {
        int len = na.length;
        System.out.print("the " + name + " array is: ");
        for (int i = 0; i < len; i++) {
            System.out.print(na[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    public static int[] twoSum(int[] nums, int target) {
        System.out.println("The target is: " + target);
        printArray(nums, "inpur");
        int[] resarr = new int[2];

        int restar = 0;

        for (int i = 0; i < nums.length; i++) {
            restar = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (restar == nums[j]) {
                    resarr[0] = i;
                    resarr[1] = j;
                    printArray(resarr, "result");
                    return resarr;

                }
            }
        }

        return resarr;
    }

    public static void main(String[] args) {
        int[] numarr = new int[] { 1, 2, 3, 4, 5 };
        int target = 5;
        twoSum(numarr, target);
        System.out.println("twosum done here");
    }
}
