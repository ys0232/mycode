package CodeM;

import java.util.Scanner;

public class musicology_2017 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int len1=sc.nextInt();
            int[] a=new int[len1];
            //int[] a_diff=new int[len1];
            for (int i=0;i<len1;i++){
                a[i]=sc.nextInt();
                //if (i>0)
                //a_diff[i]=a[i]-a[i-1];
            }
            int len2=sc.nextInt();
            int[] b=new int[len2];

            for (int i=0;i<len2;i++){
                b[i]=sc.nextInt();
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len2 - len1; i++) {
                int sum = 0;
                int k = i;
                for (int j = 0; j < len1; j++) {
                    sum += (a[j] - b[k]) * (a[j] - b[k]);
                    k++;
                }
                if (min > sum) {
                    min = sum;
                }
            }
            System.out.println(min);
        }
    }
}
