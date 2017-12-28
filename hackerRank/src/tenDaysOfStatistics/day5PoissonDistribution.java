package tenDaysOfStatistics;
import java.util.*;
public class day5PoissonDistribution {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double r=sc.nextDouble();
		int k=sc.nextInt();
		sc.close();
		double e=2.71828;
		double p=1;
		 
		int mk=1;
		double mr=1;
		for(int i=1;i<=k;i++){
			mr*=r;
		mk*=i;	
		}
		p=(double)(p*Math.pow(e,-r)*mr/mk);
		
	   
	    System.out.println(String.format("%.3f", p));
	}
}
