package AtOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yolin on 2018/1/16.
 */
public class LastRemaining {
    public static void main(String[] args) {

        int n = 1;
        int m = 2;
        System.out.println(LastRemaining_Solution(n, m));
    }

    private static int LastRemaining_Solution(int n, int m) {
        if (n==0)return -1;
        if (n==1)return 0;
        int[] a = new int[n];
       // System.out.println(Arrays.toString(a));
        int count = n;
        int k = 0;
        while (count > 0) {
            int i = 0, t = 0;
            while (i < m) {
                t = (i + k) % n;
                while (a[t % n] == -1) {
                    t++;
                    k++;
                }
              //  System.out.print(t % n + "\t");
                i++;
            }
            a[t % n] = -1;
            k = t;
            count--;
           // System.out.println("\n" + Arrays.toString(a) + "\t" + t);
        }
        //  System.out.println(k);
        return k % n;
    }
}
