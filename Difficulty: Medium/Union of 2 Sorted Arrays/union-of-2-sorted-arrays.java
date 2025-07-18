// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n1 = a.length, left = 0;
        int n2 = b.length, right = 0;
        
        int lastElem = Integer.MAX_VALUE;
        
        while(left < n1 && right < n2){
            if(a[left] == b[right]){
                if(lastElem != a[left]){
                 ans.add(a[left]);
                 lastElem = a[left];
                }
                left++;
                right++;
            }
            else if(a[left] < b[right]){
                if(lastElem != a[left]){
                 ans.add(a[left]);
                 lastElem = a[left];
                }
                left++;
            }
            else{
                if(lastElem != b[right]){
                 ans.add(b[right]);
                 lastElem = b[right];
                }
                right++;
            }
            
        }
        
        while(left < n1){
            if(lastElem != a[left]){
                ans.add(a[left]);
                lastElem = a[left];
            }
            left++;
        }
        
        while(right < n2){
            if(lastElem != b[right]){
                ans.add(b[right]);
                lastElem = b[right];
            }
            right++;
        }
        
        return ans;
    }
}
