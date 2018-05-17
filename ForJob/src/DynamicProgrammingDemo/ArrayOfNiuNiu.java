package DynamicProgrammingDemo;


import java.util.Arrays;
import java.util.Scanner;

public class ArrayOfNiuNiu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            int[] dp = new int[n];
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                if (a[j] > a[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 1;
                }
            }
            System.out.println(Arrays.toString(dp));











        }
    }
}
