package tenDaysOfStatistics;
import java.util.*;
public class day6TheCentralLimitTheorem {

	private static double normal(double test){
		// to get the standard normal distribution probability
		double ans=0;
		int n=220;
		double h=test/n;
		for(int i=1;i<=n;i++){
			ans+=Math.exp(-(i*h)*(i*h))*h;
		}
		return 0.5+ans/Math.sqrt(Math.PI);
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double max=sc.nextDouble();
		double boxNum=sc.nextDouble();
		double mean=sc.nextDouble()*boxNum;
		double dev=sc.nextDouble()/Math.sqrt(boxNum);
		double test=(max-mean)/(Math.sqrt(2)*dev);
		double ans=normal(test);
		System.out.println(String.format("%.4f", ans));
	}
}
