class Solution 
{
    public int reverse(int x) 
    {
        boolean _ve = false;
        if(x<0)
        {
            _ve=true;
            x=x*(-1);
        }
        String s = Integer.toString(x);
        StringBuilder input1 = new StringBuilder();
        input1.append(s);
        input1.reverse();
        Integer ans;
        s = input1.toString();
        ans = TryParseInt(s);
        if(ans!=null)return (_ve)?-1*ans:ans;;
        //return (_ve)?-1*ans:ans;
        return 0;
    }
    public Integer TryParseInt(String someText) 
    {
        try 
        {
            return Integer.parseInt(someText);
        } 
        catch (NumberFormatException ex) 
        {
            return null;
        }
    }
}

//BETTER SOLUTION

class Solution {
    public int reverse(int x) {
        int revNum = 0;
        while(x!=0){ 
            int ld =x%10;  
            x = x/10;
             if (revNum > Integer.MAX_VALUE / 10 || (revNum == Integer.MAX_VALUE / 10 && ld > 7)) return 0;
            if (revNum < Integer.MIN_VALUE / 10 || (revNum == Integer.MIN_VALUE / 10 && ld < -8)) return 0;
            revNum = (revNum*10) + ld;
        }
        return revNum;
    }
}
