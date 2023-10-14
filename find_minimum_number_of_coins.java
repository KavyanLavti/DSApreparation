import java.util.*;
public class Solution 
{
    public static List<Integer> MinimumCoins(int n) 
    {
        Stack<Integer> s = new Stack<>();
        s.add(2);
        s.add(5);
        s.add(10);
        s.add(20);
        s.add(50);
        s.add(100);
        s.add(500);
        s.add(1000);
        int sum = 0;
        int k = n;
        List<Integer> l1 = new ArrayList<>();
        while(!s.isEmpty() && sum!=n)
        {
            int x = s.pop();
            if(k/x!=0)
            {
                for(int i = k/x; i>0; i--)
                {
                    l1.add(x);
                }
                sum += x*(k/x);
                k = k%x;
            }
        }
        if(sum == n)
        {
            return l1;
        }
        for(int i = k; i>0; i--)
        {
            l1.add(1);
        }
        return l1;
    }
}
