class Solution {
    public int findTheWinner(int n, int k) {
        return josephus(n, k) + 1;
    }

    private int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }

        return (josephus(n - 1, k) + k) % n;
    }
}

// BRUT
// class Solution {
//     public int findTheWinner(int n, int k) {
//         boolean[] arr = new boolean[n + 1];

//         int startIndex = k % n;

//         if (startIndex == 0) {
//             startIndex = n;
//         }

//         return recursiveHelper(arr, k, startIndex, n);
//     }

//     public int recursiveHelper(boolean[] arr, int k, int index, int remaining) {
//         int n = arr.length - 1;

//         if (remaining == 1) {
//             for (int i = 1; i <= n; i++) {
//                 if (!arr[i]) {
//                     return i;
//                 }

//             }
//         }

//         arr[index] = true;

//         int nextIndex = index;

//         int cnt = 0;

//         while (cnt < k) {
//             nextIndex++;

//             if (nextIndex > n) {
//                 nextIndex = 1;
//             }

//             if (!arr[nextIndex]) {
//                 cnt++;
//             }
//         }

//         return recursiveHelper(arr, k, nextIndex, remaining - 1);
//     }

// }