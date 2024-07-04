You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.

For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.

Return the head of the modified linked list.







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
    public ListNode mergeNodes(ListNode head) 
    {
        ListNode ans = new ListNode();
        ListNode prev = new ListNode();
        ListNode answer = ans;
        head = head.next;
        int sum = 0;
        while(head!=null)
        {
            if(head.val==0)
            {
                ans.val = sum;
                ListNode X = new ListNode();
                ans.next = X;
                prev = ans;
                ans = ans.next;
                sum = 0;
            }
            else
            {
                sum = sum+head.val;
            }
            head = head.next;
        }
        prev.next = null;
        return answer;
    }
}
