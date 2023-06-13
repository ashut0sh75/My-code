
#include <bits/stdc++.h>
using namespace std;
int findPowerPrime(int fact, int p)
{
	int res = 0;
	while (fact > 0) {
		res += fact / p;
		fact /= p;
	}
	return res;
}
int findPowerComposite(int fact, int n)
{
	int res = INT_MAX;
	for (int i = 2; i <= sqrt(n); i++) {

		// counter for count the
		// power of prime number
		int count = 0;
		while (n % i == 0) {
			count++;
			n = n / i;
		}

		if (count > 0) {
			int curr_pow = findPowerPrime(fact, i) / count;
			res = min(res, curr_pow);
		}
	}
	if (n >= 2) {
		int curr_pow = findPowerPrime(fact, n);
		res = min(res, curr_pow);
	}

	return res;
}
int main()
{
	int fact ,n;
	printf("Enter the factorial number\n");
	scanf("%d",&fact);
	printf("Enter the number\n");
	scanf("%d",&n);
	cout << findPowerComposite(fact, n);
	return 0;
}
