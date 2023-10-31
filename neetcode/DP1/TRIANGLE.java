// 1ms, 44.03 MB
// WITH FOR LOOP 73ms
//FOR LOOP NOT NECESSARY COS IF 0 SE START KAR RAHE AND IN 2ND ROW THERE ARE 30 ELEMENTS WE WILL NEVER SEE AFTER 1;
class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        return minT(triangle,0,0,dp);
    }
    public int minT(List<List<Integer>> tri, int id, int rid, int[][] dp)
    {
        if(rid==tri.size()||tri.get(rid).size()==id)return 0;
        if(dp[rid][id]!=-1)return dp[rid][id];
        int min = Integer.MAX_VALUE;
        // for(int i=0; i<tri.get(rid).size()=; i++)
        // {
        //     int ans = Math.min(minT(tri,id,rid+1,dp),minT(tri,id+1,rid+1,dp));
        //     min = Math.min(min,ans+tri.get(rid).get(id));
        // }
        int ans = Math.min(minT(tri,id,rid+1,dp),minT(tri,id+1,rid+1,dp));
        min = Math.min(min,ans+tri.get(rid).get(id));
        return dp[rid][id] = min;
    }
}
