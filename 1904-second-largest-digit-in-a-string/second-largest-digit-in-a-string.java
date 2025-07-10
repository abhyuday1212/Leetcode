class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int seccond = -1;

        for (char ch : s.toCharArray()) {
            int intVal = ch - '0'; // convert charater to string
            if (intVal <= 9) {
                // System.out.println("Num: " + intVal);
                //if numbers then only
                if(intVal != first) seccond = Math.max(intVal, seccond);

                if (intVal > first) {
                    seccond = first;
                    first = Math.max(first, intVal);
                }
            }
        }

        return seccond;
    }
}