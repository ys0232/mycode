package tenDaysOfStatistics;
import java.util.*;
public class day5NormalDistribution {
	
	//the right one,it has passed the test
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
		double test1=sc.nextDouble();
		double test2a=sc.nextDouble();
		double test2b=sc.nextDouble();
		sc.close();
		double ans1=normal((test1-mean)/(Math.sqrt(2)*dev));
		double ans2=normal((test2b-mean)/(Math.sqrt(2)*dev))-normal((test2a-mean)/(Math.sqrt(2)*dev));
		System.out.println(String.format("%.3f", ans1)+"\n"+String.format("%.3f",ans2));
	}
	
}
