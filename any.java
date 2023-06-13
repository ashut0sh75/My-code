 import java.util.*;
 import java.io.*;
 class any
{
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    
    public void backtrack(int[]visited, int currsum, int n, ArrayList<Integer> temp, int prev){
        if(currsum==n){
            
            
            if(!arr.contains(new ArrayList<Integer>(temp))){
                arr.add(new ArrayList<Integer>(temp));
            }
            
            return;
        }    
        
        if(currsum>n){
            return;
        }
    
        for(int i=prev;i>=1;i--){
            temp.add(i);
            backtrack(visited,currsum+i,n, temp,i);
            temp.remove(temp.size()-1);
        }
    }
        
    
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        
        int[]visited = new int[n];
        backtrack(visited,0,n, new ArrayList<Integer>(),n);
        return arr;
    }
}
    class Soution
    {
    public static void main(String[] args)throws IOException
    {
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 int T = Integer.parseInt(br.readLine().trim());
  while(T-->0)
  {
 int n = Integer.parseInt(br.readLine().trim());
 any ob = new any();
 ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
 for(ArrayList<Integer>i: ans)
  for(int j : i)
  System.out.print(j+" ");
  System.out.println();

  }
    }
}