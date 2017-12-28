package tenDaysOfStatistics;
import java.util.*;

public class Quartile {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		sc.close();		
		int Q1,Q2,Q3;
		if(n%2==0){
			Q2=(a[(n-1)/2]+a[n/2])/2;
			if(n/2%2==0){
				Q1=(a[(n-1)/4]+a[(n-1)/4-1])/2;
				Q3=(a[3*(n-1)/4]+a[3*(n-1)/4+1])/2;
			}
			else{
				Q1=a[(n-1)/4];
				Q3=a[3*(n-1)/4];
			}
		}else
		{
			
			Q2=a[(n-1)/2];
			if((n-1)/2%2==0){
				Q1=(a[(n-1)/4]+a[(n-1)/4-1])/2;
				Q3=(a[3*(n-1)/4]+a[3*(n-1)/4+1])/2;
			}
			else{
				Q1=a[(n-1)/4];
				Q3=a[3*(n-1)/4];
			}
		}
		System.out.println(Q1+"\n"+Q2+"\n"+Q3);
		
	}
}
