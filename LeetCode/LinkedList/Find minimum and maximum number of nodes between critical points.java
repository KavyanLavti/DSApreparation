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
    public int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        int prev = -100;
        if(head==null)
        {
            int ans[] = new int[2];
            Arrays.fill(ans,-1);
            return ans;
        }
        int prevI = 0;
        int i = 0;
        int i_start = 0;
        int min = Integer.MAX_VALUE;
        while(head.next!=null)
        {
            if(prev!=-100)
            {
                if(head.val>head.next.val && head.val>prev || head.val<head.next.val && head.val<prev)
                {
                    if(prevI!=0)min = Math.min(min,i-prevI);
                    prevI = i;
                    if(i_start==0)i_start = i;
                }
            }
            prev = head.val;
            i++;
            head = head.next;
        }
        int ans[] = new int[2];
        if(min == Integer.MAX_VALUE)
        {
            Arrays.fill(ans,-1);
            return ans;
        }
        else
        {
            ans[0] = min;
            ans[1] = prevI-i_start;
            return ans;
        }
    }
}
