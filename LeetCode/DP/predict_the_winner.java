// You are given an integer array nums. 
//Two players are playing a game with this array: player 1 and player 2.
// Player 1 and player 2 take turns, with player 1 starting first. 
//Both players start the game with a score of 0. At each turn, the player takes one of the numbers from either end of the array 
//(i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their
// score. The game ends when there are no more elements in the array.
// Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, 
//and you should also return true. You may assume that both players are playing optimally.



class Solution 
{
    //public int sum = 0;
    public boolean predictTheWinner(int[] nums) 
    {
        //for(int i=0; i<nums.length; i++)sum+=nums[i];
        int[][] dp = new int[nums.length][nums.length];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        return lodalasan(nums,0,nums.length-1,dp)>=0;
    }
    public int lodalasan(int[] nums, int i, int j, int[][] dp)
    {
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        dp[i][j] = Math.max(nums[i]-lodalasan(nums,i+1,j,dp),nums[j]-lodalasan(nums,i,j-1,dp));
        //nums[i]-lodalasan(nums,i+1,j,dp) is the difference in scores
        return dp[i][j];
    }
}
