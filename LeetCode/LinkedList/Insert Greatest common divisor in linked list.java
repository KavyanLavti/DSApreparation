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
    public ListNode insertGreatestCommonDivisors(ListNode head) 
    {
        ListNode ans = head;
        while(head.next!=null)
        {
            ListNode X = new ListNode(GCD(head.val,head.next.val));
            X.next = head.next;
            head.next = X;
            head = X.next;
        }
        return ans;
    }
    public int GCD(int a, int b)
    {
        if(a<b)return GCD(b,a);
        if(a%b==0)return b;
        return GCD(b,a%b);
    }
}
