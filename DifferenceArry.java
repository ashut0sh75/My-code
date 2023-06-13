import java.util.Scanner;  

public class DifferenceArry  
{  
    public static void main(String[] args)  
    {  
        int n;  
  
        //It creates scanner object  
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter the array elements:" );  
        n=sc.nextInt();  
  
        int arr[]=new int[n];  
  
        for(int i=0;i<arr.length;i++)  
        {  
            System.out.print("Enter ["+(i+1)+"] element :" );  
            arr[i]=sc.nextInt();  
        }  
  
        TestArray obj=new TestArray();  
        System.out.println("Maximum value in the array is :" +obj.MAX(arr));  
        System.out.println("Minimum value in the array is :" +obj.MIN(arr));  
        int diff=obj.MAX(arr)-obj.MIN(arr);  
        System.out.print("Difference between max and min elements is : " +diff );     
        sc.close();
    }  
}  