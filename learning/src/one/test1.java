package one;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class test1 {
    
    	  public static void main(String[] args) {
    	        Scanner in = new Scanner(System.in);
    	        int n = in.nextInt();
    	        int arr[] = new int[n];
    	        int countPos=0;
    	        int countNeg=0;
    	        int countZero=0;
    	        for(int arr_i=0; arr_i < n; arr_i++){
    	            arr[arr_i] = in.nextInt();
    	            if(arr[arr_i]>0)
    	                countPos++;
    	           else if(arr[arr_i]<0)
    	                countNeg++;
    	               else
    	               countZero++;
    	        }
    	       
    	        System.out.println(new BigDecimal(countPos/(double)n).setScale(6));
    	        System.out.println(new BigDecimal(countNeg/(double)n).setScale(6));
    	        System.out.println(new BigDecimal(countZero/(double)n).setScale(6));
    	    }
    	}

