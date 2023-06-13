import java.util.*;
class prime
{
    static final int Max_Size = 1000001;
    static Vector<Boolean>isprime = new Vector<>(Max_Size);
    static Vector<Integer>prime = new Vector<>();
    static Vector<Integer>SPF = new Vector<>(Max_Size);
    static void manipulated(int num)
    {
        isprime.set(0,false);
        isprime.set(1,false);
        for(int i=2;i<num;i++)
        {
            if(isprime.get(i))
            {
                prime.add(i);
                SPF.set(i,i);
            }
            for(int j=0;j<prime.size() && i*prime.get(j)<num && prime.get(j)<=SPF.get(i);j++)
            {
                isprime.set(i*prime.get(j),false);
                SPF.set(i*prime.get(j),prime.get(j));
            }
        }
        
    }
    public static void main(String args [])
    {
        int Sum=0;
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        
        for(int i =0;i<Max_Size;i++)
        {
            isprime.add(true);
            SPF.add(2);
        }
       
        for(int j=0;j<t;j++)
        {
            int num=sc.nextInt();
            manipulated(num);
        for(int i=0;i<prime.size() && prime.get(i)<=num;i++)
        Sum+=prime.get(i);
        System.out.println(Sum);
        }
        sc.close();
    }
    
}