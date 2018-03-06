package AtOffer;

import java.awt.*;

/**
 * Created by yolin on 2018/3/6.
 */
public class findNumsAppearOnce {

    public static void main(String [] args)
    {
        int[] a1=new int[1];
        int[] a2=new int[1];
        int[] a={1,2,2,3,4,4,1,3,5,7,7,9,9,8};
        FindNumsAppearOnce(a,a1,a2);
        System.out.println(a1[0]+"\t"+a2[0]);

    }
    private static void FindNumsAppearOnce(int[] array,int num1[],int num2[]){
        if (array.length<2)return;
        int len=array.length;
        int temp=array[0];
        for (int i=1;i<len;i++)
            temp^=array[i]; // xor  ==> 0 ^ 1 = 1 , 1 ^ 1 = 0 ,0 ^ 0 = 0
            if (temp == 0) return;
            int index=0;
            while ((temp & 1)==0){
                temp=temp>>1;
                ++index;
            }
            num1[0]=num2[0]=0;
        for (int i=0;i<len;i++){
            if (IsBit(array[i],index))
            num1[0]^=array[i];
            else num2[0]^=array[i];
        }
    }
    private static boolean IsBit(int num,int index){
        num=num>>index;
        return (num & 1)==1;
    }
}
