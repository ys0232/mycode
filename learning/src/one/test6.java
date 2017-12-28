package one;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
import java.util.regex.*;
public class test6 {
	public static void main(String[] args){
		  /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;int k;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a=new int[n];
      int[] reMain=new int[k];
        int num=0;
        for(int i=0;i<k;i++){
            reMain[i]=0;
        }
        for(int i=0;i<n;i++){
        int d=sc.nextInt()%k;
            reMain[d]++;
        }
        int p=0;
        if(k%2==0)
            p=k/2;
            else p=(k+1)/2;
        for(int i=1;i<p;i++){
            if(reMain[i]>reMain[k-i])
                num+=reMain[i];
            else
                num+=reMain[k-i];
            
        }
        if(reMain[p]%2==1 && k%2==0)
            num++;
        if(k==2)
            num=reMain[1];
       
        
        System.out.println(num);
	}

}
