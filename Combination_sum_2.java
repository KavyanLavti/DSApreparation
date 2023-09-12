// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.


//optimal
//2ms, 42.5mb
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        this.backTrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backTrack(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) 
    {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < candidates.length; ++i) {
            if(i > start && candidates[i] == candidates[i - 1])
                continue;

            if(candidates[i] > target)
                break;

            curr.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}

//this is my solution 
//the time complexity and space one is same as the optimal given above when calculated but have 6ms and 44.7mb
//its because my solution takes one more step to discard solutions where sum have exeeded the target

class Solution 
{
    List<List<Integer>> fs = new ArrayList<List<Integer>> ();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        cum(candidates,target,new ArrayList(), 0, 0);
        return fs;
    }
    void cum(int[] arr, int target, List<Integer> l1, int id, int sum)
    {
        List<Integer> list = new ArrayList<Integer>(l1);
        if(target==sum)
        {
            // add to the list of lists
            fs.add(list);
            sum=0;
            return;
        }
        else if(target<sum){sum=0;return;}
        for(int i=id; i<arr.length; i++)
        {
            if(i!=id && arr[i]==arr[i-1]){continue;}
            list.add(arr[i]);
            cum(arr,target,list,i+1,sum+arr[i]);
            list.remove(list.size()-1);
        }
    }
}
