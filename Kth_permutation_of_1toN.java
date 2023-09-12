// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.


class Solution 
{
    List<Integer> l1 = new ArrayList();
    String suckstobeu = "";
    public String getPermutation(int n, int k) 
    {
        for(int i=1; i<=n; i++)
        {
            l1.add(i);
        }
        //k=k-1; 
        sugarmama(n,k);
        return suckstobeu;   
    }
    public void sugarmama(int n, int k)
    {
        if(l1.size()==0){return;}
        int j = fact(n-1);
        if(k==0)
        {
            for(int i=0; i<l1.size(); i++)
            {
                suckstobeu += Integer.toString(l1.get(l1.size()-1-i));
            }
            l1.clear();
            return;
        }
        else if(k==1)
        {
            for(int i=0; i<l1.size(); i++)
            {
                suckstobeu += Integer.toString(l1.get(i));
            }
            l1.clear();
            return;   
        }
        else
        {
            if(k%j==0&&k!=0)
            {
                suckstobeu += Integer.toString(l1.get((k/j)-1));
                l1.remove((k/j)-1);
            }
            // else if(j==1)
            // {
            //     for(int i=0; i<l1.size(); i++)
            //     {
            //         suckstobeu += Integer.toString(l1.get(i));
            //     }
            //     //l1.removeAll();
            //     return;
            // }
            else
            {
                suckstobeu += Integer.toString(l1.get(k/j));
                l1.remove(k/j);
            }
            if(k!=0)
            {k=k%j;}
            sugarmama(n-1, k);
        }
    }
    public int fact(int n)
    {
        if(n==1||n==0){return 1;}
        else 
        {
            int x=1;
            for(int i=2; i<=n; i++)
            {
                x=x*i;
            }
            return x;
        }
    }
}
