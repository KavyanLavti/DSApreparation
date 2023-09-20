class Solution 
{
    List<List<Integer>> fs = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) 
    {
        boolean[] sam = new boolean[nums.length];
        rpermute(nums, 0 , new ArrayList<Integer>(), sam);
        return fs;
    }
    public void rpermute(int[] arr, int id, List<Integer> ds, boolean[] sam)
    {
        List<Integer> nl = new ArrayList<Integer>(ds);
        if(nl.size()==arr.length){fs.add(nl);}
        //fs.add(nl);
        for(int i=id; i<arr.length; i++)
        {
            if(!sam[i])
            {
                nl.add(arr[i]);
                sam[i]=true;
                rpermute(arr,id,nl,sam);
                nl.remove(nl.size()-1);
                sam[i]=false;
            }
        }
    }
}
