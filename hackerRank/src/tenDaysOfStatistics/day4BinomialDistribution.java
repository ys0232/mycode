package tenDaysOfStatistics;
import java.util.*;
import java.text.*;
public class day4BinomialDistribution {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		float a=sc.nextFloat();
		float b=sc.nextFloat();
		sc.close();
		a=a/(a+b);
		b=1-a;
		float p=0.0f;
		int[] f=new int[4];
			f[0]=20;
			f[1]=15;
			f[2]=6;
			f[3]=1;
			
		for(int i=3;i<=6;i++){
			p+=Math.pow(a,i)*Math.pow(b,6-i)*f[i-3];
		}
		System.out.println(String.format("%.3f",p));
	}
}
