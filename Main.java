import java.io.*;

import java.util.*;


public class Main {
    public static void main(String[] args)throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        long c[][] = binomialTable(101);
        long pS[][] = new long[101][(int)1e5+1];
        long pow[][] = new long[101][(int)1e5+1];
        Arrays.fill(pow[0], 1);
        while(t -- > 0) {
            int n = in.nextInt(), k = in.nextInt();
            int a[] =  new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            reverseArray(a);
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    pow[i][j] = (pow[i-1][j] * a[j]) % mod;
                }
            }

            for(int i = 0; i <= k; i++){
                pS[i][n] = 0;
                for(int j = n-1; j >= 0; j--){
                    pS[i][j] = pS[i][j+1] + pow[i][j] ;
                    if(pS[i][j] >= mod) pS[i][j] -= mod;
                }
            }
            long ans = 0;
            for (int p = 0; p <= k; p++) {
                for (int i = 0; i < n-1; i++) {
                    ans += (c[k][p] * ( (pow[k-p][i] * (pS[p][i+1])) % mod ) * (p % 2 == 0 ? 1 : -1) ) % mod;
                    ans = mod(ans, mod);
                }
            }

            ans = mod(ans*2, mod);

            pw.println(ans);

        }
        pw.close();
    }
    static void reverseArray(int a[]){
        for(int i = 0, j = a.length-1; i < j; i++, j--){
            int temp = a[i]; a[i] = a[j]; a[j] = temp;
        }
    }
    static long mod = (long)1e9+7;
    public static long[][] binomialTable(int n) {
        long[][] c = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= i; j++)
                c[i][j] = ((j == 0) ? 1 : c[i - 1][j - 1] + c[i - 1][j]) % mod;
        return c;
    }
    public static long mod(long a, long m) {
        long A =  (a % m);
        return A >= 0 ? A : A + m;
    }
    static long bigMod ( long a, long p, long m ) {
        long res = 1 % m, x = a % m;
        while ( p > 0 ) {
            if ( (p & 1) > 0 ) res = ( res * x ) % m;
            x = ( x * x ) % m; p >>= 1;
        }
        return res;
    }
    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;
        static final int ints[] = new int[128];

        public FastReader(InputStream is){
            for(int i='0';i<='9';i++) ints[i]=i-'0';
            this.is = is;
        }

        public int readByte(){
            if(lenbuf == -1)throw new InputMismatchException();
            if(ptrbuf >= lenbuf){
                ptrbuf = 0;
                try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
                if(lenbuf <= 0)return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
        public int skip() {
            int b;
            while((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next(){
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while(!(isSpaceChar(b))){
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
        public int nextInt(){
            int num = 0, b;
            boolean minus = false;
            while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if(b == '-'){
                minus = true;
                b = readByte();
            }

            while(true){
                if(b >= '0' && b <= '9'){
                    num = (num<<3) + (num<<1) + ints[b];
                }else{
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if(b == '-'){
                minus = true;
                b = readByte();
            }

            while(true){
                if(b >= '0' && b <= '9'){
                    num = (num<<3) + (num<<1) + ints[b];
                }else{
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        public char[] next(int n){
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while(p < n && !(isSpaceChar(b))){
                buf[p++] = (char)b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }
    }
}