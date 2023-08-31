//You have been given a 2-D array ‘mat’ of size ‘N x M’ where ‘N’ and ‘M’ denote the number of rows and columns, respectively. 
//The elements of each row are sorted in non-decreasing order. 
//Moreover, the first element of a row is greater than the last element of the previous row (if it exists). 
//You are given an integer ‘target’, and your task is to find if it exists in the given ‘mat’ or not.


//O(n+m) by me
public class Solution 
{
    public bool SearchMatrix(int[][] matrix, int target) 
    {
        int count = 0;
        for(int i=0; i<matrix.Length; i++)
        {
            if(matrix[i][0]<=target && matrix[i][matrix[0].Length-1]>=target)
            {count=count+i+1;}
        }
        if(count==0){return false;} 
        for(int j=0; j<matrix[0].Length; j++)
        {
            if(matrix[count-1][j]==target){return true;}
        }
        return false;
    }
}

//O(n+log(m)) solution Binary search
public class Solution 
{
    public bool SearchMatrix(int[][] matrix, int target) 
    {
        int count = 0;
        for(int i=0; i<matrix.Length; i++)
        {
            if(matrix[i][0]<=target && matrix[i][matrix[0].Length-1]>=target)
            {count=count+i+1;}
        }
        if(count==0){return false;} 
        return BinarySearch(matrix[count-1], target); 
    }
    public bool BinarySearch(int[] arr, int target)
    {
        int low = 0;
        int high = arr.Length-1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid]>target){high = mid-1;}
            else if(arr[mid]<target){low = mid+1;}
            else{return true;}
        }
        return false;
    }
}

//optimal approach O(log(m*n))
public class Solution 
{
    public bool SearchMatrix(int[][] matrix, int target) 
    {
        int low =0;
        int high =matrix.Length*matrix[0].Length-1; //m*n

        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(matrix[mid/matrix[0].Length][mid%matrix[0].Length]>target){high=mid-1;}
            else if(matrix[mid/matrix[0].Length][mid%matrix[0].Length]<target){low=mid+1;}
            else{return true;}
        }
        return false;
    }
}
