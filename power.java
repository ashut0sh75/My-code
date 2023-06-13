 import java.util.Scanner;
 class   power {
    static int findPowerPrime(int fact, int p)
    {
        int res = 0;
        while (fact > 0) {
            res += fact / p;
            fact /= p;
        }
 
        return res;
    }
    static int findPowerComposite(int fact, int n)
    {
        int res = Integer.MAX_VALUE;
        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            int count = 0;
            if (n % i == 0)
            {
                count++;
                n = n / i;
            }
 
            if (count > 0)
        {
                int curr_pow = findPowerPrime(fact, i) / count;
                res = Math.min(res, curr_pow);
            }
        }
 
        if (n >= 2) {
            int curr_pow = findPowerPrime(fact, n);
            res = Math.min(res, curr_pow);
        }
 
        return res;
    }
    public static void main(String[] args)
    {
        int fact  , n ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the factorial number");
        fact = sc.nextInt();
        System.out.println("Enter the number");
        n=sc.nextInt();

        System.out.println(findPowerComposite(fact, n));

        sc.close();
    }
}
 