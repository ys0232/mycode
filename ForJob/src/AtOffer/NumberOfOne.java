package AtOffer;

import java.util.Arrays;

/**
 * Created by yolin on 2018/1/14.
 *
 * public class Solution {
 *    public int NumberOf1(int n) {
 *       int count = 0;
 *       while (n != 0) {
 *           count++;
 *          n = n & (n - 1);
 *     }
 *     return count;
 *        }
 *  }
 *
 */
public class NumberOfOne {
    public static void main(String[] args) {
        int n = -2147483648;
        System.out.println(NumberOf1(n));
    }

    private static int NumberOf1(int n) {
        int Num = 32;
        int[] a = new int[Num];
        if (n < 0) {
            n = Math.abs(n);
            a[Num - 1] = 1;
        } else if (n == 0) return 0;
        int k = 0;
        while (n != 0) {
            a[k] = Math.abs(n % 2);
           // System.out.println(Arrays.toString(a) + "\t" + n % 2+"\t"+n);
            n /= 2;
            k++;

        }
        // System.out.println(Arrays.toString(a));
        if (a[Num - 1] == 1) {
            int carry = 1;
            for (int i = 0; i < Num - 1; i++) {
                a[i] = 1 - a[i] + carry;
                if (a[i] > 1) {
                    a[i] = 0;
                    carry = 1;
                } else carry = 0;
            }
        }
        //System.out.println(Arrays.toString(a));
        int count = 0;
        for (int i = 0; i < Num; i++) {
            if (a[i] == 1) count++;
        }
        return count;
    }
}
