package one;
import java.io.*;
import java.util.Scanner;
public class test5 { 
	public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int a[] = new int[n];
    int num=0;
    for(int a_i=0; a_i < n; a_i++){
        a[a_i] = in.nextInt();
    }
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if((a[i]+a[j])%k==0)
                num++;
                
    }
       
}
    System.out.println(num);
}
}
