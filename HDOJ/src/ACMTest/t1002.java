package ACMTest;
import java.util.*;

public class t1002 {
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	int[] a=new int[1000];
	int[] b=new int[1000];
	int[] d=new int[1001];
	String str=new String();
	int k=0;
	while(k<num){
		k++;
		str=sc.next();
		int lenA=str.length();
		for(int i=0;i<1000;i++)
		{
			a[i]=0;
			b[i]=0;
			d[i]=0;
		}
		for(int i=0;i<lenA;i++){
				a[lenA-1-i]=str.charAt(i)-48;
		}
		
		str=sc.next();
		int lenB=str.length();
		for(int i=0;i<lenB;i++){
			b[lenB-1-i]=str.charAt(i)-48;
		}
	
		int len=lenA>lenB?lenA:lenB;
		int flag=0;//¼ÇÂ¼½øÎ»
		for(int i=0;i<len;i++){
			d[i]=a[i]+b[i]+flag;
			flag=d[i]/10;
			d[i]=d[i]%10;
		}
		if(flag!=0){
			d[len]=flag;
		    len=len+1;
		}		
		
		System.out.println("Case "+k+":");
		for(int i=lenA-1;i>=0;i--)
	    System.out.print(a[i]);
		System.out.print(" + ");
		for(int i=lenB-1;i>=0;i--)
			System.out.print(b[i]);
	
		System.out.print(" = ");
		for(int i=len-1;i>=0;i--)
			System.out.print(d[i]);
		System.out.println();
		if(k!=num)
			
		System.out.println();
	}
	sc.close();
}
}
