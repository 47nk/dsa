/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    //THREE STEPS
    //1)after each node insert a node with same value;
    //2)assign random pointers
    //3)correct next pointers;
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node curr = head;
        while(curr != null)
        {
           Node newNode = new Node(curr.val);
           newNode.next = curr.next;
           curr.next = newNode;
           curr = newNode.next;
        }
        
        Node ans = head.next; //this will be our answer node;
        
        
        //now we will assing the random pointers
        Node prev = head;
        curr = head.next;
        while(curr.next != null)
        {
            if(prev.random != null)
            {
                curr.random = prev.random.next;
            }
            
            
            prev = curr.next;
            
            if(prev != null)
            {
                 curr = curr.next.next;
            }else{
                break;
            }
           
        }
        
        
        //now we will correct the next pointers
        prev = head;
        curr = head.next;
        while(curr != null)
        {
            Node temp = curr.next;
            prev.next = curr.next;
            if(curr.next != null)
            {
                 curr.next = curr.next.next;
            }
           
            
            prev = temp;
            if(prev != null)
            {
                curr = temp.next;
            }else{
                break;
            }
            
        }
        
       return ans;
    }
}
