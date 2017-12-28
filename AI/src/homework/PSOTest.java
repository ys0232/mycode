package homework;
import java.util.*;

public class PSOTest {

	int n=2;
	double[] x;
	double[] y;
	double[] v;
	double c1=2;
	double c2=2;
	double	pbest[];
	double gbest;
	double vmax=0.1;
	public void fitnessFunction(){
		for(int i=0;i<n;i++){
			y[i]=-1*x[i]*(x[i]-2);
		}
	}
	public void init(){
		x=new double[n];
		y=new double[n];
		v=new double[n];
		pbest=new double[n];
		x[0]=-0.5;
		x[1]=2.6;
		v[0]=0.01;
		v[1]=0.02;
		fitnessFunction();
		for(int i=0;i<n;i++){
			pbest[i]=y[i];
			if(y[i]>gbest)
				gbest=y[i];
		}
		System.out.println("start gbest : "+gbest);
		
	}
	public double getMax(double a,double b){
		return a>b?a:b;
	}
	public void PSO(int max){
		int i=0;
		for(;i<max;i++){
			double w=0.4;
			for(int j=0;j<n;j++){
				v[j]=w*v[j]+c1*Math.random()*(pbest[j]-x[j])+c2*Math.random()*(gbest-x[j]);
				if(v[j]>vmax)
					v[j]=vmax;
				x[j]+=v[j];
				if(x[j]>2)
					x[j]=2;
				if(x[j]<-2)
					x[j]=-2;
				
			}
			fitnessFunction();
			for(int j=0;j<n;j++){
				pbest[j]=getMax(y[j],pbest[j]);
				if(pbest[j]>gbest)
					gbest=pbest[j];
				System.out.println(x[j]+" "+v[j]);
			}
			System.out.println("====="+(i+1)+"=======gbest : "+gbest);
			
		}
	}
	public static void main(String[] args){
		PSOTest ts=new PSOTest();
		ts.init();
		ts.PSO(100);
	}
}
