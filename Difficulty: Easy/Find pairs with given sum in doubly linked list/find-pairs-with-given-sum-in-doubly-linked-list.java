//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node next,prev;
    
    Node(int x)
    {
        data = x;
        next = null;
        prev = null;
    }
    
    public static Node inputList(BufferedReader br) throws IOException
    {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List
        
        String[] s = br.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0])), tail = head;
        for(int i = 1; i < s.length; i++){
            Node temp=new Node(Integer.parseInt(s[i]));
            tail.next = temp;
            tail.next.prev = tail;
            tail = tail.next;
        }
        return head;
    }
    
    public static void printList(Node node)
    {
        while (node != null)
        { 
    		System.out.print(node.data + " ");
    		node = node.next; 
    	}  
    	System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        if(m.size()==0){
            System.out.println("-1");
        }else{
            for(var a : m)
            {
                System.out.print("(" + a.get(0) + "," + a.get(1) + ")" + " ");
            }
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int target; 
            target = Integer.parseInt(br.readLine());
            
            
            Node head = Node.inputList(br);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.findPairsWithGivenSum(target, head);
            
            IntMatrix.print(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


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
     public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
      if(head == null){
          return new ArrayList<>();
      }
      
      Node left = head;
      Node right = findTail(head);
      
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      
      
      while(left.data < right.data){
          ArrayList<Integer> ds = new ArrayList<>();
          
          if(left.data + right.data == target){
              ds.add(left.data);
              ds.add(right.data);
              ans.add(ds);
              left = left.next;
              right = right.prev;
          }
          else if(left.data + right.data < target){
             left = left.next;
          }
          else{
              right = right.prev;
          }
          
      }
         
         return ans;
     }
     
     public static Node findTail(Node head){
         Node temp = head;
         
         while(temp.next != null){
             temp = temp.next;
         }
         
         return temp;
     }
     
     
     
     
    
    
    // Approach1 : usiing recursion first by converting the given DLL into array
    // public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
    //  if (head == null) {
    //     return new ArrayList<>();
    //  }
     
     
    //  ArrayList<Integer> arr = convertDLL2Arr(head);
     
    //  ArrayList<Integer> ds = new ArrayList<>();
     
    //  ArrayList<ArrayList<Integer>> ans = findPair(ds,arr,target,0);
     
    //  return ans;
    // }
    
    
    // // convert DLL 2 Arr
    // public static ArrayList<Integer> convertDLL2Arr(Node head){
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     Node temp = head;
        
    //     while(temp != null){
    //         arr.add(temp.data);
    //         temp = temp.next;
    //     }
        
    //     return arr;
    // }
    
    
    // public static ArrayList<ArrayList<Integer>> findPair(ArrayList<Integer> ds, List<Integer> arr, int target, int index) {
    //     ArrayList<ArrayList<Integer>> baseResult = new ArrayList<>();
    //     if (arr.size() == index || target < 0) {
    //         if (target == 0 && ds.size() == 2) {
    //             ArrayList<Integer> newAns = new ArrayList<>(ds);
    //             baseResult.add(newAns);
    //             return baseResult;
    //         }
    //         return baseResult;
    //     }


    //     ds.add(arr.get(index));
    //     ArrayList<ArrayList<Integer>> takenAns = findPair(ds, arr, target - arr.get(index), index + 1);
    //     ds.remove(ds.size() - 1); // remove the added number during backtracking steps

    //     ArrayList<ArrayList<Integer>> notTakeAns = findPair(ds, arr, target, index + 1);
    //     takenAns.addAll(notTakeAns);
    //     return takenAns;
    // }
}
        
