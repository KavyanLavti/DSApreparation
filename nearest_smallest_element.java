// Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

// More formally,

//     G[i] for an element A[i] = an element A[j] such that 
//     j is maximum possible AND 
//     j < i AND
//     A[j] < A[i]
// Elements for which no smaller element exist, consider next smaller element as -1.

public class Solution 
{
    public int[] prevSmaller(int[] A) 
    {
        int[] arr = new int[A.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<A.length; i++)
        {
            if(st.isEmpty())
            {
                st.push(A[i]);
                arr[i] = -1;
            }
            else if(st.peek()<A[i])
            {
                arr[i]=st.peek();
                st.push(A[i]);
            }
            else
            {
                while(!st.isEmpty() && st.peek()>=A[i])
                {
                    st.pop();
                }
                if(st.isEmpty()){arr[i]=-1;}
                else{arr[i]=st.peek();}
                st.push(A[i]);
            }
        }
        return arr;
    }
}

// 2ND SOLUTION CLEANER CODE 

public class Solution 
{
    public int[] prevSmaller(int[] A) 
    {
        int[] arr = new int[A.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<A.length; i++)
        {
            while(!st.isEmpty() && st.peek()>=A[i])
            {
                st.pop();
            }
            if(st.isEmpty()){arr[i]=-1;}
            else if(st.peek()<A[i])
            {
                arr[i]=st.peek();
            }
            st.push(A[i]);
        }
        return arr;
    }
}

