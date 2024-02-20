import java.util.*;
import java.io.*;
import java.math.*;

class Test {

    public static int connectedCell(int[][] matrix) {
        int max = 0;
        for (int i=0; i< matrix.length;i++) {
                for (int j=0; j< matrix[0].length;j++) {
                        if(matrix[i][j] == 1) {
                                int curMax = helper(i, j, matrix);
                                max = Math.max(curMax, max);
                        }
                }
        }
        return max;
}

private static int helper(int i, int j, int[][] matrix) {
if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j]==0) {
return 0;
}
int count = 0;
if (matrix[i][j]==1) {
count = 1;
matrix[i].set(j, 0);
count += helper(i-1, j-1, matrix);
count += recurCountConnected(i-1, j, matrix);
count += (i-1, j+1, matrix);
count += helper(i, j-1, matrix);
count += helper(i, j, matrix);
count += helper(i, j+1, matrix);
count += recurCountConnected(i+1, j-1, matrix);
count += recurCountConnected(i+1, j, matrix);
count += helper(i+1, j+1, matrix);
}
return count;

}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of test cases");
        int test = sc.nextInt();

        System.err.println("Enter the rows and columns of matrix");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];

    System.err.println("Enter the  elements in matrix");
        for(int i  = 0;i<m;i++) {
            for(int j = 0; j<n;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
            connectedCell(matrix);
        
    }
}