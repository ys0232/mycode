package tenDaysOfStatistics;
import java.util.*;
public class day8LeastSquareRegression {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=5;
		int[] x=new int[n];
		int[] y=new int[n];
		for(int i=0;i<n;i++){
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		double testx=sc.nextDouble();
		sc.close();
		double sumx=0;
		double sumSq=0;
		double sumy=0;
		double sumxy=0;
		for(int i=0;i<n;i++){
			sumx+=x[i];
			sumy+=y[i];
			sumSq+=x[i]*x[i];
			sumxy+=x[i]*y[i];
		}
		double b=(n*sumxy-sumx*sumy)/(n*sumSq-sumx*sumx);
		double a=(double)sumy/n-b*(double)sumx/n;
		double ans=b*testx+a;
		System.out.println(String.format("%.3f", ans));
	}
}
