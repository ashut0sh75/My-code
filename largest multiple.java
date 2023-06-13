import java.util.Scanner;

 class largest_multiple {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        largest_multiple ob = new largest_multiple();
        int arr[][]=new int [20][20];
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            arr[i][j]=sc.nextInt();
            int row = ob.rowmax(arr);
            int col= ob.colmax(arr);
            int  dig = ob.digmax(arr); 
            System.out.println(Math.max(Math.max(row,col),dig));
        }
        sc.close();
    }
    int rowmax(int a[][])
    {
        int multi=1;
        int max=0;
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<15;j++)
            {
                for(int k=j;k<4+j;k++)
                {
                    multi*=a[i][k];
                }
                max=Math.max(multi,max);
            }
        }
return max;
    }
    int colmax(int a[][])
    {
        int multi=1;
        int max=0;
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<15;j++)
            {
                for(int k=j;k<4+j;k++)
                {
                    multi*=a[k][i];
                }
                max=Math.max(multi,max);
            }
        }
return max;
    }
    int digmax(int a[][])
    {
       int  multi=1;
        int max=0;
        for(int i=0;i<16;i++)
        {
            for(int j=i;j<4+i;j++)
            {
multi*=a[j][j];
            }
            max= Math.max(max,multi);
        }
return max;
    }
    
}
