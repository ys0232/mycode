package toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yolin on 2018/3/15.
 */
public class maxArraySum {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] a=new int[n];
            int k=0;
            while (n-->0){
                a[k++]=sc.nextInt();
            }
            Arrays.sort(a);
            k=0;
            for (int i=1;i<a.length;i++){
                if (a[k]!=a[i]){
                    a[++k]=a[i];
                }
            }
            k+=1;
            int[] sum=new int[k];
            sum[k-1]=a[k-1];
            int max=sum[k-1]*a[k-1];
            for (int i=k-2;i>=0;i--){
                sum[i]=sum[i+1]+a[i];
                if (sum[i]*a[i]>max){
                    max=sum[i]*a[i];
                }
                System.out.println(max+"\t"+sum[i]+"\t"+a[i]+"\t"+i);
            }
            System.out.println(max+"\t"+Arrays.toString(a)+"\t"+Arrays.toString(sum));

        }
    }

}
