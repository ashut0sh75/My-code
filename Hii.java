import java.util.*;

class Hii{

	public static void main(String args[])
	{
		Scanner sc = new Scanner (System.in);
		int S = sc.nextInt();
		int D = sc.nextInt();
		System.out.println(secondSmallest(S, D));
		sc.close();
	}
    static String secondSmallest(int S, int D){
        
        int start =(int) Math.pow(10, D-1);
        int count =0;
        
        while(start<Math.pow(10, D))
        {
            boolean res_sum = sumofdigits(start, S);
           
            if(res_sum == true && count==2)
            return Integer.toString(start);
            
            else if(res_sum==true){
            count++;
            start++;
            }
            
            else
            start++;
        
        }
       
        return "-1";
    }
    
  static boolean sumofdigits(int num, int sum)
    {
        int num_sum=0;
        while(num>0)
        {
          num_sum+=num%10;
          
          num/=10;
        }
        
        if(num_sum==sum)
        return true;
        
        else
        return false;
    }
    
}