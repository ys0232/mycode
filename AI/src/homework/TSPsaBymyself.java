package homework;
import java.util.*;
import java.io.*;
public class TSPsaBymyself {

	private int cityNum; //sum of city
	private float t0; //initial temperature
	private int N; //iteration step
	private int T;//decrease times
	private float a;//chill factor
	
	private double[][] distance;//distance matrix
	private int bestT;//optimum decrease
	
	private int[] Ghh;
	private int GhhEvaluation;
	private int[] bestGh;
	private int bestEvaluation;
	private int[] tempGhh;
	private int tempEvaluation;
	
	private Random rand;
	
	public TSPsaBymyself(){
		
	}
	public TSPsaBymyself(int cn,int n,int t,float tt,float aa ){
		cityNum=cn;
		T=t;
		N=n;
		t0=tt;
		a=aa;
	}
	
	private void init(String filename) throws Exception{
		double[] x;
		double[] y;
		String strbuff;
		BufferedReader data=new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		distance=new double[cityNum][cityNum];
		x=new double[cityNum];
		y=new double[cityNum];
		for(int i=0;i<cityNum;i++){
			strbuff=data.readLine();
			String[] strcol=strbuff.split(" ");
			x[i]=Double.valueOf(strcol[1]);
			y[i]=Double.valueOf(strcol[2]);
			
		}
		for(int i=0;i<cityNum;i++){
		distance[i][i]=0;
		for(int j=i+1;j<cityNum;j++){
			double rij=Math.sqrt(((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]))/10);
			int tij=(int)Math.round(rij);
			if(tij<rij){
				distance[i][j]=tij+1;
				distance[j][i]=distance[i][j];
			}else{
				distance[i][j]=tij;
				distance[j][i]=distance[i][j];
			}
		}
		}
		distance[cityNum-1][cityNum-1]=0;
		
		Ghh=new int[cityNum];
		bestGh=new int[cityNum];
		bestEvaluation=Integer.MAX_VALUE;
		tempGhh=new int[cityNum];
		tempEvaluation=Integer.MAX_VALUE;
		bestT=0;
		rand=new Random(System.currentTimeMillis());
		
		System.out.println(cityNum+","+N+","+T+","+a+","+t0);
		}
	void initGroup(){
		int i,j;
		Ghh[0]=rand.nextInt(65535)%cityNum;
		for(i=1;i<cityNum;i++){
			Ghh[i]=rand.nextInt(65535)%cityNum;
			for(j=0;j<i;j++){
				if(Ghh[i]==Ghh[j]) break;
			}
			if(j==i) i++;
		}
	}
	public void copyGh(int[] Gha,int[] Ghb){
		for(int i=0;i<cityNum;i++){
			Ghb[i]=Gha[i];
		}
	}
	public int evaluate(int[] chr){
		int len=0;
		for(int i=1;i<cityNum;i++){
			len+=distance[chr[i-1]][chr[i]];
		}
		len+=distance[chr[cityNum-1]][chr[0]];
		return len;
	}
	
	public void Linyu(int[] Gh,int[] tempGh){
		int i,temp;
		int ran1,ran2;
		for(i=0;i<cityNum;i++){
			tempGh[i]=Gh[i];
		}
		ran1=rand.nextInt(65535)%cityNum;
		ran2=rand.nextInt(65535)%cityNum;	
		while(ran1==ran2){
			ran2=rand.nextInt(65535)%cityNum;
		}
		temp=tempGh[ran1];
		tempGh[ran1]=tempGh[ran2];
		tempGh[ran2]=temp;
		
	}
	public void solve(){
		initGroup();
		copyGh(Ghh,bestGh);
		bestEvaluation=evaluate(Ghh);
		GhhEvaluation=bestEvaluation;
		int k=0;
		int n=0;
		float t=t0;
		float r=0.0f;
		
		while(k<T){
			n=0;
			while(n<N){
				Linyu(Ghh,tempGhh);
				tempEvaluation=evaluate(tempGhh);
				if(tempEvaluation<bestEvaluation){
					copyGh(tempGhh,bestGh);
					bestT=k;
					bestEvaluation=tempEvaluation;
				}
				r=rand.nextFloat();
				if(tempEvaluation<GhhEvaluation ||Math.exp((GhhEvaluation-tempEvaluation)/t)>r){
					copyGh(tempGhh,Ghh);
					GhhEvaluation=tempEvaluation;
				}
				n++;
			}
			t=a*t;k++;
		}
		System.out.println("最佳长度出现代数： ");
		System.out.println(bestT);
		System.out.println("最佳长度");
		System.out.println(bestEvaluation);
		System.out.println("最佳路径：");
		for(int i=0;i<cityNum;i++){
			System.out.print(bestGh[i]+",");
			if(i%10==0 && i!=0){
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println("Start.....");
		TSPsaBymyself sa=new TSPsaBymyself(280,80,400,250.0f,0.98f);
		sa.init("c://a280.txt");
		sa.solve();
	}
	}
	
	

