// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:


// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
 

// Constraints:

// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode rotateRight(ListNode head, int k) 
    {
        ListNode start =head;
        int count =1;
        if(head==null){return null;}
        while(start.next!=null)
        {
            start=start.next;
            count++;
        }
        start.next=head;
        if(k>=count)
        {
            k=k%count;
        }
        count=count-k;
        //anytime we have the possibility of something - n times something else, consider 
        // remainder, % property
        while(count>0)
        {
            count--;
            start=start.next;
        }
        ListNode res = start.next;
        start.next=null;
        return res;
    }
}
