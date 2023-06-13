class divi
{
  
    
  public static void main(String args[])
    {
        long a=(long)Math.pow(2,999);
        int c=0;
        for(int i=1;i<=a;i++)
        {
            if(a%i==0)
            c++;
        }
            System.out.println(c);
        
    }
}
