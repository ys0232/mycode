package tenDaysOfStatistics;
import java.util.*;
import java.text.*;
public class day1 {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		int maxCount=0;
		double mean=0;
		double medium=0;
		int sum=0;
		
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			sum+=a[i];
		}
		sc.close();
		DecimalFormat df=new DecimalFormat("#0.0");
		mean=(double)sum/(double)n;
		System.out.println(df.format(mean));
		Arrays.sort(a);
		if(n%2==0)
			medium=(double)(a[n/2]+a[n/2-1])/2;
		else
			medium=a[n/2-1];
		System.out.println(df.format(medium));
		
		int tmpCount=1;
		int index=0;
		for(int i=0;i<n-1;i++){
			if(a[i]==a[i+1])
				tmpCount++;
			else
				tmpCount=1;
			if(tmpCount>maxCount){
				maxCount=tmpCount;
				index=i;
		}}
		System.out.println(a[index]);
	}
}
