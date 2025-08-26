class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        int n = bills.length;

        for (int i = 0; i < n; i++) {
            if (bills[i] == 5) {
                // check 
                five += 1;
            } else if (bills[i] == 10) {
                ten += 1;
                if (five > 0) {
                    five = five - 1;
                } else {
                    return false;
                }
            } else {
                if (ten > 0 && five > 0) {
                    five -= 1;
                    ten -= 1;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}