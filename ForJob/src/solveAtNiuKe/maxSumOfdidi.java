package solveAtNiuKe;

import java.util.Scanner;

/**
 * Created by yolin on 2018/3/8.
 */
public class maxSumOfdidi {
    public static void main(String [] args){

        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] a=new int[n];
            for (int i=0;i<n;i++)
                a[i]=sc.nextInt();
            System.out.println(MaxSum(a));
        }
    }
    private static int MaxSum(int[] a){
        int sum=Integer.MIN_VALUE;
        int temp=0;
        for (int i=0;i<a.length;i++){
            temp+=a[i];
            if (temp>sum){
                sum=temp;
            }
            if (temp<0){
                temp=0;
            }
        }
        return sum;
    }
}
