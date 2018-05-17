package wangyi;

import java.util.Scanner;

public class NumPairs {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            if (k==0){
                long res=n;
                System.out.println(res*res);
            }else  System.out.println(solve(n,k));

        }
    }
    private static long solve(int n,int k){
        long res=0;
        for (int i=k+1;i<=n;i++){
            int j=n/i;
            res+=(i-k)*j;
            if (n%i>=k){
              res+= n%i-k+1;
            }
        }
        return res;
    }
}
