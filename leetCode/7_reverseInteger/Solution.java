class Solution {
    static public void reverse(int x) {
        int len;
        if(x >= 0){
            len = Integer.toString(x).length();
        } else {
            len = Integer.toString(x).length() - 1;
        }
        int pow = (int) Math.pow(10,len-1);
        
        int result = 0;
        int base = x;
        int mul = 1;
        while(pow > 1){
            result += base / pow * mul;
            mul = mul * 10;
            base = base % pow;
            pow = pow / 10;
        }
        result += base / pow * mul;
        System.out.println("result: "+ result);
    }
    public static void main(String[] args) {
        int i123 = 123;     //321
        int in321 = -321;   //-123
        int i120 = 120;     //21
        reverse(i123);
        reverse(in321);
        reverse(i120);
        System.out.println("====7 done here");
    }
}