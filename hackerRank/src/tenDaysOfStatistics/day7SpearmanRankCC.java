package tenDaysOfStatistics;
import java.util.*;

public class day7SpearmanRankCC {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		double[] x=new double[n];
		double[] y=new double[n];
		double[] sx=new double[n];
		double[] sy=new double[n];
		for(int i=0;i<n;i++){
			x[i]=sc.nextDouble();
			sx[i]=x[i];}
		for(int i=0;i<n;i++){
			y[i]=sc.nextDouble();
			sy[i]=y[i];}
		sc.close();
		
		Arrays.sort(sx);
		Arrays.sort(sy);
		int k=0;
		int m=0;
		for(int i=1;i<n;i++){
			if(sx[k]!=sx[i]){
				k++;
				sx[k]=sx[i];
				}
			if(sy[m]!=sy[i]){
				m++;
				sy[m]=sy[i];
				}
		}
		//System.out.println(Arrays.toString(x)+"\n"+Arrays.toString(y));
		//System.out.println(Arrays.toString(sx)+"\n"+Arrays.toString(sy));
		
		int[] rkx=new int[n];
		int[] rky=new int[n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(x[i]==sx[j])
					rkx[i]=j+1;
				if(y[i]==sy[j])
					rky[i]=j+1;
			}
		}
		int d=0;
		for(int i=0;i<n;i++){
			d+=(rkx[i]-rky[i])*(rkx[i]-rky[i]);
		}
		double rxy=1-6*(double)d/(n*(n*n-1));
		System.out.println(String.format("%.3f", rxy));
		//System.out.println(Arrays.toString(rkx)+"\n"+Arrays.toString(rky));
			
		
	}
}
