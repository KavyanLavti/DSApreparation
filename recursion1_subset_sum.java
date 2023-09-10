//Given a list arr of N integers, print sums of all subsets in it.


//User function Template for Java//User function Template for Java
class Solution
{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N)
    {
        //Integer X = arr.toArray(new Integer[0]);
        ArrayList<Integer> sex = new ArrayList<Integer>();
        sums(0,N,arr,sex,0);
        return sex;
    }
    void sums(int id, int N, ArrayList<Integer> arr, ArrayList<Integer> out, int sum)
    {
        if(id==N)
        {
            out.add(sum);
            return;
        }
        
        sums(id+1, N, arr, out, sum+arr.get(id));
        sums(id+1,N,arr,out,sum);
    }
}
