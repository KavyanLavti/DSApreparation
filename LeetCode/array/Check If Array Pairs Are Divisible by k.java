class Solution 
{
    public boolean canArrange(int[] arr, int k) 
    {
        int[] mod = new int[k];
        for(int x:arr)
        {
            x=x%k;
            if(x<0)x+=k;//FOR NEGATIVE CASES
            mod[x]++;
        }
        if(mod[0]%2==0)
        {
            if(k%2==0 && mod[k/2]%2!=0)
            {
                return false;
            }
            else
            {
                for(int i=1; i<=k/2; i++)//i<= "=" necessary 
                {
                    if(mod[i]!=mod[k-i] || (mod[i]+mod[k-i])%2!=0 )return false;
                }
                return true;
            }
        }
        return false;
    }
}
