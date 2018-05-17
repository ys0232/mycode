package testForJob;

import java.util.Arrays;
import java.util.Scanner;

public class takeATaxi {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int s=sc.nextInt();
            int[] p=new int[n];
            for (int i=0;i<n;i++)
                p[i]=sc.nextInt();
            Arrays.sort(p);
            int sum=0;int count=0;
            int i=0,j;
            for (;i<n;i++){
               if (sum>=s)break;
                if (sum<s){
                    sum+=p[i];
                    count++;}
            }
            if (i<=n)
            for (j=i-1;j>=0;j--){
                if (sum-p[j]>=s){
                    sum-=p[j];
                    count--;
                }
            }
            System.out.println(count);
        }
    }
}
