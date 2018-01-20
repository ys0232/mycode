package AtOffer;

import java.util.Arrays;

/**
 * Created by yolin on 2018/1/19.
 * DP
 */
public class GetUglyNumber {
    public static void main(String[] args){
        int n=1500;
        System.out.println("\n"+GetUglyNumber_Solution(n));

    }
    private static int GetUglyNumber_Solution(int index) {
        if (index==0)return 0;
        int[] a=new int[index];
        a[0]=1;int t2=0,t3=0,t5=0;int i=1;
       while (i<index){
            int minb=a[t2]*2<a[t3]*3?a[t2]*2:a[t3]*3;
            minb=minb<a[t5]*5?minb:a[t5]*5;
            if (minb==a[t2]*2){
                t2++;
            }
            if (minb==a[t3]*3){
                t3++;
            }
            if (minb==a[t5]*5){
                t5++;
            }
            a[i]=minb;i++;
        }
        System.out.println(Arrays.toString(a));
        return a[index-1];
    }
}
