package AtOffer;

import java.util.Arrays;

/**
 * Created by yolin on 2018/1/14.
 * use quick sort method can't keep relative order.
 */
public class ReOrderArray {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 6, 1, 8, 9, 7, 4, 0, 11};
        System.out.println(Arrays.toString(a));
      //  reOrderArrayUseQuickSort(a);
        reOrderArray(a);
    }

    private static void reOrderArrayUseQuickSort(int[] array) {

        int len = array.length;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 != 0) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
                k++;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void reOrderArray(int[] array) {
        int len=array.length;
        int k=0,p=0;
        int[] a=new int[len];
        for (int i=0;i<len;i++){
            if (array[i]%2!=0){
                array[k]=array[i];
                k++;
            }else {
                a[p]=array[i];
                p++;
            }
        }
        //System.out.println(Arrays.toString(a));
        p=0;
        for (int i=k;i<len;i++){
         array[i]=a[p];
         p++;
        }
        //System.out.println(Arrays.toString(array));
    }
}
