package acmCoder;

import java.util.Arrays;
import java.util.Scanner;

public class draw {
    public static void main(String[] args){
        //Scanner sc=new Scanner(System.in);
        int n=3;int m=9;int c=4;
        int[] a={1,3,5};
        int[][] dp=new int[c][m+1];
        for (int i=0;i<n;i++)
            dp[0][a[i]]=1;
        System.out.println(Arrays.toString(dp[0]));

        for (int i=1;i<c;i++){
            for (int j=0;j<n;j++){
                for (int k=0;k<m+1;k++)
                    if (k>a[j]&&dp[i-1][k-a[j]]!=0){
                        dp[i][k]=1;
                    }
               // System.out.println(Arrays.toString(dp[i]));
            }
        }
        if (dp[c-1][m]==1)System.out.println("YES");
        else System.out.println("NO");

    }
}
