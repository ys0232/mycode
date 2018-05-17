package DynamicProgrammingDemo;

import java.util.Arrays;

public class changCoin {
    public static void main(String [] args){
        int n=10;
        int[] a={1,2,5};
        int[] sum=new int[n+1];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<n+1;j++){
                if (j>=a[i] && sum[j]!=0){
                    sum[j]=Math.min(sum[j-a[i]]+1,sum[j]);
                }else if (j>=a[i]){
                    sum[j]=sum[j-a[i]]+1;
                }
            }
            System.out.println(Arrays.toString(sum));
        }
       // System.out.println(Arrays.toString(sum));
    }
}
