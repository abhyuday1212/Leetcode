class Solution {
    public boolean rotateString(String s, String goal) {
         String tempStr = s; 

        for (int i = 0; i < s.length(); i++) {
            char firstChar = s.charAt(i);

            tempStr = tempStr.substring(1);
            String modifyStr = tempStr + firstChar;
            tempStr = modifyStr;

            if (modifyStr.equals(goal)) {
                return true;
            }
        }

        return false;
    }
}