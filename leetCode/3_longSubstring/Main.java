
public class Main {

    public static String[] findAllSub(String str) {
        int strlen = str.length();
        int sublen = 1;
        int avapos = 0;
        String[] allsub = new String[(int) Math.pow(2, strlen) - 1]; // initial the substring array

        while (sublen <= strlen) {
            for (int i = 0; i + sublen <= strlen; i++) {
                allsub[avapos] = str.substring(i, i + sublen);
                avapos++;
            }
            sublen++;
        }

        String[] resarr = new String[avapos];
        for (int i = 0; i < avapos; i++) {
            resarr[i] = allsub[i];
        }
        return resarr;
    }

    public static void pAllSub(String[] strarr) {
        int c = strarr.length;
        int i = 0;
        System.out.print("{  ");
        do {
            System.out.print(strarr[i] + "  ");
            i++;
        } while (i != c);
        System.out.print(String.format("}, %s in total\n", i));
    } // print all elements in a row

    public static void pBooArr(Boolean[] strarr) {
        int c = strarr.length;
        int i = 0;
        System.out.print("{  ");
        do {
            System.out.print(strarr[i] + "  ");
            i++;
        } while (i != c);
        System.out.print(String.format("}, %s in total\n", i));
    } // print all elements in a row

    public static Boolean ifRepeat(String str) {

        if (str.length() <= 1) {
            return false;
        } else {
            int len = str.length();
            int i = 1;
            char a = str.charAt(0);
            char b = str.charAt(1);

            // System.out.println(a + " " + b);

            while (i < len - 1) {
                if (a == b) {
                    return true;
                } else {
                    a = b;

                    b = str.charAt(i + 1);
                    System.out.println(a + "   " + b);
                    i++;
                }
            }
            return false;
        }

    }

    public static Boolean[] checkAll(String[] strarr) {
        int len = strarr.length;
        Boolean[] resBooArr = new Boolean[len];

        for (int i = 0; i < len; i++) {
            resBooArr[i] = ifRepeat(strarr[i]);
        }

        return resBooArr;
    }

    public static void main(String[] args) {

        pAllSub(findAllSub("abcd"));

        pBooArr(checkAll(findAllSub("wxyz")));

        System.out.println("3longestSubstring done here");
    }
}
