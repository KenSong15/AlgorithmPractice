import java.util.ArrayList;

class Solution {

    static public Boolean isPalin(String str){
        int len = str.length();
        int front = 0;
        int back = len - 1;
        while(front < back){
            if(!(str.charAt(front) == str.charAt(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    static public void longestPalindrome(String s) {
        int len = s.length();
        int front = 0;
        int back = len - 1;

        ArrayList<String> results = new ArrayList<>();
        for(int i = 0; i < len; i++){
            for(int j = len; j > i; j--){
                if(isPalin(s.substring(i,j))){
                    results.add(s.substring(i,j));
                }
            }
        }

        int maxLen = 0;
        int curIndex = 0;
        for(int i = 0; i < results.size(); i++){
            if(results.get(i).length() > maxLen){
                curIndex = i;
                maxLen = results.get(i).length();
            }
        }
        System.out.println("longest: "+ results.get(curIndex));
        
    }
    public static void main(String[] args) {
        String babad = "babad";
        String cbbd = "cbbd";
        String aba = "aba";
        String bb = "bb";

        longestPalindrome(babad);
        longestPalindrome(cbbd);
        longestPalindrome(aba);
        longestPalindrome(bb);

        System.out.println("====5 done here");
    }
}