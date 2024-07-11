class Solution 
{
    public int maxSatisfaction(int[] satisfaction) 
    {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length][satisfaction.length+1];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        return meralund(satisfaction,0,1,dp);
    }
    public int meralund(int[] arr, int i, int j, int[][] dp)
    {
        if(i>=arr.length)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int max = Math.max(meralund(arr,i+1,j+1,dp)+arr[i]*j,meralund(arr,i+1,j,dp));
        return dp[i][j]=max;
    }
}

//MINE is 21ms here is 2 ms brilliant solution

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int presum = 0, res = 0;
        for (int i = n - 1; i >= 0; i--) {
            presum += satisfaction[i];
            if (presum < 0) {
                break;
            }
            res += presum;
            // this step handles multiplication factor
        }
        return res;
    }
}
