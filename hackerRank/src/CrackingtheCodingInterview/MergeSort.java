package CrackingtheCodingInterview;
import java.util.*;

public class MergeSort {
	 public static long countInversions(int[] arr){
		 int len=arr.length;
		 long count=0;
		    for(int i=0;i<len-1;i++){
		    	for(int j=i+1;j<len;j++){
		    		if(arr[i]>arr[j]){
		    			int t=arr[i];
		    			arr[i]=arr[j];
		    			arr[j]=t;
		    			count++;
		    		}
		    	}
		    }
		    return count;
	    }
	  
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int arr[] = new int[n];
	            for(int arr_i=0; arr_i < n; arr_i++){
	                arr[arr_i] = in.nextInt();
	            }
	            System.out.println(countInversions(arr));
	        }
	    }
	    
	    
	}
