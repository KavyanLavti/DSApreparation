import java.util.Scanner;

public class football 
{
    public static void main(String[] args)
    {
        Scanner myobj = new Scanner(System.in);
        String input = myobj.nextLine();
        String[] zero = input.split("1");
        String[] one = input.split("0");

        boolean ans = true;
        for(int i=0; i<zero.length; i++)
        {
            if(zero[i].length()>=7)ans=false;
        }
        for(int i=0; i<one.length; i++)
        {
            if(one[i].length()>=7)ans=false;
        }

        if(!ans)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
        myobj.close();
    }
}
