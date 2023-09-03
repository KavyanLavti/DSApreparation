// Given the head of a linked list, remove the nth node from the end of the list and return its head. 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]
 
//two Pointerapproach O(N), Normal O(N)+O(M)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution
{
    public ListNode RemoveNthFromEnd(ListNode head, int n)
    {
        ListNode newNode = new ListNode();
        newNode = head;
        ListNode fastPointer = new ListNode();
        fastPointer = head;
        //int m=0;
        while(n>0)
        {
            fastPointer = fastPointer.next;
            n--;
        }
        //n=m-n;
        //newNode = head;
        if(fastPointer==null){return head.next;}
        while(fastPointer.next!=null)
        {
            newNode=newNode.next;
            fastPointer=fastPointer.next;
        }
        // if(n==0)
        // {
        //     return head.next;
        // }
        // while(n>1)
        // {
        //     n--;
        //     newNode=newNode.next;
        // }
        //newNode.next = newNode.next.next;
        if(newNode.next!=null)
        {
            newNode.next = newNode.next.next;
        }
        return head;
    }
}
