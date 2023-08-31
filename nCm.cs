//double has higher space then long
//space issues with nCm

public class Solution 
{
    public int UniquePaths(int m, int n) 
    { 
        if(m>=n)
        {
            return Convert.ToInt32(matrixSort(m,n));
        }
        else
        {
            return Convert.ToInt32(matrixSort(n,m));
        }
    }
    public double matrixSort(int m, int n)
    {
            double ans = 1;
            for(int i = m; i<m+n-1; i++)
            {
                ans=ans*i;
            }
            for(int i=2; i<n; i++)
            {
                ans=ans/i;
            }
            return ans;
    }
    // public long fract(int n)
    // {
    //     if(n==0||n==1){return 1;}
    //     long ans =1;
    //     for(int i=2; i<=n; i++)
    //     {
    //         ans=ans*i;
    //     }
    //     return ans;
    // }
}
