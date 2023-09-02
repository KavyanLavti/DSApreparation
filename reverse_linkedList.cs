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
    public ListNode ReverseList(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode current = head;
        //current = head;
        ListNode Previous = null;
        ListNode Next = head.next;
        //head.next=null;
        while(Next != null)
        {
            current.next = Previous;
            Previous = current;
            current = Next;
            Next = Next.next;
        }
        current.next = Previous;
        return current;
    }
}
