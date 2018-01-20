package AtOffer;

import java.util.ArrayList;

/**
 * Created by yolin on 2018/1/18.
 */
public class FindNumbers {
    public static void main(String[] args) {
        int n = 9;
        int[] a={1,3,4,5,6,7,8,9};
        System.out.println(FindNumbersWithSum(a,n).toString());

    }

    private static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> result = new ArrayList<>();
        if (array.length==1)return result;
        int mix = Integer.MAX_VALUE;
        int k = array.length - 1;
        for (int i = k; i >= 0; i--) {
            for (int j = 0; j < k; j++) {
                if (sum<array[i]+array[j])
                    break;
                if (sum == array[i] + array[j]) {
                    if (mix > array[i] * array[j]) {
                        mix = array[i] * array[j];
                        result.add(0);
                        result.add(1);
                        if (array[i] > array[j]) {
                            result.set(0, array[j]);
                            result.set(1, array[i]);
                        } else {
                            result.set(0, array[i]);
                            result.set(1, array[j]);
                        }
                    }
                }
            }
        }


        return result;
    }
}
