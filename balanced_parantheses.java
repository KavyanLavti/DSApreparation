// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.


class Solution 
{
    // Stack<Character> stack = new Stack<>();
    public boolean isValid(String s) 
    {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
            {
                stack.push(s.charAt(i));
            }
            else
            {
                if(stack.isEmpty()){return false;}
                else
                {
                    if(s.charAt(i)==')' && stack.peek()!='(')
                    {
                        return false;
                    }
                    else if(s.charAt(i)=='}' && stack.peek()!='{')
                    {
                        return false;
                    }
                    else if(s.charAt(i)==']' && stack.peek()!='[')
                    {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty())
        {
            return true;
        }
        return false;

// THIS METHOD GIVEN BELOW IS FASTER BUT HARDER TO CODE
      
        // int l=0;
        // int m=0;
        // int n=0;
        // int a=1;
        // int b=1;
        // int c=1;
        // for(int i=0; i<s.length(); i++)
        // {
        //     if(l<0||m<0||n<0){return false;}
        //     if(s.charAt(i)=='(')
        //     {
        //         l=l+a+b+c;
        //         a++;
        //     }
        //     else if(s.charAt(i)=='{')
        //     {
        //         m=m+a+b+c;
        //         b++;
        //     }
        //     else if(s.charAt(i)=='[')
        //     {
        //         n=n+a+b+c;
        //         c++;
        //     }
        //     else if(s.charAt(i)==')')
        //     {
        //         a--;
        //         l=l-a-b-c;
        //     }
        //     else if(s.charAt(i)=='}')
        //     {
        //         b--;
        //         m=m-a-b-c;
        //     }
        //     else if(s.charAt(i)==']')
        //     {
        //         c--;
        //         n=n-a-b-c;
        //     }
        // }
        //if(n==0 && m==0 && l==0){return true;}
        //return false;
    }
}
