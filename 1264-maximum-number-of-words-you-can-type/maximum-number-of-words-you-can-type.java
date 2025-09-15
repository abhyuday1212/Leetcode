class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] textArr = text.split(" ");

        int count = 0;

        for (int j = 0; j < textArr.length; j++) {
            String curWord = textArr[j];

            for (int i = 0; i < brokenLetters.length(); i++) {
                String ch = brokenLetters.charAt(i) + "";

                if (curWord.contains(ch)) {
                    System.out.println("curWord: " + curWord);
                    System.out.println("ch: " + ch);
                    count++;
                    break;
                }

            }
        }

        return textArr.length - count;
    }
}