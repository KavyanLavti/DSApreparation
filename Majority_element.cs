// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. 
//You may assume that the majority element always exists in the array.

//solved by Moore's voting algorithm

//O(N) +*O(N)
//* only if we have to check, and sureity isnt provided

public class Solution 
{
    public int MajorityElement(int[] nums) 
    {
        int count =0;
        int element=0;
        for(int i=0; i<nums.Length; i++)
        {
            if(count==0)
            {
                element=nums[i];
                count++;
            }
            else if(nums[i]==element)
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return element;
    }
}

//if we had to check, the sureity isnt provided in th Ques. that a MajorityElemet exists
count = 0
for(int i=0; i<nums.Length; i++)
{
    if(nums[i]==element){count++;}
}
if(count>nums.Length/2){true;}
else{false}
