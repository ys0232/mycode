package AtOffer;

/**
 * Created by yolin on 2018/1/19.
 */
public class GreatestSumOfSubArray {
    public static void main(String[] args){

        int[] a={1,2,-7,8,10,4,-11,2,2,9,7};
        System.out.println(FindGreatestSumOfSubArray(a));
    }
    private static int FindGreatestSumOfSubArray(int[] array){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<array.length;i++){
            sum+=array[i];
            if (sum>max){
                max=sum;
            }
            if (sum<0){
                sum=0;
            }
        }
        return max;
    }
}
