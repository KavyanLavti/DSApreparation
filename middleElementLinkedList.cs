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
    public ListNode MiddleNode(ListNode head) 
    {
        ListNode fuckyeah = head;
        ListNode dumbcunt = head;

        while(fuckyeah!=null && fuckyeah.next!=null)
        {
            dumbcunt = dumbcunt.next;
            fuckyeah = (fuckyeah.next).next;
        }
        return dumbcunt;
    }
}
