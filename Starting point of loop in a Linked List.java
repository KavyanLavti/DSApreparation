// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

// Do not modify the linked list.

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
    public ListNode detectCycle(ListNode head) 
    {
        ListNode fastP = head;
        ListNode slowP = head;
        ListNode entry = head;
        //int size =0;
        while(fastP!=null && fastP.next!=null)
        {
            fastP=fastP.next.next;
            slowP=slowP.next;
            if(fastP==slowP)
            {
                while(slowP!=entry)
                {
                    slowP=slowP.next;
                    entry=entry.next;
                }
                return entry;
            }
            //System.out.print(slowP.val);
            //size++;
        }
        return null;

        // ListNode X = new ListNode(1000000);
        // //ListNode nex = head.next;
        // while(head!=null && head.val!=X.val)
        // {
        //     head.val = X.val;
        //     head=head.next;
        // }
        // return head;        
    }
}
