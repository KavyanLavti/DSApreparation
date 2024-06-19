You are given an integer array nums. Each element in nums is 1, 2 or 3. In each operation, 
you can remove an element from nums. Return the minimum number of operations to make nums non-decreasing.




class Solution 
{
    public int minimumOperations(List<Integer> nums) 
    {
        //[3,3,2]

        // Stack<Integer> s1 = new Stack<>();
        // int ans = 0;
        // for(int i=0; i<nums.size(); i++)
        // {
        //     while(!s1.isEmpty() && s1.peek()>nums.get(i))
        //     {
        //         ans++;
        //         s1.pop();
        //     }
        //     s1.push(nums.get(i));
        // } 


        int[][] dp = new int[nums.size()][4];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=3; i++)
        {
            ans = Math.min(ans,gaand(nums,nums.size()-1,i,dp));
        }
        return ans;

        // int ans = 0;
        // int low = 0;
        // int mid = 0;
        // int high = nums.size()-1;
        // for(int i=0; i<nums.size(); i++)
        // {
        //     if(nums.get(i)==1)
        //     {
        //         ans+=swap(nums,low,i);
        //         low++;
        //         mid++;
        //     }
        //     else if(nums.get(i)==2)
        //     {
        //         mid++;
        //     }
        //     else
        //     {
        //         ans+=swap(nums,i,high);
        //         high--;
        //     }
        // }
        // return ans;
    }
    // public int swap(List<Integer> l1, int x, int y)
    // {
    //     if(x==y)return 0;
    //     int t = l1.get(x);
    //     l1.set(x,l1.get(y));
    //     l1.set(y,t);
    //     return 1;
    // }

    public int gaand(List<Integer> l1 ,int i, int last, int[][] dp)
    {
        if(i<0)return 0;
        if(dp[i][last]!=-1)return dp[i][last];
        int ans = Integer.MAX_VALUE;
        if(l1.get(i)==last)
        {
            ans = Math.min(ans,gaand(l1,i-1,last,dp));
        }
        else if(l1.get(i)<last)
        {
            int x = Math.min(gaand(l1,i-1,l1.get(i),dp),1+gaand(l1,i-1,last,dp));
            ans = Math.min(ans,x);
        }
        else
        {
            ans = Math.min(ans,1+gaand(l1,i-1,last,dp));
        }
        return dp[i][last] = ans;
    }




}

//very good solution better then above one, max size of the sorted array we find
//[2,2,1,1,1,1] consider
class Solution {
    public int minimumOperations(List<Integer> nums) {
        int n=nums.size();
        int count=0,a=0,b=0,c=0,maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(nums.get(i)==1)
            a++;
            else if(nums.get(i)==2)
            b=Math.max(b+1,a+1);
            else
            c=Math.max(c+1,Math.max(a+1,b+1));
        }
        maxi=Math.max(a,Math.max(b,c));
        count=n-maxi;
        return count;
    }
}
