import java.io.IOException;
import java.util.*;

class solution {

    public  void  missing(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i && arr[arr[i]] == arr[i]) {
                System.out.println(arr[i]);
                arr[arr[i]] = i;
            }
        }
    }

    public static void main(String[] args)throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i=0;i<n;i++)
           a[i] = sc.nextInt();

           solution ob = new solution();
        ob.missing(a);
        sc.close();
    
    }
}