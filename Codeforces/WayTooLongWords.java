import java.util.*;

public class WayTooLongWords 
{
    public static void main(String[] args)
    {
        Scanner myobj = new Scanner(System.in);
        int input = myobj.nextInt();
        for(int i=0; i<=input; i++)
        {
            String np = myobj.nextLine();
            String ans = "";
            if(np.length()>10)
            {   
                ans+=np.charAt(0);
                ans+=Integer.toString(np.length()-2);
                ans+=np.charAt(np.length()-1);
            }
            else
            {
                ans=np;
            }
            System.out.println(ans);
        }
        myobj.close();
    }
}
