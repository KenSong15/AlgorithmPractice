import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class StringBasic {

    // print all duplicated characters in a string
    public static void printDuplicateChar(String str) {
        ArrayList<Character> chars = new ArrayList<Character>();
        ArrayList<Character> printAlready = new ArrayList<Character>();
        int len = str.length();

        for (int i = 0; i < len; i++) {
            char curchar = str.charAt(i);
            if (chars.contains(curchar)) {
                if (!printAlready.contains(curchar)) {
                    System.out.println("duplicate char: " + curchar);
                    printAlready.add(curchar);
                }
            } else {
                chars.add(curchar);
            }
        }
    }

    // check if two string are reverse
    public static void checkReverse(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 != len2) {
            System.out.println("length different, NOT reverse");
        } else {
            for (int i = 0; i < len1 / 2; i++) {
                if (str1.charAt(i) != str2.charAt(len2 - i - 1)) {
                    System.out.println("unmatch char, NOT reverse");
                    return;
                }
            }
            System.out.println("they are reverse");
        }
    }

    // print frist non-repeated character from a string
    public static void printFristUniqueChar(String str) {
        ArrayList<Character> charList = new ArrayList<Character>();
        ArrayList<Integer> countList = new ArrayList<Integer>();
        int len = str.length();

        for (int i = 0; i < len; i++) {
            char curchar = str.charAt(i);
            if (charList.contains(curchar)) {
                int targetPosition = charList.indexOf(curchar);
                int currentCount = (int) countList.get(targetPosition);
                countList.set(targetPosition, currentCount + 1);
            } else {
                charList.add(curchar);
                countList.add(1);
            }
        }
        System.out.printf("%s is the frist unique char in %s\n", charList.get(countList.indexOf(1)), str);
    }

    // palindrome: reverse equals to original
    // reverse a string using string buffer
    public static void reverseBuffer(String str) {
        String result = new StringBuffer(str).reverse().toString();
        System.out.printf("buffer: %s reversed to %s\n", str, result);
    }

    // reverse a string using iterative method
    public static void reverseIterate(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(str.charAt(len - i - 1));
        }
        System.out.printf("iterate: %s reversed to %s\n", str, sb.toString());
    }

    // reverse a string using recursion: take every first one and put it to the last
    public static String reverseRecursive(String str) {
        if (str.length() < 2) {
            return str;
        }
        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }

    // check a string only contains digit
    public static void checkDigitOnly(String str) {
        int len = str.length();
        int temp;
        for (int i = 0; i < len; i++) {
            try {
                temp = Integer.valueOf(String.valueOf(str.charAt(i)));
            } catch (Exception e) {
                System.out.printf("%s has NON digit char\n", str);
                return;
            }
        }
        System.out.printf("%s ALL digit char\n", str);
    }

    // count the number of vowels and consonants
    public static void countVowelConsonant(String str) {
        ArrayList<Character> vowels = new ArrayList<Character>(
                List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int vCount = 0;
        int cCount = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char curchar = str.charAt(i);
            if ((curchar > 64 && curchar < 91) || (curchar > 96 && curchar < 123)) {
                if (vowels.contains(str.charAt(i))) {
                    vCount++;
                } else {
                    cCount++;
                }
            }
        }
        System.out.printf("%s -> vowels:%d consonants:%d\n", str, vCount, cCount);
    }

    // count the occurrance of a given char in string
    public static void countGivenChar(String str, char c) {
        int count = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (c == str.charAt(i)) {
                count++;
            }
        }
        System.out.printf("%s given %s shows %d times\n", str, c, count);
    }

    // print all permutations on a given string
    public static void allPermutations(String str) {
        permutationRecursion("", str);
    }

    // permutation recursion function
    public static void permutationRecursion(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutationRecursion(perm + word.charAt(i),
                        word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    // reverse word on given sentence
    public static void reverseWordOnSentence(String sen) {
        // ArrayList<String> words = new ArrayList<String>();
        String[] words = sen.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reverseRecursive(words[i]);
        }
        StringBuilder sb = new StringBuilder("reversed: ");
        for (int i = 0; i < words.length - 1; i++) {
            sb.append(words[i] + " ");
        }
        sb.append(words[words.length - 1]);
        System.out.println(sb.toString());

    }

    // todo:check if two strings are rotation, any direction rotate
    public static void checkRotation(String str1, String str2) {

    }

    // three ways reverse sample
    public static void reverseSample() {
        String emptyStr = "";
        String aStr = "a";
        String ajStr = "abcdefghij";
        String jaStr = "jihgfedcba";
        String otStr = "123";
        String toStr = "321";

        reverseBuffer(ajStr);
        reverseBuffer(jaStr);
        reverseBuffer(otStr);
        reverseBuffer(toStr);
        reverseBuffer(emptyStr);
        reverseBuffer(aStr);
        System.out.println("==\n");

        reverseIterate(ajStr);
        reverseIterate(jaStr);
        reverseIterate(otStr);
        reverseIterate(toStr);
        reverseIterate(emptyStr);
        reverseIterate(aStr);
        System.out.println("==\n");

        String raj = reverseRecursive(ajStr);
        System.out.printf("recursive: %s reversed to %s\n", ajStr, raj);
        String rja = reverseRecursive(jaStr);
        System.out.printf("recursive: %s reversed to %s\n", jaStr, rja);
        String rot = reverseRecursive(otStr);
        System.out.printf("recursive: %s reversed to %s\n", otStr, rot);
        String rto = reverseRecursive(toStr);
        System.out.printf("recursive: %s reversed to %s\n", toStr, rto);
        String rempty = reverseRecursive(emptyStr);
        System.out.printf("recursive: %s reversed to %s\n", emptyStr, rempty);
        String ra = reverseRecursive(aStr);
        System.out.printf("recursive: %s reversed to %s\n", aStr, ra);
    }

    public static void main(String[] args) {

        String emptyStr = "";
        String aStr = "a";
        String ajStr = "abcdefghij";
        String jaStr = "jihgfedcba";
        String otStr = "123";
        String toStr = "321";
        String dupStr1 = "aabbbccccdddddefg";
        String dupStr2 = "abcabcdeffdexyz";
        String digitStr1 = "123456";
        String digitStr2 = "654321";
        String digitStr3 = "123456a";
        String digitStr4 = "123AEZ456";

        System.out.println("====String basic done here");

    }
}