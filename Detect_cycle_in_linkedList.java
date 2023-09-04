/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    //prefer the slow and fast pointer methrod
    public boolean hasCycle(ListNode head) 
    {
        ListNode X = new ListNode(0);
        ListNode Y = head;
        while(head!=null && head.next!=X)
        {
            Y=head.next;
            head.next = X;
            head = Y;
        }
        if(head==null){return false;}
        else return true;
    }
}
