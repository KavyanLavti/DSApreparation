class Solution 
{
    // static final int[][] MOVES = {
    //         /* 0 */ { 4, 6 },
    //         /* 1 */ { 6, 8 },
    //         /* 2 */ { 7, 9 },
    //         /* 3 */ { 4, 8 },
    //         /* 4 */ { 0, 3, 9 },
    //         /* 5 */ {},
    //         /* 6 */ { 0, 1, 7 },
    //         /* 7 */ { 2, 6 },
    //         /* 8 */ { 1, 3 },
    //         /* 9 */ { 2, 4 }
    // };

    //USE ABOVE INSTEAD OF HASHMAP ->> WAYY FASTER


    int mod = (int)Math.pow(10,9)+7;
    public int knightDialer(int n) 
    {
        int[][] dp = new int[n+1][10];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        HashMap<Integer,List<Integer>> h = hash();
        int ans = 0;
        for(int i=0; i<10; i++)
        {
            ans += fuckrec(n,h,i,dp);
            ans = ans%mod;
        }
        return ans;
    }
    public int fuckrec(int n, HashMap<Integer,List<Integer>> h, int k,int[][] dp)
    {
        if(n==0||n==1)return n;
        if(dp[n][k]!=-1)return dp[n][k];
        int ans = 0;
        for(int i=0; i<h.get(k).size(); i++)
        {
            ans += fuckrec(n-1,h,h.get(k).get(i),dp);
            ans=ans%mod;
        }
        return dp[n][k]=ans;
    }
    public HashMap<Integer,List<Integer>> hash()
    {
        HashMap<Integer,List<Integer>> h = new HashMap<>();
        for(int i=0; i<10; i++)
        {
            h.put(i,new ArrayList<Integer>());
        }
        h.get(1).add(6);
        h.get(1).add(8);
        h.get(2).add(7);
        h.get(2).add(9);
        h.get(3).add(8);
        h.get(3).add(4);
        h.get(4).add(3);
        h.get(4).add(0);
        h.get(4).add(9);
        h.get(6).add(1);
        h.get(6).add(7);
        h.get(6).add(0);
        h.get(7).add(6);
        h.get(7).add(2);
        h.get(8).add(1);
        h.get(8).add(3);
        h.get(9).add(4);
        h.get(9).add(2);
        h.get(0).add(4);
        h.get(0).add(6);
        return h;
    }
}
