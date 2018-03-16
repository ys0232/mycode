package base;

import java.util.Arrays;

/**
 * Created by yolin on 2018/3/14.
 */
public class BubbleSort {
    public static void main(String [] args){
        int[] a={3,7,8,9,1,5,2,4,6};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
    private static void bubbleSort(int[] a){
        for (int i=0;i<a.length;i++){
            for (int j=a.length-1;j>0;j--){
                if (a[j]<a[j-1]){
                    int t=a[j];
                    a[j]=a[j-1];
                    a[j-1]=t;
                }
            }
        }
    }
}
