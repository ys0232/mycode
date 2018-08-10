package CodeM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class coca {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        //int[][] happy=new int[k][2];
        int ans=-1;
        long res=Long.MIN_VALUE;
        for (int i=0;i<k;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            long tem=m*a+(n-m)*b;
            if (res<=tem){
                //get the last result.
                res=tem;
                ans=i;
            }
        }
        for (int i=0;i<k-1;i++){
            if (i==ans)
            System.out.print(n+" ");
            else System.out.print(0+" ");
        }
        if (k-1==ans)
            System.out.println(n);
        else System.out.println(0);

    }
}
