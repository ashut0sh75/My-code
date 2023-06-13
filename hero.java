
import java.util.*;


public class hero{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            long num=in.nextLong();
            
String biStr = Long.toString(num);
int[] ints = new int[n];
for(int i=0; i<n; i++) 
    ints[i] = Integer.parseInt(String.valueOf(biStr.charAt(i)));
            int diff=n-k;
            System.out.println(Multiply(diff,ints,k));
        
        }
        in.close();
    }
    public static long Multiply(int d,int n[],int k)
    { 
        long multi=1;
        long max=0;
        for(int i= 0;i<(d+1);i++)
        {
            multi=1;
           for(int j=i;j<k;j++)
           {
               multi=multi*n[j];
           }
           max=Math.max(max,multi);
        
        }
        return max;
    }
}