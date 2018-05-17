package wangyi;

import java.util.HashMap;
import java.util.Scanner;

public class shudui {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            if (k==0){
                System.out.println(n*n);
            }else System.out.println(calc(n,k));
        }
    }
    private static long calc(int n,int k){
        long res=0;
       for (int i=k+1;i<=n;i++){
           for (int j=k;j<=n;j++){
               int t=j%i;
               if (t>=k){
                   res+=i-t;
                   j+=i-1;
               }
               if (j>n && j-n>=k){
                   res-=j-n-k;
               }
           }
       }
       return res;
    }
}
