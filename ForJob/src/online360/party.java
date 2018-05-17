package online360;

import java.util.Scanner;

public class party {
    static int res=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int t=sc.nextInt();
            while (t-->0){
                res=0;
                long r=sc.nextLong();
                long g=sc.nextLong();
                long b=sc.nextLong();
                solve(r,g,b,0);
                System.out.println(res);
            }

        }
    }
    private static void solve(long r,long g,long b,int cur){

        long[][] dp=new long[3][3];
        dp[0][0]=r;dp[0][1]=g;dp[0][2]=b;
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<3;j++){


            }
        }


    }
}
