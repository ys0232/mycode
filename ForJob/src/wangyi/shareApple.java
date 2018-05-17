package wangyi;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class shareApple {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] a=new int[n];
            int sum=0;
            for (int i=0;i<n;i++){
                a[i]=sc.nextInt();
                sum+=a[i];
            }
            System.out.println(solve(a,sum));
        }
    }
    private static int solve(int[] a,int sum){
        int n=a.length;
        int t=sum/n;int res=0;
      //  System.out.println(t);
        if (sum!=t*n)return -1;
        for (int i=0;i<n;i++){
            int temp=a[i]-t;
            if (temp<0){
                if (-1*temp%2!=0)return -1;
               // res+=-1*temp/2;
            }else {
                if (temp%2!=0)return -1;
                res+=temp/2;
            }
        }

        return res;
    }
}
