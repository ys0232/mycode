package tenDaysOfStatistics;
import java.util.*;
import java.text.*;
public class day4GeometricDistribution {

	public static void main(String[] args){
	
		Scanner sc=new Scanner(System.in);
		float p=sc.nextFloat()/sc.nextFloat();
		int n=sc.nextInt();
		float gp=(float) (Math.pow(1-p,n-1)*p);
		System.out.println(String.format("%.3f",gp));
				
	}
}
