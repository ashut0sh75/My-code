
import java.util.*;

public class Sol {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); 
        
    int[] primes = new int[10001];
    int ncounter = 0;
    int isPrime = 2;

    while (ncounter < 10001) {
        boolean prime = true;
        for (int j=2; j<isPrime; j++){
            if (isPrime%j ==0){
                prime = false;
                break;
            }
        }
        if (prime){
            primes[ncounter] = isPrime;
            ncounter++;
        }
        isPrime++;
    }
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(primes[n-1]);
           
        }      
        in.close();
    }
}