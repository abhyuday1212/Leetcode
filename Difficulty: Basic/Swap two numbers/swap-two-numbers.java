class Solution {
    static List<Integer> get(int a, int b) {
       List<Integer> list = new ArrayList<>();
       
       int temp = b;
       b = a;
       a = temp;
       
       list.add(a);
       list.add(b);
       
       return list;
    }
}