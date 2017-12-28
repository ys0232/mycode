package ACMTest;
import java.util.*;
public class AsArray {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            int[] dp = new int[n];
            int[][] path = new int[n][n];
            for (int i = 0; i < n; i++)
                dp[i] = 1;
            int k = 0;
            path[0][0] = a[0];
            for (int i = 1; i < n; i++) {
                k = 0;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        path[i][k++] = a[j];
                    }
                }
                path[i][k] = a[i];
            }
            int max = dp[0];
            for (int i = 0; i < n; i++) {
                if (max < dp[i]){
                    max = dp[i];
                k = i;}
            }
            System.out.println(" max length of ascend subarray" + max);
            System.out.println(Arrays.toString(path[k]));
            System.out.println(Arrays.toString(dp));
            for (int i = 0; i < n; i++)
                System.out.println(Arrays.toString(path[i]));
        }

    }
}
