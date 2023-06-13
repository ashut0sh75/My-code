/*Program to calculate power by bit manipulation method */
import java.util.*;
public class power_effi {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int base = sc.nextInt();
		int power = sc.nextInt();
		int ans = 1;
		while (power > 0){
			if ((power&1)==1){
			// if == 0 there is no point to calculate ans
				ans = ans * base;
			}
			base = base * base;
			// keep dividing power by 2 using right shift
			power = power >> 1;
		}
		System.out.println(ans);
		sc.close();
	}
}
