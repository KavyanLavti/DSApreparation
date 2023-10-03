// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.


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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        ListNode head = new ListNode();
        if(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val){head = list1;}
            else{head = list2;}

            ListNode pre1 = new ListNode();
            ListNode pre2 = new ListNode();

            while(list1!=null && list2!=null)
            {
                if(list1.val<=list2.val)
                {
                    while(list1!=null && list1.val <= list2.val)
                    {
                        pre1 = list1;
                        list1 = list1.next;
                    }
                    pre1.next = list2;
                }
                else
                {
                    while(list2!=null && list2.val < list1.val)
                    {
                        pre2 = list2;
                        list2 = list2.next;
                    }
                    pre2.next = list1;
                }
            }
            return head;
        }
        else if(list1==null){return list2;}
        else{return list1;}
    }
}
