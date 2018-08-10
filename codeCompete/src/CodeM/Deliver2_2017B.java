package CodeM;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class deliver{
    int s,t,l,r;

    public deliver(int s, int t, int l, int r) {
        this.s = s;
        this.t = t;
        this.l = l;
        this.r = r;
    }
}

public class Deliver2_2017B {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();int m=sc.nextInt();
        int q=sc.nextInt();
        int[][] edge=new int[m][3];
        for (int i=0;i<m;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
            edge[i][2]=sc.nextInt();
        }
        deliver[] D=new deliver[q];
        int max_time=0;
        for (int i=0;i<q;i++){
            int s=sc.nextInt();int t=sc.nextInt();
            int l=sc.nextInt();int r=sc.nextInt();
            D[i]=new deliver(s,t,l,r);
            max_time=max_time>r?max_time:r;
        }
        int cur_i=1;
        int[][] dp=new int[q+1][max_time];
        for (int i=1;i<q;i++){
            int dis=
            dp[i][D[i-1].r]=Math.max(1,dp[i-1][D[i-1].r]);
            cur_i=D[i-1].t;
            for (int j=i+1;j<=q;j++){

                if (D[j-1].l>=D[i-1].r){

                }
            }

        }



    }
    private static int getDist(int[][] dist,int cur_i,int end_i){


        return 0;
    }
}
