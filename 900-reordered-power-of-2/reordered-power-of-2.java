class Solution {
    /*
        Think of it like checking for anagrams in words. How do you know if "silent" is an anagram of "listen"?
        
        Instead of trying every possible combination of the letters in "silent", you can just sort the  letters of both words:
        
        s-i-l-e-n-t sorted is e-i-l-n-s-t
        
        l-i-s-t-e-n sorted is e-i-l-n-s-t
        
        Since their sorted "signatures" are identical, they must be anagrams. The digit sorting method applies this exact same logic to numbers.
    
    
     */
    public boolean reorderedPowerOf2(int n) {
        String sortedStr = countSort(n);

        if (sortedStr.charAt(0) == 0) {
            return false;
        }

        for (int i = 0; i < 30; i++) {
            int powerOf2 = (int) Math.pow(2, i);

            String powerOf2Signature = countSort(powerOf2);

            if (powerOf2Signature.equals(sortedStr)) {
                return true;
            }
        }

        return false;
    }

    private String countSort(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}