package tenDaysOfStatistics;
import java.util.*;
import java.text.*;

public class day7PearsonCC {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		double[] x=new double[n];
		double[] y=new double[n];
		double sum=0;
		double meanX=0;
		for(int i=0;i<n;i++){
			x[i]=sc.nextDouble();
			sum+=x[i];
			}
		meanX=(double)sum/n;
		sum=0;
		for(int i=0;i<n;i++){
			y[i]=sc.nextDouble();
			sum+=y[i];
			}
		double meanY=(double)sum/n;
		double devX=0;
		double devY=0;
		double cov=0;
		for(int i=0;i<n;i++){
			devX+=(x[i]-meanX)*(x[i]-meanX);
			devY+=(y[i]-meanY)*(y[i]-meanY);
			cov+=(x[i]-meanX)*(y[i]-meanY);
		}
		cov/=n;
		devX=Math.sqrt(devX/n);
		devY=Math.sqrt(devY/n);
		double p=cov/(devX*devY);
		System.out.println(String.format("%.3f", p));
			
		
	}
}
