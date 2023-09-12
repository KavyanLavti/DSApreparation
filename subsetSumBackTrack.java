class Solution 
{
    List<List<Integer>> fs = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        jennyOfOldstones(nums, 0, new ArrayList());
        return fs;
    }
    public void jennyOfOldstones(int[] arr, int id, List<Integer> ds)
    {
        List<Integer> zexy = new ArrayList<Integer>(ds);
        fs.add(zexy);
        for(int i=id; i<arr.length; i++)
        {
            if(i!=id && arr[i]==arr[i-1]) continue;
            ds.add(arr[i]);
            jennyOfOldstones(arr, i+1, ds);
            ds.remove(ds.size()-1);
        }
    }
}
