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
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        int mid = left+(right-left)/2;
        int i = 1;
        ListNode start = head;
        ListNode start2 = head;
        //ListNode end = head;
        ListNode pre = null;
        ListNode next = head.next;
        ListNode dummy = head;
        boolean zaza = false;
        if(i==left)zaza = true;
        while(head!=null)
        {
            if(i==left-1)
            {
                start = head;
                head=head.next;
            }
            else if(i==left)
            {
                start2 = head;
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            else if(i==right+1)
            {
                start.next = pre;
                start2.next = head;
                return dummy;
            }
            else if(i>left)
            {
                if(zaza && i==right)dummy=head;
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
                if(i==right && head==null)
                {
                    start.next = pre;
                    start2.next = head;
                    return dummy;
                }
            }
            else 
            {
                head = head.next;
            }
            i++;
        }
        return dummy;
    }
}
