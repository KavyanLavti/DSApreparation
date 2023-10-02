//Given a string s, find the length of the longest substringwithout repeating characters.


class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {


        int maxSize = 0;
        //for(int j=0; j<s.length(); j++)
        //{
            int size=0;
            List<Character> l1 = new ArrayList<>();
            for(int i=0; i<s.length(); i++)
            {
                if(l1.contains(s.charAt(i)))
                {
                    int index = l1.indexOf(s.charAt(i));
                    for(int j=index; j>-1; j--)
                    {
                        l1.remove(j);
                    }
                    size = l1.size();
                }
                size++;
                l1.add(s.charAt(i));
                maxSize = Math.max(maxSize,size);
            }
        //}
        return maxSize;
    }
}
