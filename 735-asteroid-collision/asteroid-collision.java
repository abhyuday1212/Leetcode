class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else { // compare with st.peek
                while (!st.isEmpty() && st.peek() > 0 && Math.abs(asteroids[i]) > st.peek()) {
                    st.pop();
                }

                if (!st.isEmpty() && st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }

            }

        }

        int[] arr = new int[st.size()];
        int index = 0;
        if (st.isEmpty()) {
            return new int[0];
        }

        while (!st.isEmpty()) {
            arr[index] = st.peek();
            st.pop();
            index++;
        }

        reverseArray(arr);

        return arr;
    }

    public void reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}