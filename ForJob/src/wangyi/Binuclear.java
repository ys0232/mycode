package wangyi;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Binuclear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int Num = 1024;
            int sum = 0;
            double max = 0;
            DecimalFormat df = new DecimalFormat("0");
            for (int i = 0; i < n; i++) {
                long t = sc.nextLong();
                String temp = df.format(t / Num);
                a[i] = Integer.valueOf(temp);
                sum += a[i];
                if (max < a[i]) {
                    max = a[i];
                }
            }

            if (max >= sum / 2.0) {
                System.out.println(df.format(max * Num));
            } else {
                int t = sum / 2 + 1;
                double[] dp = new double[t];
                for (int i = 0; i < n; i++) {
                    for (int j = t - 1; j >= a[i]; j--) {
                        String mp = String.valueOf(df.format(j - a[i]));
                        dp[j] = Math.max(dp[Integer.valueOf(mp)] + a[i], dp[j]);

                    }
                }
               /* for (int i=0;i<n;i++)
                    System.out.println(Arrays.toString(dp[i]));*/
                System.out.println(sum / 2.0 + "\t" + (sum - dp[t - 1]));
                int res = Integer.valueOf(df.format(sum - dp[t - 1]));
                System.out.println(df.format(Num * res));
            }
        }
    }
}
