// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.

class Solution 
{
    public int maxProfit(int[] prices) 
    {
        changeArr(prices);
        return maxP(prices);
    }
    public void changeArr(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++)
        {
            arr[i] = arr[i+1] - arr[i];
        }
    }
    public int maxP(int[] arr)
    {
        int sum = 0;
        for(int i=0; i<arr.length-1; i++)
        {
            if(arr[i]>0)sum+=arr[i];
        }
        return sum;
    }
}
