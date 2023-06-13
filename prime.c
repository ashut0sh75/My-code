#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

long Prime(long n)
{
    long flag=0;
    for(long i= 1;i<=n;i++)
    {
        if(n%i==0)
            flag++;
    }
    if(flag==2)
        return n;
    else 
        return 0;
}
long Sum(long num)
{
    long sum = 0;
    for(long j =1;j<=num;j++)
    {
        long u = Prime(j);
        sum+=u;
    }
    return sum;
}
int main() {
long T ;
    long result;
    scanf("%ld",&T);
    while(T--)
    {
        long num;
        scanf("%ld",&num);
         result = Sum(num);
        printf("%ld\n",result);
    }
    
    return 0;
}
