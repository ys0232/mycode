package AtOffer;

/**
 * Created by lenovo on 2018/1/14.
 */
public class RotateMinimum {
    public static void main(String[] args){
    int[] a={1,2,3,4,0,1,1};
    System.out.println(minNumberInRotateArray(a)+"\t"+minNumberInRotateArrayBetter(a));
    }

    public static int minNumberInRotateArray(int [] array) {
        if (array.length==0){
            return 0;
        }
         int i;
        for (i=1;i<array.length;i++){
           // System.out.println(array[i]);
            if ((array[i]-array[i-1])<0){
             break;
            }
        }
        return array[i];
    }
   private static int minNumberInRotateArrayBetter(int [] array){
        if (array.length==0)return 0;
        int low=0,high=array.length-1;
        while (low<high){
            int mid=(high+low)/2;
            System.out.println(array[mid]+"\t"+array[high]+"\tlow: "+low+"\tmid: "+mid+"\thigh: "+high);
           if (array[mid]<array[high]){
                high=mid;
            }else if (array[mid]>array[high])
                low=mid+1;
           else high--;
        }
        return array[high];
    }
}
