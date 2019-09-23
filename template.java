import java.util.Scanner; // Import the Scanner class

public class template {

    private int sampleInt;
    private String sampleStr;

    public static void main(String[] args) {

        int[] intArray1 = new int[] { 1, 2, 3, 4, 5 };
        String str1 = "abc";

        Scanner commandInput = new Scanner(System.in);
        System.out.println("type something to start~");

        while (commandInput.hasNext()) {
            System.out.println("Input: " + commandInput.next());
            System.out.println("type something to continue...");
        }

        commandInput.close();
        System.out.println("====template done here");

    }
}