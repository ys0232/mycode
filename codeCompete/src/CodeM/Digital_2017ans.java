package CodeM;

import java.util.Scanner;

public class Digital_2017ans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            long[] a = new long[10];
            long[] b = new long[10];
            compute(a, left - 1);
            compute(b, right);
            for (int i = 1; i < a.length; i++) {
                System.out.println(b[i] - a[i]);
            }
        }
    }

    private static void compute(long[] a, int x) {
        for (int i = 1; i <= 9; i++) {   // i为约数y的最高位数字
            for (long j = 1; i * j <= x; j *= 10) { //构造以i为最高位数字的约数
                //约数y 从 [i*j,min((i+1)*j-1,x)],[1,1],[10,19],[100,199]...
                // 例如：[10,19](i=1,j=10,x>19)
                long start = i * j;
                long end = Math.min((i + 1) * j - 1, x);
                long slip;
                for (long y = start; y <= end; y += slip) {
                    long mul = x / y;  //[1,x]中能够整除y的个数为x/y
                    long remain = x - mul * y; //大于y却不能整除y的有remain个
                    //slip为在[start,end]区间中与y值具有相同mul的值的个数
                    slip = 1 + Math.min(remain / mul, end - y);
                    a[i] += mul * slip;
                }
            }
        }
    }
}
