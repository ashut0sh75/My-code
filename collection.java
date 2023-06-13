import java.util.Scanner;
class collection
{
    public static void main(String[]  args)
    {
        Scanner sc = new Scanner(System.in);
        int days,money;
        System.out.println("Enter the number of Days");
        days=sc.nextInt();
        System.out.println("Enter the money");
        money=sc.nextInt();
        System.out.println("Enter the expenditure");
        int exp=sc.nextInt();
        for(int i=1 ; i<=days;i++)
        {
            System.out.println("Day "+i+ "  "+(money-exp));
            money -=exp;
            if(money<=0)
            break;
            sc.close();
        }
    }

}