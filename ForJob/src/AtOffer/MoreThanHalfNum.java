package AtOffer;

/**
 * Created by yolin on 2018/1/19.
 */
public class MoreThanHalfNum {
    public static void main(String[] args){
        int[] a={1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
    private static int MoreThanHalfNum_Solution(int[] array){
      if (array.length<1)return 0;
        int[] b=new int[array.length/2+1];
        int max=Integer.MIN_VALUE;int index=0;
        for (int i=0;i<b.length;i++){
            int sum=0;b[i]=array[i];
            for (int j=0;j< array.length;j++){
                if (array[j]==b[i])sum++;
            }
            if (sum>max){
                max=sum;
                index=i;
            }
        }
        if (max<b.length){
            return 0;
        }
        return b[index];
    }
}
