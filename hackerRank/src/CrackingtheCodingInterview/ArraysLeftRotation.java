package CrackingtheCodingInterview;
import java.util.*;
public class ArraysLeftRotation {

	public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[]tmp=new int[n];
     k=k%n;
        for(int i=0;i<k;i++)
            tmp[n-k+i]=a[i];
        for(int i=0;i<n-k;i++)
            tmp[i]=a[k+i];
          
      System.out.println(Arrays.toString(tmp));
        return tmp;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        in.close();
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}
