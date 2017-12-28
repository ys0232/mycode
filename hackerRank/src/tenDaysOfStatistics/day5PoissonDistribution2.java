package tenDaysOfStatistics;
import java.util.*;
public class day5PoissonDistribution2 {

	private final static double e=2.71828;
	private static double Poisson(double r,int k){
		double p=1;
		for(int i=1;i<=k;i++)
			p=p*r/i;
		p=p*Math.pow(e,-r);
		return p;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double a=sc.nextDouble();
		double b=sc.nextDouble();
		sc.close();
		double p=Poisson(a,1);
		int k=2;
		while(p>0.0001){
			p=Poisson(a,k);
		    k++;
		}
		int kb=2;
		p=Poisson(b,1);
		while(p>0.0001){
			p=Poisson(b,kb);
		    kb++;
		}
		k=k>kb?k:kb;
		double costA=0;
		double costB=0;
		//System.out.println(k);
		for(int i=1;i<=k;i++){
			costA+=(160+40*i*i)*Poisson(a,i);
			costB+=(128+40*i*i)*Poisson(b,i);
		}
		System.out.println(String.format("%.3f",costA)+"\n"+String.format("%.3f",costB));
	}
}
