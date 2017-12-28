package ThirdDaysTest;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class day10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n>0){
        int[] a=new int[21];
        int max=0;
        int maxtmp=0;
        int k=0;
        while(n>0){
            int re;
             re=n%2;
            n=n/2;
            a[k]=re;
            k++;
          
        }
        int i=0;
        while(i<=k){
            if(a[i]==0 && max>maxtmp){
                maxtmp=max;
                max=0;
            }
            else if(a[i]==0)
                max=0;
                else if(a[i]!=0)
                max=max+a[i];
            i++;
        }
        if(maxtmp>max)
            max=maxtmp;
        System.out.println(max);
        n=in.nextInt();
        
    }
        }
}
