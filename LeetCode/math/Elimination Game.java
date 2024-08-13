Better understand - https://leetcode.com/problems/elimination-game/solutions/4780076/1ms-100-solution-in-java-recursion-math-solution


class Solution 
{
    public int lastRemaining(int n) 
    {
        if(n==1||n==0)return n;
        return 2*(1+n/2-lastRemaining(n/2));
    }
}
