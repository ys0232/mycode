package AtOffer;

import java.util.ArrayList;

/**
 * Created by yolin on 2018/3/3.
 */
public class InversePairsOfArray {
    static int cnt = 0;

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 0};
        System.out.println(InversePairs(a)+"\t"+Solution(a));

    }

    private static int InversePairs(int[] array) {

        if (array.length == 0) return cnt;
        MergeSort(array, 0, array.length - 1);
        return cnt % 1000000007;
    }

    private static void MergeSort(int[] array, int first, int end) {

        if (first < end) {
            int mid = (first + end) / 2;
            MergeSort(array, first, mid);
            MergeSort(array, mid + 1, end);
            ArrayList<Integer> tmp = new ArrayList<>();
            MergeArray(array, first, mid, end, tmp);
        }

    }

    private static void MergeArray(int[] array, int first, int mid, int end, ArrayList<Integer> tmp) {
        int i = first, j = mid + 1, m = mid, n = end;
        while (i <= m && j <= n) {
           // System.out.println(array[i] + "\t" + array[j]);
            if (array[i] > array[j]) {
                tmp.add(array[i++]);
                cnt = (cnt + n - j + 1) % 1000000007;
            } else tmp.add(array[j++]);
           // System.out.println(cnt);
        }
        while (i <= m) {
            tmp.add(array[i++]);
        }
        while (j <= n)
            tmp.add(array[j++]);
        int k = 0;
        for (i = first; i <= end && k < tmp.size(); i++) {
            array[i] = tmp.get(k++);
        }


    }

    private static int Solution(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
       // System.arraycopy(array,0,copy,0,array.length);
        for(int i=0;i<array.length;i++)
        {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);//数值过大求余
        return count;

    }

    private static int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007)//数值过大求余
                {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }
}


