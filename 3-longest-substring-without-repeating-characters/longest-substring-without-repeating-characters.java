class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();

        HashMap<Character, Integer> mp = new HashMap<>();
        // character, index

        int maxLen = 0;

        while(right < n){
            char ch = s.charAt(right);

            if(left < n && mp.containsKey(ch) && mp.get(ch) >= left){
                // mp.get(ch) >= left  ===> if the current element is before the left, the not consider that
                left = mp.get(ch) + 1;
            }

            mp.put(ch, right); 
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        
        return maxLen;
    }
}