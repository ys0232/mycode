package one;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class test4 { public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     int k = in.nextInt();
     int q = in.nextInt();
     int[] a = new int[n];
     for(int a_i=0; a_i < n; a_i++){
         a[a_i] = in.nextInt();
     }
     k=k%n;
     for(int a0 = 0; a0 < q; a0++){
         int m = in.nextInt();
         if(m<k)
         System.out.println(a[n-k+m]);
         else
         System.out.println(a[m-k]);
     }
 }
}
