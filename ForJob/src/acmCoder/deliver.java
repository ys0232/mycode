
package acmCoder;

import java.util.Arrays;
import java.util.Scanner;

public class deliver {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            System.out.println(solve(n,m));

        }
    }
    private static int solve(int n,int m){
        if (m==0)return 0;
        int[][]dp=new int[n][m];
        dp[1][0]=1;dp[n-1][0]=1;
        for (int k=1;k<m;k++){
                for (int i=0;i<n;i++){
                    int t1=(i+1)%n>=0?(i+1)%n:(i+1)%n+n;
                    int t2=(i-1)%n>=0?(i-1)%n:(i-1)%n+n;
                    dp[i][k]=dp[t1][k-1]+dp[t2][k-1];
                }
        }
        for (int i=0;i<n;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][m-1];
    }

}
