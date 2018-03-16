package solveAtNiuKe;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yolin on 2018/3/7.
 */
public class minMaxSub {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++){
         a[i]=sc.nextInt();
        }
       // while (sc.hasNext()){}
        int[] res=minMax(a);
       System.out.println(res[0]+"\t"+res[1]);
    }
    private static int[] minMax(int[] a){
        int[] res=new int[2];
        if (a.length<1)return res;
        Arrays.sort(a);
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int j=a.length-1;
        for (int i=0;i<j;i++,j--){
            if (a[j]-a[i]>=max){
                max=a[j]-a[i];
                res[1]+=1;
            }
            if (Math.abs(a[j]-a[i])<min){
             min=Math.abs(a[j]-a[i]);
             res[0]=1;
            }else if (Math.abs(a[j]-a[i])==min){
                res[0]++;
            }

        }
        return res;
    }
}
