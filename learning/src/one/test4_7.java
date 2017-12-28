package one;

import java.util.Arrays;

public class test4_7 {
	public static 	int n=3;
	public static int[] p=new int[n];
	public static void perm2(int m){
		if(m==0)
			
			System.out.println(Arrays.toString(p));
	else
	{ int i=n;
		while(i-->0){
			if(p[i]==0){
				p[i]=m;
			perm2(m-1);
			p[i]=0;
			}
			
		}
	}
		}
	public static void main(String[] args){
		for(int i=0;i<n;i++)
			p[i]=0;
		perm2(n);
	}
}
