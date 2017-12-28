package tenDaysOfStatistics;
import java.text.DecimalFormat;
import java.util.*;
public class day5NormalDistribution2 {

	private static double normal(double test){
		// to get the standard normal distribution probability
		double ans=0;
		int n=2000;
		double h=test/n;
		for(int i=1;i<=n;i++){
			ans+=Math.exp(-(i*h)*(i*h))*h;
		}
		return 0.5+ans/Math.sqrt(Math.PI);
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double mean=sc.nextDouble();
		double dev=sc.nextDouble();
		double htest=(sc.nextDouble()-mean)/(Math.sqrt(2)*dev);
		double ptest=(sc.nextDouble()-mean)/(Math.sqrt(2)*dev);
		//double ftest=(sc.nextDouble()-mean)/(Math.sqrt(2)*dev);
		double ans1=1-normal(htest);
		double ans2=1-normal(ptest);
		double ans3=1-ans2;
		DecimalFormat df=new DecimalFormat("#0.000");
		System.out.println(df.format(ans1)+"\n"+df.format(ans2)+"\n"+df.format(ans3));
	}
}
