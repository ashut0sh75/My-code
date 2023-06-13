import java.util.*;
public class reverse {
    public static void main(String[] args)
    {
        long start = System.nanoTime();
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        System.out.println(rev(num));
        long end = System.nanoTime();
        long exec = end - start;
        double inSeconds = (double)exec / 1_000_000_000.0;
        System.out.println("The program takes "+exec+" nanoseconds that is "+inSeconds+" seconds to execute.");     
    
        sc.close();
    }
    public static  int  rev(int x) {
        try{
        int sign = x<0?-1:1;
        x=Math.abs(x);
        StringBuilder sb = new StringBuilder(String.valueOf(x));
       int num = Integer.parseInt(sb.reverse().toString()); 
        if(sign ==-1)
            num=num*-1;
            return num;   

    }
    catch(NumberFormatException e)
    {
        return 0;
    }
     
}
}

