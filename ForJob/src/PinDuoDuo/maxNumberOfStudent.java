package PinDuoDuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yolin on 2018/3/16.
 */
public class maxNumberOfStudent {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] h=new int[n];
            for (int i=0;i<n;i++)
                h[i]=sc.nextInt();
            int m=sc.nextInt();
            int[] w=new int[m];
            for (int i=0;i<m;i++)
                w[i]=sc.nextInt();
            int count=0;
            Arrays.sort(w);
            Arrays.sort(h);
            for (int i=0;i<w.length;i++){
                for (int j=0;j<h.length;j++){
                 if (h[j]<=w[i]){
                     h[j]=Integer.MAX_VALUE;
                     count++;
                     break;
                 }
                }
                if (count==h.length)
                    break;
            }
            System.out.println(count);
        }
    }
}
