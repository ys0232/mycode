package tenDaysOfStatistics;
import java.util.*;
import java.text.*;
public class day1StandardDeviation {

	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int[] a=new int[n];
	float sum=0.0f;
	for(int i=0;i<n;i++){
		a[i]=sc.nextInt();
		sum+=a[i];
	}
	float mean=sum/n;
	float de=0.0f;
	for(int i=0;i<n;i++){
		de+=(float) Math.pow(a[i]-mean,2);
	}
	de=de/n;
	de=(float)Math.sqrt(de);
	
	DecimalFormat df=new DecimalFormat("#0.0");
	System.out.println(df.format(de));
	System.out.println(String.format("%.6f", de));
	}
}
