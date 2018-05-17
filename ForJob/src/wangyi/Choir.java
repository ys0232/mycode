package wangyi;


import java.util.Arrays;
import java.util.Scanner;

public class Choir {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] a=new int[n+1];
            for (int i=1;i<=n;i++)
                a[i]=sc.nextInt();
            int k=sc.nextInt();
            int d=sc.nextInt();
            long max=Long.MIN_VALUE;
            long[][] cnt_max=new long[k+1][n+1];
            long[][] cnt_min=new long[k+1][n+1];
            for (int i=1;i<=n;i++){
                cnt_max[1][i]=a[i];
                cnt_min[1][i]=a[i];
                for (int p=2;p<=k;p++){
                    for (int j=i-1;j>0&&i-j<=d;j--){
                        cnt_max[p][i]=Math.max(Math.max(cnt_max[p][i],
                                cnt_max[p-1][j]*a[i]),cnt_min[p-1][j]*a[i]);
                        cnt_min[p][i]=Math.min(Math.min(cnt_min[p][i],
                                cnt_max[p-1][j]*a[i]),cnt_min[p-1][j]*a[i]);

                    }
                }
                if (max<cnt_max[k][i]){
                    max=cnt_max[k][i];
                }
            }
            System.out.println(max);
        }

    }
}
