class Solution 
{
    public int findJudge(int n, int[][] trust) 
    {
        List<List<Integer>> l1 = new ArrayList<>();
        boolean[] issue = new boolean[n];
        for(int i=0; i<n; i++)
        {
            l1.add(new ArrayList<Integer>());
        }
        for(int i=0; i<trust.length; i++)
        {
            l1.get(trust[i][0]-1).add(trust[i][1]-1);
            issue[trust[i][0]-1] = true;
            l1.get(trust[i][1]-1).add(trust[i][0]-1);
        }
        for(int i=0; i<l1.size(); i++)
        {
            if(!issue[i] && l1.get(i).size()==n-1)
            {
                return i+1;
            }
        }
        return -1;
    }
}
//BETTER SOLUTION
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) 
            return 1;
        
       int[] count = new int[n + 1];

        for (int[] person : trust) {
            count[person[0]]--;
            count[person[1]]++;
        }

        for (int person = 0; person < count.length; person++) {
            if (count[person] == n - 1) return person;
        }
   return -1;
    }
}
