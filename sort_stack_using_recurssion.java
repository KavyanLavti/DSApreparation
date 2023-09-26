//sort a stack of N integerers using only recursion
//cannot use for and while statements

import java.util.* ;
import java.io.*; 
public class Solution 
{

	public static void sortStack(Stack<Integer> stack) 
	{
		if(stack.isEmpty())
		{
			return;
		}
		int x = stack.pop();
		sortStack(stack);
		sortedInstert(stack, x);
		// if(stack.isEmpty()){stack.push(x);}
		// else
		// {
		// 	Stack<Integer> s2 = new Stack<>();
		// 	while(!stack.isEmpty() && stack.peek()>x)
		// 	{
		// 		int z = stack.pop();
		// 		s2.push(z);
		// 	}
		// 	stack.push(x);
		// 	while(!s2.isEmpty())
		// 	{
		// 		int z = s2.pop();
		// 		stack.push(z);
		// 	}
		// }
	}
	public static void sortedInstert(Stack<Integer> stack, int current)
	{
		if(stack.isEmpty() || stack.peek()<=current)
		{
			stack.push(current);
			return;
		}
		int y = stack.pop();
		sortedInstert(stack, current);
		stack.push(y);
	}

}
