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

Better Solution - https://leetcode.com/problems/merge-k-sorted-lists/solutions/3286070/day-71-divide-and-conquer-easiest-beginner-friendly-sol

//I have done merging all the lists at once the better solution (best) takes 2 meres them and then continues till all the nodes are merged
//better solution O(Nlog(k))


class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        int n = lists.length;
        boolean zaza = true;
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(zaza)
        {
            zaza = false;
            int min = Integer.MAX_VALUE;
            int k = -1;
            for(int i=0; i<lists.length; i++)
            {
                if(lists[i]!=null)
                {
                    zaza = true;
                    if(lists[i].val<min)
                    {
                        min = lists[i].val;
                        k = i; 
                    }
                }
            }
            if(k!=-1)
            {
                ListNode X = new ListNode(min);
                head.next = X;
                head = head.next;
                lists[k] = lists[k].next;
            }
        }
        return dummy.next;
    }
}
