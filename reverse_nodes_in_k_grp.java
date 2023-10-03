// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.



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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(k<2)
        {
            return head; 
        }
        ListNode X = head;
        ListNode start1 = head;
        ListNode start2 = head;
        ListNode pre = null;
        ListNode next1 = new ListNode();
        ListNode ans = new ListNode();
        int p =0;
        while(X!=null)
        {
            int z = k;
            while(X!=null && z>0)
            {
                next1 = X.next;
                X.next = pre;
                pre = X;
                X = next1;
                z--;
            }
            if(p<1)
            {
                ans = pre;
                p++;
            }
            if(X==null && z>0)
            {
                X = pre;
                pre = null;
                z = k-z;
                while(z>0)
                {
                    next1 = X.next;
                    X.next = pre;
                    pre = X;
                    X = next1;
                    z--;
                }
                start1.next = start2;
                return ans;
            }
            if(start1!=start2)
            {
                start1.next = pre;
            }
            start1 = start2;
            start2 = X;
            pre = null;
        }
        return ans;
    }
}
