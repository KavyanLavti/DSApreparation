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
    public ListNode doubleIt(ListNode head) 
    {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode dummy = prev;
        while(head!=null)
        {
            if(head.val<5)head.val = 2*head.val;
            else
            {
                head.val = 2*head.val-10;
                prev.val = 1+prev.val;
            }
            prev = head;
            head = head.next;
        }
        if(dummy.val==0)return dummy.next;
        return dummy;
    }
}
