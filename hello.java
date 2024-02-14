import java.io.IOException;

class hello {

    public static int lo(int[] a, int key, int index) {
        if(index==-1)
         return -1;

         if(a[index]==key)
           System.out.println(index);

           return lo(a, key, index--);
    }

    public static void main(String[] args)throws IOException {
         int[] a={4, 3, 2, 1};

       try {
System.out.println(lo(a, 4, 3));
       }

       catch(Exception e) {
         System.out.println(e.getMessage());

       }
         
    }
}