import java.util.*;

public class watermelon 
{
    public static String ans(int val)
    {
        if(val%2==0&&val!=2)return "YES";
        return "NO";
    }
    public static void main(String[] args)
    {
        Scanner myobj = new Scanner(System.in);
        int input = myobj.nextInt();
        System.out.println(ans(input));
        myobj.close();
    }
}