class Solution {
    public String sortVowels(String s) {
        int n = s.length();

        PriorityQueue<Integer> vPQList = new PriorityQueue<>();
        PriorityQueue<Integer> vPQIndex = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
                    || ch == 'u' || ch == 'U') {
                vPQIndex.add(i);
                vPQList.add((int) ch);
            }
        }

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {

            if (!vPQIndex.isEmpty() && vPQIndex.peek() == i) {
                int asciiVal = vPQList.poll();
                char newChar = (char) asciiVal; 

                sb.setCharAt(i, newChar);
                vPQIndex.remove(i);
            }
        }

        return sb.toString();
    }
}