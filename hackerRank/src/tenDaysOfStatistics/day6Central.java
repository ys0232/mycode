package tenDaysOfStatistics;
import java.util.*;
import java.text.*;
public class day6Central {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double num=sc.nextDouble();
		double mean=sc.nextDouble();
		double dev=sc.nextDouble()/Math.sqrt(num);
		double per=sc.nextDouble();
		double zScore=sc.nextDouble();
		sc.close();
		
		double a=mean-zScore*dev;
		double b=mean+zScore*dev;
		DecimalFormat df=new DecimalFormat("#0.00");
		System.out.println(df.format(a)+"\n"+df.format(b));
			
	}
}
