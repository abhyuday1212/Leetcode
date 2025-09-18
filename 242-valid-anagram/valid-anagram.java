class Solution {
    // Approach1 -> if all the subsequence of anagram is not equal to t than t is
    // not anagram of s.
    // Approach2 -> We Store a Key, Value pair in the hash table, now when iterating
    // through hash table we reduce its value by 1, if in the end the hash table
    // value is equal to 0 then we say it is a valid anagram otherwise we say it is
    // not
    // Approach3 -> We create two hash tables, one for s and one for two, if for the
    // same keys there values are same then we say it is a valid anagram

    // Implementing Approach 3
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        // Create two hash tables;
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        // precompute
        for (char key1 : s.toCharArray()) {
            mapS.put(key1, mapS.getOrDefault(key1, 0) + 1);
        }

        for (char key2 : t.toCharArray()) {
            mapT.put(key2, mapT.getOrDefault(key2, 0) + 1);
        }
        // System.out.println(mapS);
        // System.out.println(mapT);

        boolean ans = true;

        for (char key : mapT.keySet()) { // a = 1, c =3
            // System.out.println(mapT.get(key));
            // System.out.println(mapS.get(key));
            if (!mapT.get(key).equals(mapS.get(key))) {
                // System.out.println(mapT.get(key));
                ans = false;
                break;
            }
        }

        return ans;
    }
    
    // Fact: for a Anagram, if we sort the characters then it will be same
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length())
    //         return false;

    //     char[] charArr1 = s.toCharArray();
    //     char[] charArr2 = t.toCharArray();

    //     Arrays.sort(charArr1);
    //     Arrays.sort(charArr2);

    //     for(int i = 0; i < s.length(); i++){
    //         if(charArr1[i] != charArr2[i]){
    //             return false;
    //         }
    //     }

    //     return true;
    // }
}