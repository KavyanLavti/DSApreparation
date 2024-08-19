If we want to make 8 characters, we can make 2 characters and copy and paste it 3 times, So by extending simmilar 
logic if `n` is divisible by `i` then `fn(n) = f(i) + 1 + (n/i-1)` 1 for the copy and rest for the paste

class Solution 
{
    public int minSteps(int n) 
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return memo(n,dp);
    }
    public int memo(int n, int[] dp)
    {
        if(n==1)return 0;
        if(dp[n]!=-1)return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i=2; i<n; i++)
        {
            if(n%i==0)
            {
                min = Math.min(min,memo(i,dp)+n/i);
            }
        }
        if(min==Integer.MAX_VALUE)min = n;
        return dp[n] = min;
    }
}
