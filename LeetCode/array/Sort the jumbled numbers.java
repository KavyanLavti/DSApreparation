class Solution 
{
    //DIFFERENCE BETWEEN HASHMAP AND TREEMAP, TREEMAP IS SLOWER ITS CONTAINS VALUES AS TREE AND IT MAINTAIS ORDER WHILE ITERATING
    TreeMap<Integer,List<Integer>> h = new TreeMap<>();
    public int[] sortJumbled(int[] mapping, int[] nums) 
    {
        for(int i=0; i<nums.length; i++)
        {
            nums[i]=changeNum(nums[i],mapping);
        }
        Arrays.sort(nums);
        List<Integer> l1 = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> en : h.entrySet())
        {
            l1.addAll(en.getValue());
        }
        for(int i=0; i<nums.length; i++)
        {
            nums[i]=l1.get(i);
        }
        return nums;
    }
    public int changeNum(int x, int[] mapping)
    {
        int y = x;
        int ans = 0;
        int i = 0;
        if(y==0)ans+=mapping[y];
        while(y!=0)
        {
            ans+=Math.pow(10,i)*mapping[y%10];
            i++;
            y=y/10;
        }
        if(h.containsKey(ans))
        {
            List<Integer> l2 = h.get(ans);
            l2.add(x);
            h.put(ans,l2);
        }
        else
        {
            List<Integer> l2 = new ArrayList<>();
            l2.add(x);
            h.put(ans,l2);
        }
        return ans;
    }

    //THIS IS A REALLY OOD PIECE OF CODE TO RATHER DEAL WITH DIGITS OF A NUMBER

    // String s = String.valueOf(nums[i]);
    //         StringBuilder sb = new StringBuilder();
    //         for (int j = 0; j < s.length(); j++) {
    //             sb.append(mapping[Character.getNumericValue(s.charAt(j))]);
    //         }
    //         int val = Integer.valueOf(sb.toString());
    //         if (map.containsKey(val))
    //             map.get(val).add(i);
    //         else
    //             map.put(val, new ArrayList < > (Arrays.asList(i)));
}
