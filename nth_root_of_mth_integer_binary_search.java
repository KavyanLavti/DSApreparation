public class Solution 
{
    public static int NthRoot(int n, int m) 
    {
        int high =m;
        int low =0;
        while(high>=low)
        {
            int mid = low+(high-low)/2;
            //System.out.print(Integer.toString(low)+'\n');
            //System.out.print(Integer.toString(pow(mid,n,m))+'\n');
            if(pow(mid,n,m)>m)
            {
                high = mid-1;
            }
            else if(pow(mid,n,m)<m)
            {
                low = mid+1;
            }
            else{return mid;}
        }
        return -1;  
    }
    public static int pow(int z, int n, int m)
    {
        double x=1;
        for(int i=0; i<n; i++)
        {
            if(x<m){x=x*z;}
            else{return m+1;}
        }
        return (int)x;
    }
}
