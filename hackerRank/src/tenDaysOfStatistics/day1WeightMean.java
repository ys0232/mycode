package tenDaysOfStatistics;
import java.util.*;
import java.text.*;
public class day1WeightMean {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		int[] w=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		double weightSum=0.0;
		for(int i=0;i<n;i++){
			w[i]=sc.nextInt();
		weightSum+=w[i];
		}		
		double sum=0.0;
		for(int i=0;i<n;i++){
			sum+=a[i]*w[i];
		}
		DecimalFormat df=new DecimalFormat("#0.0");
		System.out.println(df.format(sum/weightSum));
	}
}
