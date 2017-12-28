package tenDaysOfStatistics;
import java.util.*;
import java.text.*;

public class day4BinomailDistribution2 {

	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		int sum=sc.nextInt();
		sc.close();
		double noMore=0.0f;
		double atLeast=0.0f;
		float pf=(float)p/100;
		noMore=(double) Math.pow(1-pf,10);
		//System.out.println(noMore);
		noMore+=(double)sum*pf*Math.pow(1-pf,9);
		noMore+=(double)sum*(sum-1)/2*pf*pf*Math.pow(1-pf,8);
		
		//System.out.println(noMore);
		atLeast=1-noMore+(double)sum*(sum-1)/2*pf*pf*Math.pow(1-pf,8);
		System.out.println(String.format("%.3f", noMore));
		System.out.println(String.format("%.3f",atLeast));
	}
	
}
