//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if(head == null || head.next == null) return head;
        
        Node temp1 = new Node(-1); //for Storing 0s
        Node temp2 = new Node(-1); //for Storing 1s
        Node temp3 = new Node(-1);  // for storing 2s
        
        Node temp1Head = temp1;
        Node temp2Head = temp2;
        Node temp3Head = temp3;
        
        Node temp = head;
        
        while(temp != null){
            if(temp.data == 0){
                temp1.next = temp;
                temp1 = temp;
            }
            else if( temp.data == 1){
                temp2.next = temp;
                temp2 = temp;
            }
            else if (temp.data == 2) {
                temp3.next = temp;
                temp3 = temp;
            }
            
            temp = temp.next;
        }
        
        
        temp1.next = temp2Head.next != null ? temp2Head.next : temp3Head.next;
        temp2.next = temp3Head.next;
        temp3.next = null;
 

        
        
        return temp1Head.next;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends