package one;

import java.util.Arrays;

public class testPerm {
public static int[] p={1,2,3};
public static void Perm(int m,int[] p) {
	// TODO Auto-generated method stub
	if(m==2) 
		System.out.println(Arrays.toString(p));
	else
	for(int j=m;m<3;j++){
		int tmp=0;
		tmp=p[j];
		p[j]=p[m];
		p[m]=tmp;
		Perm(m+1,p);
		tmp=p[j];
		p[j]=p[m];
		p[m]=tmp;
		


	}
	}
public static void main(String[] args){

	
	Perm(0,p);
	


}
}