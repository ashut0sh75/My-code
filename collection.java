import java.util.*;
class collection
{
    public static void main(String[]  args)
    {
     Scanner sc = new Scanner(System.in);
     
     System.out.println("Enter the String");

     String s = sc.nextLine();
     int k = sc.nextInt();

   int[] freq = new int[26];

     for(char ch : s.toCharArray())
         freq[ch-'a']++;

       for(int i = 1;i<=k;i++) {
       
        Arrays.sort(freq );
       
        System.out.println(Arrays.toString(freq));
       
        freq[25]-=1;
       }

       Arrays.sort(freq);
       
       int sum = 0;
        
       for(int i : freq) {
          
        sum+=(i*i);
          
        if(i==0)
              break;
         }

    System.out.println(sum);

     sc.close();
        
    }
}