package one;
import java.math.*;
import java.util.Arrays;
import java.util.*;

public class testinggg {
public static 	int n=4;
public static int[] p=new int[n];
public static void exchan(int[] p,int j,int m){
	int tmp=0;
	tmp=p[j];
	p[j]=p[m];
	p[m]=tmp;
}
public static void perm(int m){
	
	if(m==n-1)
		
			System.out.println(Arrays.toString(p));
	else
		for(int j=m;j<n;j++){
			Arrays.sort(p,m,n);
			exchan(p,j,m);
			perm(m+1);
			exchan(p,j,m);
			
		}
			
}

public static void main(String[] args){
	for(int i=0;i<n;i++)
		p[i]=i;
	perm(0);
}
}
