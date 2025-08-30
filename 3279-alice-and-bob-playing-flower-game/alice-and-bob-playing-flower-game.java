class Solution {
    // Optimal
    public long flowerGame(int n, int m) {
        return ((long)n*(long)m)/2;
        // long odd_n = (n + 1) / 2;
        // long even_n = n / 2;

        // long odd_m = (m + 1) / 2;
        // long even_m = m / 2;

        // return odd_n*even_m + odd_m*even_n;
    }

    // Brut
    // Alice wins if the total number of flowers picked (x + y) is odd, meaning she takes the last turn and captures Bob.
    // public long flowerGame(int n, int m) {
    //     int count = 0;
    //     for(int i = 1; i <= n; i++){
    //         for(int j = 1; j <= m; j++){
    //             if((i + j) % 2 != 0){
    //                 count++;
    //             }
    //         }
    //     }

    //     return count;
    // }
}