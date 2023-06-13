//Divide the number without using divide , mod, or multiply
import java.util.Scanner;
class INT_Divide
 {
   public static  int divide(int dividend, int divisor)
    { 
        if(dividend == Integer.MIN_VALUE && divisor == -1)            
            return Integer.MAX_VALUE ;
        boolean sign = (dividend < 0) ^(divisor < 0)  ;
        int ans = 0 ;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend - divisor >= 0)
        {
            int j = 0 ;
            while(dividend - (divisor << j << 1) >= 0)
                j++;
            ans += 1 << j ;
            dividend -= divisor << j ;
        }
        return sign ? -ans : ans ;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();
        System.out.println(divide(dividend,divisor));
        sc.close();
    }
}