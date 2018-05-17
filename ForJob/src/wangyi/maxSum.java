package wangyi;

import java.util.Scanner;

public class maxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            long max = Long.MIN_VALUE;
            for (int i = 0; i < n ; i += 1) {
                for (int j = 0; j < n ; j += 1) {
                    //long max_t=Long.MIN_VALUE;
                    long t1 = 0, t2 = 0, t3 = 0, t4 = 0;
                    int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
                    for (int k = 0; k < d; k++) {
                        if (j + k < n) {
                            c1 += 1;
                            t1 += a[i][j + k];
                        }//rows
                        if (i + k < n) {
                            c2 += 1;
                            t2 += a[i + k][j];//colums
                        }
                        if (i + k < n && j + k < n) {
                            c3 += 1;
                            t3 += a[i + k][j + k];//slope
                        }
                        if (i - k >=0 && j + k < n) {
                            c4 += 1;
                            t4 += a[i - k][j + k];
                        }

                    }
                    if (c1 == d) {
                        max = max > t1 ? max : t1;
                    }
                    if (c2 == d) {
                        max = max > t2 ? max : t2;
                    }
                    if (c3 == d) {
                        max = max > t3 ? max : t3;
                    }
                    if (c4 == d) {
                        max = max > t4 ? max : t4;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
