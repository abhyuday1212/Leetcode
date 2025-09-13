class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowelMp = new HashMap<>();
        HashMap<Character, Integer> consonatMp = new HashMap<>();

        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;
        
        // precompute
        char[] ch = s.toCharArray();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
                vowelMp.put(ch[i], vowelMp.getOrDefault(ch[i], 0) + 1);
                maxVowelFreq = Math.max(maxVowelFreq, vowelMp.get(ch[i]));
                
            } else {
                consonatMp.put(ch[i], consonatMp.getOrDefault(ch[i], 0) + 1);
                maxConsonantFreq = Math.max(maxConsonantFreq, consonatMp.get(ch[i]));
            }
        }

        // Removed due to optimisation
        // List<Integer> vowelList = new ArrayList<>(vowelMp.values());
        // Collections.sort(vowelList);
        // int maxVowelFreq = 0;
        // if (vowelList.size() > 0)
        //     maxVowelFreq = vowelList.get(vowelList.size() - 1);

        // List<Integer> consonatList = new ArrayList<>(consonatMp.values());
        // Collections.sort(consonatList);

        // int maxConsonantFreq = 0;
        // if (consonatList.size() > 0)
        //     maxConsonantFreq = consonatList.get(consonatList.size() - 1);

        return maxVowelFreq + maxConsonantFreq;
    }
}