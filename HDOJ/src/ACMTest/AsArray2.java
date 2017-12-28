package ACMTest;
import java.util.*;
public class AsArray2 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            
            int[][] path = new int[n][n];
            int k = 0;
            path[0][0] = a[0];
            for (int i = 1; i < n; i++) {
                k = 0;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i] ) {
                        path[i][k++] = a[j];
                    }
                }
                path[i][k] = a[i];
            }
           
           
            System.out.println(" max length of ascend subarray" );
            System.out.println(Arrays.toString(path[k]));
           
            for (int i = 0; i < n; i++)
                System.out.println(Arrays.toString(path[i]));
        }

    }
}
