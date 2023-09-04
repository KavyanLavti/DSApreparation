// Given the head of a singly linked list, return true if it is a 
// palindrome
//  or false otherwise.

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


// time - O(n) + 2*O(n/2), space - O(1)

class Solution 
{
    public boolean isPalindrome(ListNode head) 
    {
        ListNode pre = null;
        ListNode nex = head.next;
        ListNode pointer = head;
        int c=0;
        while(pointer!=null)
        {
            pointer = pointer.next;
            c++;
        }

  // If we use the fast pointer slow pointer as shown below time complexity can be reduced to 3*O(n/2)
      
        // ListNode fastP = head;
        // while(fastP!=null && fastP.next!=null)
        // {
        //     pointer = pointer.next;
        //     fastP = fastP.next.next;
        //     c++;
        // }
        // if(fastP==null){length = c*2;}
        // else{length = c*2-1;}

        int x=c/2;
        pointer = head;
        while(x>0)
        {
            nex=pointer.next;
            pointer.next = pre;
            pre = pointer;
            pointer = nex;
            x--;
        }
        if(c%2==0)
        {
            while(pre!=null && pointer!=null)
            {
                if(pre.val != pointer.val)
                {
                    return false;
                }
                pre=pre.next;
                pointer=pointer.next;
            }
            return true;
        }
        else
        {
            pointer=pointer.next;
            while(pre!=null && pointer!=null)
            {
                if(pre.val != pointer.val)
                {
                    return false;
                }
                pre=pre.next;
                pointer=pointer.next;
            }
            return true;
        } 
    }
}
