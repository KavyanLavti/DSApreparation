class Solution 
{
    public int maxSubArray(List<int> A)
    {
        int[] array = A.ToArray();
        int MaxSumYet = 0;
        int MaxGlobalSum = -2147483648;
        for(int i=0; i<array.Length; i++)
        {
            MaxSumYet = MaxSumYet+array[i];
            if(MaxGlobalSum<MaxSumYet)
            {
                MaxGlobalSum=MaxSumYet;
            }
            if(MaxSumYet<0)
            {
                MaxSumYet=0;
            }
        }
        return MaxGlobalSum;
    }
}
