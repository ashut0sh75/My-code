
import java.util.HashSet;
import java.util.Scanner;

class GFG{

// Function to return the length
// of the longest sub-array
static int longestSubarray(int arr[], int n,   int k)
{
    int i, j, Max = 1;

    // Initialize set
    HashSet<Integer> s = new HashSet<Integer>();

    for(i = 0; i < n - 1; i++)
    {
        
        // Store 1st element of
        // sub-array into set
        s.add(arr[i]);

        for(j = i + 1; j < n; j++)
        {
            
            // Check absolute difference
            // between two elements
            if (Math.abs(arr[i] - arr[j]) == 0 ||
                Math.abs(arr[i] - arr[j]) == k)
            {
                
                // If the new element is not
                // present in the set
                if (!s.contains(arr[j]))
                {
                    
                    // If the set contains
                    // two elements
                    if (s.size() == 2)
                        break;

                    // Otherwise
                    else
                        s.add(arr[j]);
                }
            }
            else
                break;
        }
        if (s.size() == 2)
        {
            
            // Update the maximum
            // length
            Max = Math.max(Max, j - i);

            // Remove the set
            // elements
            s.clear();
        }
        else
            s.clear();
    }
    return Max;
}

// Driver Code
public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
int arr[]=new int[N];
    for(int i=0;i<N;i++)
    arr[i]=sc.nextInt();
    int K = 1;
    int length = longestSubarray(arr, N, K);

    if (length == 1)
        System.out.print(-1);
    else
        System.out.print(length);
        sc.close();
}
}
