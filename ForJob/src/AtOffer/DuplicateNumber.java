package AtOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yolin on 2018/1/16.
 */
public class DuplicateNumber {
    public static void main(String [] args){
        int[] a={2,3,4,5,6,6,7,54,8,9};
        int[] a1=new int[1];
        int numbers[]={};
        System.out.println(Arrays.toString(numbers)+"\t"+duplicate(numbers,numbers.length,a1)+"\t"+a1[0]);
        System.out.println(Arrays.toString(a)+"\t"+duplicate(a,a.length,a1)+"\t"+a1[0]);

    }
    private static boolean duplicate(int numbers[],int length,int[] duplicate){
        int[] res=new int[length];
        duplicate[0]=-1;
        if (numbers==null || numbers.length<=1)return false;
        for (int i:numbers){
            if (res[i]==1){
                duplicate[0]=i;
                return true;
            }else res[i]++;
        }
        return false;
    }
}
