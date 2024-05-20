// You are given two positive integers x and y.

// In one operation, you can do one of the four following operations:

// Divide x by 11 if x is a multiple of 11.
// Divide x by 5 if x is a multiple of 5.
// Decrement x by 1.
// Increment x by 1.
// Return the minimum number of operations required to make x and y equal.

 



class Solution 
{
    public int minimumOperationsToMakeEqual(int x, int y) 
    {
        int[] dp = new int[2*x];
        Arrays.fill(dp,-1);
        return fuckall(x,y,dp);
    }
    public int fuckall(int x, int y, int[] dp)
    {
        if(y>=x)return y-x;
        if(dp[x]!=-1)return dp[x];
        int ans = Math.abs(x-y);
// can't be integer.maximum coz x-y steps se jyada kabhi nahi ho sakta
//x=2,y=1 case

        ans = Math.min(ans,1+x%11+fuckall(x/11,y,dp));
        ans = Math.min(ans,1+11-x%11+fuckall(x/11+1,y,dp));
        ans = Math.min(ans,1+x%5+fuckall(x/5,y,dp));
        ans = Math.min(ans,1+5-x%5+fuckall(x/5+1,y,dp));
        return dp[x] = ans;
    }
}
