class Solution {
       public boolean rotateString(String s, String goal) {
        boolean ans = recursiveCalc(s,goal,0);
        return ans;
    }

      public boolean recursiveCalc(String s, String goal, int index) {
        if (s.length() == index) {
            return false;
        }

        if (s.equals(goal)) {
            return true;
        }


        char ch = s.charAt(0);

        s = s.substring(1);
        String modifyStr = s + ch;
        s = modifyStr;


        return recursiveCalc(s, goal, index+1);
    }

}
