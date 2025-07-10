class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                int val = ch - '0';

                if(first < val){
                    second = first;
                    first = val;
                }
                else if(val < first){
                    second = Math.max(val,second);
                }
            }
        }

        return second;
    }
}