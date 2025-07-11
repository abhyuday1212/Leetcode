/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        if(head == null){
          return new ArrayList<>();
        }
        
        Node left = head;
        Node right = head;
        
        while(right.next != null){
            right = right.next;
        }
        
        // now left is standing at start and right is standing at end
        int totalSum = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        while(left.data < right.data){
            totalSum = right.data + left.data;
            
            if(totalSum == target){
                ans.add(new ArrayList<>(Arrays.asList(left.data, right.data)));
                left = left.next;
                right = right.prev;
            }
            else if(totalSum < target){
                left = left.next;
            }
            else{
                // totalSum > target
                right = right.prev;
            }
        }
        
        return ans;
        
    }
}
