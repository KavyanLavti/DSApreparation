class Solution 
{
    List<List<Integer>> fs = new ArrayList<List<Integer>> ();
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        //alist1
        List<Integer> zin = new ArrayList<Integer>();
        int sum =0;
        sus(candidates, target, sum, 0, zin);
        return fs;
    }
    void sus(int[] arr, int target, int sum, int id, List<Integer> l1)
    {
        List<Integer> fme = new ArrayList<Integer>(l1);
        if(sum==target)
        {
            sum=0;
            if(!fs.contains(fme)){fs.add(fme);}
            System.out.print(id);
            return;
        }
        else if(sum>target)
        {
            sum = 0;
            return;
        }
        else if(id==arr.length)
        {
            sum=0;
            return;
        }
        fme.add(arr[id]);
        sus(arr, target, sum+arr[id], id, fme);
        sus(arr, target, sum+arr[id], id+1, fme);
        fme.remove(fme.size()-1);
        sus(arr, target, sum, id+1, fme);
    }
}
