package AtOffer;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by lenovo on 2018/1/14.
 */
public class FindAtTwoDimension {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int t = 15;
        for (int[] i : a) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println(Find(t, a));
    }

    private static boolean Find(int target, int[][] array) {
        int len = array.length;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            int low = 0, high = array[0].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (array[i][mid] == target) {
                    return true;
                } else if (array[i][mid] > target) {
                    high = mid - 1;
                } else low = mid + 1;
                //System.out.println(array[i][mid]);
            }
            //System.out.println(low + "\t" + high);
        }
        return flag;

    }
}
