package Tencent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class funnyNumbers {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            HashMap<Integer,Integer> count=new HashMap<>();
            int n=sc.nextInt();
            int[] a=new int[n];
            int min=Integer.MAX_VALUE;
            int max=0;boolean flag=false;
            for (int i=0;i<n;i++){
                a[i]=sc.nextInt();
                if (min>a[i]){
                    min=a[i];
                }
                if (max<a[i]){
                    max=a[i];
                }
                if (count.containsKey(a[i])){
                    int t=count.get(a[i])+1;
                    count.put(a[i],t);
                    flag=true;
                }else count.put(a[i],1);
            }
            Arrays.sort(a);
            int maxDiff=max-min;
            int res_max=count.get(max)*count.get(min);
            int res_min=0;
            if (flag){
                min=0;
            }
            if (maxDiff==0){
                res_max=n*(n+1)/2;
                System.out.println();
            }
            for (int i=n-1;i>0;i--){
                int diff=a[i]-a[i-1];
                if (diff<min){
                    min=diff;
                    res_min=1;
                }else if (diff==min)
                    res_min++;
            }
            if (min==0){
                res_min=(res_min+1)*res_min/2;
            }
            System.out.println(res_min+" "+res_max);
        }
    }
}
