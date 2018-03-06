package AtOffer;

/**
 * Created by yolin on 2018/3/3.
 */
public class GetNumberOfK {
    public static void main(String[] args){
        int[] a={1,2,2,2,2,3,4,5,5,5,7,7,7,7,7};
        int[] a1={1,2,3,3,3,3,4,5,6,7,7,7};
        int t=3;
        System.out.println(getNumberOfK(a1,t));
    }
    private static int getNumberOfK(int[] array,int k){
        int cnt=0;
        int low=0;int high=array.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (array[mid]<k){
                low=mid+1;
            }else if (array[mid]>k){
                high=mid-1;
            }else {
                if (array[high]==k && array[low]==k){
                    cnt=(high-low)+1;
                    break;
                }
                if (array[high]>k){
                 high--;
                }
                if (array[low]<k){
                    low++;
                }

            }
        }

        return cnt;
    }
}
