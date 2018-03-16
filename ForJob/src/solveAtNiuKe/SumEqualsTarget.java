package solveAtNiuKe;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yolin on 2018/3/8.
 */
public class SumEqualsTarget {
    public static void main(String [] args){
        // test case : n  target array 5 15 5 5 10 2 3
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(TargetSum(a,target));

    }
    private static int TargetSum(int[] a,int target){
        //回溯
      int res=0;
        int m=a.length;
        int count=1;
        int n=m;
        int[] b=new int[n];
        while(m-->0){
            count*=2;
        }
        while(count-->0)
        {
            for(int i=0;i<n;i++)
            {
                if(0==b[i])
                    b[i]=1;
                else
                {
                    b[i]=0;
                    break;
                }
            }
            int sum = 0;
            for(int i=0;i<n;i++)
            {
                if(b[i]==1)sum+=a[i];
            }
            if (sum==target){
            res++;
            for (int k=0;k<n;++k){
                if (b[k]==1){
                    System.out.print(a[k]+"\t");
                }
            }
                System.out.println();
            }
        }



            return res;
    }
}
