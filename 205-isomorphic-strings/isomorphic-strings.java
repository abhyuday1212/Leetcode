class Solution {
    public boolean isIsomorphic(String s, String t) {
        // preCompute and asigninng values
        HashMap<Character, Character> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char secChar = t.charAt(i);
           
            if (mp.containsKey(key)) {
                if (mp.get(key) != secChar) {
                    return false; // Inconsistent mapping
                }
                continue; 
            }
            else{
                if(mp.containsValue(secChar)){
                    return false;
                }
                mp.put(key, secChar);
            }
        }

        boolean isomorphic = true;
        // now check weather it is isomorphic or not
        for (int i = 0; i < s.length(); i++) {
            // now for every key and its coressponding value, check weather in the seccond
            // string it is same or not
            char currElem = s.charAt(i);
            if (mp.containsKey(currElem)) {
                // current Element Value r character at that position is
                if (mp.get(currElem) == t.charAt(i)) {
                    continue;
                } else {
                    isomorphic = false;
                }
            } else {
                isomorphic = false;
            }
        }

        System.out.println(isomorphic);

        return isomorphic;
    }
}