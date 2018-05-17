package DynamicProgrammingDemo;


import java.util.Arrays;
import java.util.Scanner;

public class NumOfSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            long[][] res = new long[n][sum + 1];
            int j = 0;
            while (j<n && a[j] > sum) {
                j++;
            }
            System.out.println(Arrays.toString(a));
            if (j<n)
            res[j][a[j]] = 1;
            for (int i = j + 1; i < n; i++) {
                for (int k = 0; k < sum + 1; k++) {
                    if (k >= a[i])
                        res[i][k] = res[i - 1][k] + res[i - 1][k - a[i]];
                    else res[i][k] = res[i - 1][k];
                }
                if (a[i] <= sum)
                    res[i][a[i]] = res[i - 1][a[i]] + 1;
            }
            System.out.println(res[n - 1][sum]);
        }
    }
}
