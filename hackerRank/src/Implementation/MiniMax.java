package Implementation;
import java.util.*;
public class MiniMax {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		long[] a=new long[5];
		long min=Long.MAX_VALUE;
		long max=0;
		long sumMin=0;
		long sumMax=0;
		int k=5;
		for(int i=0;i<k;i++){
			a[i]=sc.nextLong();
			if(a[i]<min)
				min=a[i];
			if(a[i]>max)
				max=a[i];
		}
		boolean flagA=true;
		boolean flagB=true;
		for(int i=0;i<k;i++){
			if(a[i]!=max || flagA==false){
			sumMin+=a[i];
			
			}
			if(a[i]==max)
				flagA=false;
			if(a[i]!=min || flagB==false){
				sumMax+=a[i];
				
			}
			if(a[i]==min)
				flagB=false;
		}
		
		sc.close();
		System.out.println(sumMin+"\n"+sumMax);
		System.out.println(Long.MAX_VALUE);
	}
}
