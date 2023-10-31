import java.util.*;
class n
{
    int value;
    n next;
    n()
    {
        value =0;
        next = null;
    }
    n(int value)
    {
        this.value = value;
        next = null;
    }
}
public class Solution 
{
    public static int minCost(int[][] cost) 
    {
        n a = new n(0);
        n b = new n(1);
        n c = new n(2);
        a.next = b;
        b.next = c;
        c.next = a;

        int[][] dp = new int[cost.length][3];
        for(int[] rw : dp)Arrays.fill(rw, -1);

        int A = maru(cost,0,a,dp);
        int B = maru(cost,0,b,dp);
        int C = maru(cost,0,c,dp);

        A = Math.min(A,B);
        A = Math.min(A,C);
        return A;
    }
    public static int maru(int[][] cost, int id, n ze, int[][] dp)
    {   
        if(id==cost.length)return 0;
        if(dp[id][ze.value]!=-1)return dp[id][ze.value];
        int ans = Math.min(maru(cost,id+1,ze.next,dp),maru(cost, id+1, ze.next.next,dp));
        return dp[id][ze.value]=ans+cost[id][ze.value];
    }   
}
