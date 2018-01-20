package AtOffer;

/**
 * Created by lenovo on 2018/1/14.
 */
public class RotateMinimum {
    public static void main(String[] args){
    int[] a={3,4,5,1,2};
    System.out.println(minNumberInRotateArray(a));
    }

    public static int minNumberInRotateArray(int [] array) {
        if (array.length==0){
            return 0;
        }
         int i=0;
        for (i=1;i<array.length;i++){
            if ((array[i]-array[i-1])<0){
             break;
            }
        }
        return array[i];
    }
}
