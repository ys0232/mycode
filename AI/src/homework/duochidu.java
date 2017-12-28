package homework;
import java.util.*;

public class duochidu {

	double diuta;//初始标准差
	double Td;//阈值
	double dim;//函数维度
	double maxgen;//最大迭代次数
	double sizepop;//种群规模
    int gd;

	double[][] x;
	double[] y;
	double[] fitx;
	double[] d;
	double fitxMax;
	double fitxMin;

	double v;
	int k1=5;
	double k2=10;
	int indexMin=0;
	public duochidu(){
		
	}
	public duochidu(double da,double td,double dim,double maxgen,double sizepop,int gd){
		this.dim=dim;
		this.diuta=da;
		this.Td=td;
		this.maxgen=maxgen;
		this.sizepop=sizepop;
		this.gd=gd;
	}
	//适应度函数
	
	private double minfunc(double[] x1,int index){
		
		double ym;
			double tmp=0;
			double min=Double.MAX_VALUE;
			for(int i=0;i<sizepop;i++){
				for(int j=0;j<dim;j++){
					if(j!=index)
					tmp+=x[i][j]*x[i][j];
					else
						tmp+=x1[i]*x1[i];}
					ym=x[i][0]*x[i][0]*Math.pow(10, 6)+tmp;
			if(ym<min){
				min=ym;
				indexMin=i;}		
		}
			return min;
	}
	private double gety(int j){
		double tmp=0;
		Arrays.sort(x[j]);
		for(int i=0;i<dim;i++)
			tmp+=x[j][i]*x[j][i];
		return x[j][0]*x[j][0]*Math.pow(10, 6)+tmp;
	}
	private void fitness(double[] y){
		double tmp=0;
		for(int i=0;i<sizepop;i++)
			tmp+=y[i];
		for(int i=0;i<sizepop;i++){
		
			fitx[i]=tmp/dim;
			if(fitx[i]>fitxMax)
				fitxMax=fitx[i];
			if(fitx[i]<fitxMin)
				fitxMin=fitx[i];
		}
			
	}
	private void init(){
		x=new double[(int) sizepop][(int) dim];
		y=new double[(int) sizepop];
		fitx=new double[(int) sizepop];
		d=new double[(int)sizepop];
	
		fitxMax=Double.MIN_VALUE;
		fitxMin=Double.MAX_VALUE;
		v=0;
		
		for(int i=0;i<sizepop;i++){
			d[i]=diuta*(2*Math.random()-1);}
		for(int i=0;i<sizepop;i++){
			for(int j=0;j<dim;j++){
				x[i][j]=Math.random()*d[i];
				y[i]=gety(i);
			}
		}
		
		double r=Math.random();
			if(r<Td)
			v=r;
			else
				v=Td;
					
	}
	private void devitor(double[] d){
		double a=0;
		for(int j=0;j<sizepop;j++){
			a+=fitx[j];
		}
		for(int i=0;i<sizepop;i++)
			d[i]=d[i]*Math.exp((sizepop*fitx[i]-a)/(fitxMax-fitxMin));
		Arrays.sort(d);
	}


private void solve(){
	init();
	System.out.println(Arrays.toString(d));
	for(int i=0;i<maxgen;i++){
			for(int j=0;j<sizepop;j++){
				int ci=0;
				if(v<=Td){
					ci++;
				for(int k=0;k<dim;k++){
				double[] t =new double[(int)sizepop];
			for(int q=0;q<sizepop;q++){
				t[q]=(Math.random()*2-1)*d[q]+x[j][k];
				}
			
			double fvmax=gety(j)+Math.random()*Td;
			
			y[j]=minfunc(t,j);
			x[j][k]=t[indexMin];
			if(y[j]<fvmax){
				v=(Math.random()*2-1)*d[j];
			}
			else
				v=Math.random()*Td;
			}
			
		}
			fitness(y);
			devitor(d);
			gd=gd+ci;
			if(gd>k1){
				gd=0;
				Td=Td/k2;
			}
	}
	
}
	double ans=Double.MAX_VALUE;
	int index=0;
	for(int i=0;i<sizepop;i++){
		
			if(y[i]<ans){
				ans=y[i];
				index=i;}
		
	}

	System.out.println(Arrays.toString(y));
	System.out.println(Arrays.toString(x[index]));
	System.out.println("the minimum of f is : "+ans);

	}
public static void main(String[] args){
	duochidu ts=new duochidu(10,0.5,30,6000,20,0); 
	ts.solve();
	
}
}

