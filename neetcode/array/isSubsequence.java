class Solution 
{
    public boolean isSubsequence(String s, String t) 
    {
        int p1 = s.length()-1;
        int p2 = t.length()-1;
        while(p1>=0 && p2>=0)
        {
            if(s.charAt(p1)==t.charAt(p2))
            {
                p1--;
                p2--;
            }
            else
            {
                p2--;
            }
        }
        if(p1>=0)return false;
        return true;
    }
}
