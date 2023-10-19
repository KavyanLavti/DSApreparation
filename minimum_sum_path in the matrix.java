import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static int minSumPath(int[][] grid) 
    {
    	int[][] memory = new int[grid.length][grid[0].length];

        return minPath(grid,0,0,memory);
    }
    public static int minPath(int[][] grid, int x, int y, int[][] memory)
    {
        if(memory[x][y]!=0)return memory[x][y];
        if(x==grid.length-1 && y==grid[0].length-1)
        {
            return memory[x][y] = grid[x][y];
        }
        if(x==grid.length-1)
        {
            return memory[x][y] =grid[x][y]+minPath(grid,x,y+1,memory);
        }
        if(y==grid[0].length-1)
        {
            return memory[x][y] =grid[x][y]+minPath(grid,x+1,y,memory);
        }
        return memory[x][y] = Math.min(grid[x][y]+minPath(grid,x,y+1,memory),grid[x][y]+minPath(grid,x+1,y,memory));
    }
}
