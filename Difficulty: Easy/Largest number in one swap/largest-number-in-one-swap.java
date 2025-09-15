class Solution {
    public String largestSwap(String s) {
        int n = s.length();
        
        int possibleIdx = -1;
        StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(s.charAt(i) < s.charAt(j)){
                    if(possibleIdx != -1 && s.charAt(j) >= s.charAt(possibleIdx)){
                        // possible ans;
                        possibleIdx = j;
                    }
                    else if(possibleIdx == -1){
                        possibleIdx = j;
                    }
                }
                
            }
            
            if(possibleIdx != -1){
                // swap
                char tempCh = s.charAt(i);
                sb.setCharAt(i, sb.charAt(possibleIdx));
                sb.setCharAt(possibleIdx, tempCh);
                break;
            }
        }
        
        return sb.toString();
    }
}