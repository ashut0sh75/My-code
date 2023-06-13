/*Given a binary string S consists only of 0s and 1s. The task is to calculate the number of substrings that have more 1s than 0s.

Example 1:

Input:
S = "011"
Output: 4
Explanation: There are 4 substring which 
has more 1s than 0s. i.e "011","1","11" and "1"

Example 2:

Input:
S = "0000"
Output: 0
Explanation: There is no substring
which has more 1s than 0s
 */

import java.util.*;
import java.io.*;

class count_the_substring {
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    } 

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of test cases ");
        FastReader sc = new FastReader();        
        PrintWriter out = new PrintWriter(System.out);
        int testcases = sc.nextInt();
        System.out.println("Enter all  the test cases ");
        while (testcases-- > 0) {
            String S = sc.next();
            Solution ob = new Solution();
            System.out.println("Answer of each  test case is ---> ");
            long ans = ob.countSubstring(S);
            out.println(ans);
        }
        out.flush();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long countSubstring(String S){
        
       long count =0, numOfZeros=0;
       int zeroIndex=S.length();
       
       int freq[]=new int[2*S.length()+5];
       
       int currc=zeroIndex;
       
       for(int i=0;i<S.length();i++)
       {
           if(S.charAt(i)=='0') 
           currc--;
           else
           currc++;
           
           if(currc<=zeroIndex)
           numOfZeros++;
           
           freq[currc]++;
       }
       
       for(int i=0;i<S.length();i++)
       {
          count+=(S.length()-i-numOfZeros)*1l;
          
          if(S.charAt(i)=='1')
          {
              freq[zeroIndex+1]--;
              zeroIndex++;
              numOfZeros+=freq[zeroIndex];
          }
          else
          {
              freq[zeroIndex-1]--;
              zeroIndex--;
              numOfZeros--;
              numOfZeros-=freq[zeroIndex+1];
          }
       }
       return count;
    }
}






















