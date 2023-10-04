// VERY MUCH TIME COMPLEXITY ONLY BEATS 5% DO AGAIN MAYBE

// ORIGINAL SOLUTION

class Solution 
{
  public List<List<String>> partition(String s) 
  {
    List<List<String>> f = new ArrayList<List<String>>();
    List<String> l =new ArrayList<String>();
    l.add(s);
    demons(0, f, s, l);
    return f;
  }
  public boolean palindromeC(List<String> wassup)
  {
    for(int i=0; i<wassup.size(); i++)
    {
      if(wassup.get(i)=="")return false;
      String slay = wassup.get(i);
      for(int j=0; j<=(slay.length()-1)/2; j++)
      {
        if(slay.charAt(j)!=slay.charAt(slay.length()-1-j))
        {
          return false;
        }
      }
    }
    return true;
  }
  public void demons(int id, List<List<String>> fs, String s, List<String> ds)
  {
    List<String> sup = new ArrayList<String>(ds);
    for(int i=id; i<s.length(); i++)
    {
        if(!sup.isEmpty()){sup.remove(sup.size()-1);}
        sup.add(s.substring(id,i+1));
        sup.add(s.substring(i+1,s.length()));
        demons(i+1,fs,s,sup);
        sup.remove(sup.size()-1);
        sup.remove(sup.size()-1);
        sup.add(s.substring(id,s.length()));
    }
    if(palindromeC(sup)){fs.add(sup);}
  }
}
