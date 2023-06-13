//Program to rotate a two-dimensional matrix  by usin in-place Algorithm
import java.util.*;
class rotate
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows and coloumn");
        int rows = sc.nextInt();
        int matrix[][] = new int [rows][rows];
        System.out.println("Enter the elements");
        for(int i =0;i<rows;i++)
        {
            for(int j=0;j<rows;j++)
            matrix[i][j]=sc.nextInt();
        }
        System.out.println();
        print(matrix);
        mat(matrix);
        System.out.println();
        print(matrix);
        sc.close();
    }
    public static  void  mat(int matrix[][])
    {
    
        int n = matrix.length;
        for(int i = 0;i<(n/2+n%2);i++)
        {
            for(int j=0;j<n/2;j++)
            {
                int temp = matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-j-1];
                matrix[n-1-i][n-j-1]=matrix[j][n-1-i];
                matrix[j][n-1-i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
    public static  void print(int matrix[][])
    {

            for(int i = 0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix.length;j++)
                {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
          
        }
    }
