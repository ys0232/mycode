package Implementation;
import java.util.*;

public class JumpingOnTheClouds {

	public static void main(String[] args){
		  Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int c[] = new int[n];
	        int count=0;
	        for(int c_i=0; c_i < n; c_i++){
	            c[c_i] = in.nextInt();
	        }
	        int k=0;
	        while(k<n-1){
	        	if(c[k+2]==0 && k+2<n){
	        		k=k+2;
	        	   count++;
	        	}
	        	else
	        	{
	        		k++;
	        		count++;
	        	}
	        }
	      System.out.println(count);  
	}
}
