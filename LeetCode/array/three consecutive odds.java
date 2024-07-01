Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.





class Solution 
{
    public boolean threeConsecutiveOdds(int[] arr) 
    {
        int tag = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]%2!=0)tag++;
            else tag = 0;
            if(tag>=3)return true;
        }
        return false;
    }
}
