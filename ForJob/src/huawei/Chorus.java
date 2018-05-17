package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Chorus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            //LongestIncreased(a);
            System.out.println(solve(a));
        }
    }

    private static int solve(int[] a) {
        int[] left=getLongestIncresed(a);
        reveser(a);
        int[] right=getLongestIncresed(a);
        reveser(right);
        System.out.println(Arrays.toString(left)+"\n"+Arrays.toString(right));
        int max=0;
        for (int i=0;i<a.length;i++){
            int t=(left[i]+right[i]);
            if (t>max){
                max=t;
            }
        }
        return a.length-max+1;
    }

    private static int[] getLongestIncresed(int[] a) {
        int[] res = new int[a.length];
        res[0] = 1;
        for (int k = 0; k < a.length; k++) {
            int[] dp = new int[k+1];
            dp[0] = 1;
            for (int i = 1; i<=k; i++) {
                dp[i]=dp[i-1];
                for (int j=0;j<i;j++){
                    if (a[j] < a[i] && a[i] <= a[k]) {
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
            }
            }
            //System.out.println(a[k]+"\t"+Arrays.toString(dp));
            res[k] = dp[k];
        }
        //System.out.println(Arrays.toString(res));
        return res;
    }
    private static void reveser(int[] a){
        int[] temp=a.clone();
        for (int i=0;i<a.length;i++){
            a[i]=temp[a.length-i-1];
        }
    }
    private static void LongestIncreased(int[] a){
        int[] dp=new int[a.length];
        dp[0]=1;
        for (int i=1;i<a.length;i++){
            dp[i]=dp[i-1];
            for (int j=0;j<i;j++){
                if (a[j]<a[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
