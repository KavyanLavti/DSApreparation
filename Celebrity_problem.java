//In a party of N people, only one person is known to everyone. 
//Such a person may be present at the party, if yes, (s)he doesn’t know anyone at the party. We can only ask questions like “does A know B? “. 
//Find the stranger (celebrity) in the minimum number of questions.
//We can describe the problem input as an array of numbers/characters representing persons in the party. 
//We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, and false otherwise. How can we solve the problem? 

import java.util.* ;
import java.io.*;
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B);
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/

public class Solution
{
	public static int findCelebrity(int n)
	{
		int p = 0, q= n-1;
		while(p<q)
		{
			if(Runner.knows(p,q))
			{
				p++;
			}
			else
			{
				q--;
			}
		}
		for(int i=0; i<n; i++)
		{
			if((!Runner.knows(p,i) && Runner.knows(i,p)) || p==i)
			{continue;}
			else{return -1;}
		}
		return p;

		// for(int i=0; i<n; i++)
		// {
		// 	int x = 0;
		// 	for(int j=0; j<n; j++)
		// 	{
		// 		if(i==j)
		// 		{continue;}
		// 		else if(!Runner.knows(i,j) && Runner.knows(j,i))
		// 		{
		// 			x++;
		// 			continue;
		// 		}
		// 		else
		// 		{
		// 			break;
		// 		}
		// 	}
		// 	if(x==n-1){return i;}
		// }
		// return -1;
    }
}
