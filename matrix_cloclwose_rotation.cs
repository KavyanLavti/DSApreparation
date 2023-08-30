public class Solution 
{
    public void Rotate(int[][] matrix) 
    {
        for(int n=0; n<matrix.Length; n++)
        {
            for(int m=n+1; m<matrix[0].Length; m++)
            {
                //here m should start from n as otherwise components will 
                //be swapped more than 1 time. 
                int key = matrix[n][m];
                matrix[n][m] = matrix[m][n];
                matrix[m][n] = key;
            }
        }
        for(int i=0; i<matrix.Length; i++)
        {
            int end = matrix[0].Length;
            for(int j=0; j<end/2; j++)
            {
                int key = matrix[i][j];
                matrix[i][j] = matrix[i][end-1-j];
                matrix[i][end-1-j] = key;
            }
        }
    }
}
