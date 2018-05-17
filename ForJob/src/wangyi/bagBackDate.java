package wangyi;

import java.util.Scanner;

public class bagBackDate {
    private static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            count=0;
            int n = sc.nextInt();
            int w = sc.nextInt();
            int[] v = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt();
                sum += v[i];
            }
            if (sum <= w) {
                System.out.println((int) Math.pow(2, n));
            }else {
                dfs(0,0,n,v,w);
                System.out.println(count+1);
            }

        }
    }
    private static void dfs(long sum,int cur,int n,int[] v,int w) {
        //backdate
        if (cur >= n || (cur<n && sum>w)){
            return;
        }
        dfs(sum,cur+1,n,v,w);//not add in bag
        sum+=v[cur];
        if (sum<=w){
            count++;
            dfs(sum,cur+1,n,v,w);//add in bag
        }
    }
}
