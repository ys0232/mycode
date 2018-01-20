package AtOffer;

import java.util.Arrays;

/**
 * Created by yolin on 2018/1/19.
 //B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 //从左到右算 B[i]=A[0]*A[1]*...*A[i-1]
 //从右到左算B[i]*=A[i+1]*...*A[n-1]
 *
 */
public class ArrayMultiply {
    public static void main(String[] args) {
        int n = 1;
        int[] a = new int[n];int smul=1;
        for (int i=1;i<n+1;i++){
            a[i-1]=2*i;
            smul*=i;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(multiply(a)));
        for (int i=0;i<n;i++){
            System.out.print(smul/a[i]+"\t");
        }
    }

    private static int[] multiply(int[] A) {
        if (A.length==0)return A;
        int len = A.length;
        int[] B = new int[A.length];
        for (int i = 0; i < len; i++) {
            B[i] = 1;
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }
}
