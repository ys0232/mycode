package wangyi;

import java.util.ArrayList;
import java.util.Arrays;

public class shareBiscuits {
    public static void main(String[] args){
        String str="9999999999x";
        int n=3;
        System.out.println(share(str,n));

    }
    private static int share(String str,int n){
        //(a+b)mod n == (a mod n + b mod n)mod n
        int[][] dp=new int[str.length()+1][n];
        dp[0][0]=1;
        for (int i=1;i<str.length()+1;i++) {
            for (int j = 0; j < n; j++) {
                if (str.charAt(i-1) == 'x') {
                    for (int k = 0; k <= 9; k++) {
                        int t = (j*10+k)%n;
                        dp[i][t]+=dp[i-1][j];
                    }
                }else dp[i][(j*10+str.charAt(i)-'0')%n]+=dp[i-1][j];

            }
        }
        System.out.println(Arrays.toString(dp[str.length()]));
        return dp[str.length()][0];
    }
}
