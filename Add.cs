// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 // Time Omplextity - O(max(m,n)), space - same;

// Example 1:


// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
// Example 2:

// Input: l1 = [0], l2 = [0]
// Output: [0]
// Example 3:

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]
 

// Constraints:

// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.


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
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) 
    {
        int carry =0;
        int sum =0;
        ListNode janabc = new ListNode();
        ListNode bhagbc = janabc;
        while(l1!=null && l2!=null)
        {
            ListNode fuckme = new ListNode();
            janabc.next = fuckme;
            janabc=fuckme;
            sum = l1.val+l2.val+carry;
            if(sum>=10)
            {
                sum = sum-10;
                carry=1;
            }
            else
            {
                carry=0;
            }
            janabc.val=sum;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null)
        {
            ListNode fuckme = new ListNode();
            janabc.next = fuckme;
            janabc=fuckme;
            sum = l1.val+carry;
            if(sum>=10)
            {
                sum = sum-10;
                carry=1;
            }
            else
            {
                carry=0;
            }
            janabc.val=sum;
            l1=l1.next;
        }
        while(l2!=null)
        {
            ListNode fuckme = new ListNode();
            janabc.next = fuckme;
            janabc=fuckme;
            sum = l2.val+carry;
            if(sum>=10)
            {
                sum = sum-10;
                carry=1;
            }
            else
            {
                carry=0;
            }
            janabc.val=sum;
            l2=l2.next;
        }
        if(carry==1)
        {
            ListNode fuckme = new ListNode();
            janabc.next = fuckme;
            janabc=fuckme;
            janabc.val=1;
        }
        //else janabc = null;
        return bhagbc.next;
    }
}
