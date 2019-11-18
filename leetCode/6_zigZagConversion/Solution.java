class Solution {
    static public void convert(String s, int numRows) {
        int sum = 2 * numRows;
        int range = 2 * numRows - 2;
        
        String rangeString = "";
        int curIndex = 1;
        for(int i = 0; i < s.length(); i++){
            rangeString+=Integer.toString(curIndex);
            curIndex++;
            if(curIndex > range){
                curIndex = 1;
            }
        }
        System.out.println("range String: " + rangeString);
        
    }
    public static void main(String[] args) {
        String str8 = "12345678";
        
        String str14 = "ABCDEFGHIJKLMN";
        String strExp = "PAYPALISHIRING";
        // 3               12341234123412
        // 4               12345612345612
        // 5               12345678123456
        convert(str14,3);
        convert(str14,4);
        convert(str14,5);

    }
}