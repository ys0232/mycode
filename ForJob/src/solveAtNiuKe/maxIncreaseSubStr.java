package solveAtNiuKe;

import java.util.Arrays;

/**
 * Created by yolin on 2018/3/10.
 */
public class maxIncreaseSubStr {
    public static void main(String [] args){
        int[] a={10,4,5,12,8};
        System.out.println(MaxSubSum(a));
    }
    private static int MaxSubSum(int[] a){
       if (a.length<=0)
        return 0;
       int[] dp=new int[a.length];
       for (int i=0;i<a.length;i++){
           dp[i]=1;
           for (int j=0;j<i;j++){
              // System.out.println(i+"\t"+j+"\t"+a.length);
               if (a[j]<=a[i] && dp[j]+1>dp[i])
                   dp[i]=dp[j]+1;
           }
       }
       System.out.println(Arrays.toString(dp));

       return dp[dp.length-1];
    }
}
