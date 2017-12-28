package homework;
import java.util.*;
import java.io.*;
public class SA {

	private int cityNum; //the number of city
	private float t0; //initial temperature
	private int N; //iteration step
	private int T;//
	private float delta;//the rate of decrease 
	
	private int[][] distance;//distance matrix
	private int bestT;//the best times of decrease
	
	private int[] Path;//initial path
	private double PathEvaluation;//evaluate path
	private int[] bestPath;//the best path
	private double bestEvaluation;
	private int[] tempPath;//temper path
	private double tempEvaluation;
	
	private Random rand;//produce random number
	
	public SA(int cn,int n,int t,float tt,float aa){
		cityNum=cn;
		N=n;
		T=t;
		t0=tt;
		delta=aa;
	}
	@SuppressWarnings("resource")
	private void init(String filename) throws IOException{
		double[] x,y;
		String strbuff;
		BufferedReader data=new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		distance=new int[cityNum][cityNum];
		x=new double[cityNum];
		y=new double[cityNum];
		for(int i=0;i<cityNum;i++){
			strbuff=data.readLine();
			String[] strcol=strbuff.split(" ");
			x[i]=Double.valueOf(strcol[1]);
			y[i]=Double.valueOf(strcol[2]);//read the data from file,and put it to two arrays
			
		}
		
		for(int i=0;i<cityNum-1;i++){
			distance[i][i]=0;
			for(int j=i+1;j<cityNum;j++){
				distance[i][j]=(int)(Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j])));
				distance[j][i]=distance[i][j];
			}
		}
		distance[cityNum-1][cityNum-1]=0;
		Path=new int[cityNum];
		bestPath=new int[cityNum];
		bestEvaluation=Integer.MAX_VALUE;
		tempPath=new int[cityNum];
		tempEvaluation=Integer.MAX_VALUE;
		bestT=0;
		rand=new Random(System.currentTimeMillis());
		System.out.println("城市数："+cityNum+","+"每个温度最大迭代次数："+N+","+"降温次数："+T+","+"温度下降速度："+delta+","+"初始温度："+t0);
		for(int i=0;i<cityNum;i++)
			System.out.println(Arrays.toString(distance[i]));
	}
	void initPath(){
		int i,j;
		Path[0]=rand.nextInt(65535)%cityNum;
		for(i=1;i<cityNum;){
			Path[i]=rand.nextInt(65535)%cityNum;
			for(j=0;j<i;j++){
				if(Path[i]==Path[j]){
					break;
				}
			}
			if(i==j)
				i++;
		}
	}
	public void copyPath(int[] pathA,int[] pathB){
		for(int i=0;i<cityNum;i++){
			pathA[i]=pathB[i];
		}
	}
	public double evaluate(int[] chr){
		//get one path's length
		double len=0;
		for(int i=1;i<cityNum;i++){
			len+=distance[chr[i-1]][chr[0]];
		}
		len+=distance[chr[cityNum-1]][chr[0]];
		return len;
	}
	public void neighbor(int[] Path,int[] tempPath){
		int i,temp;
		int ran1,ran2;
		
		for(i=0;i<cityNum;i++)
			tempPath[i]=Path[i];
		ran1=rand.nextInt(65535)%cityNum;
		ran2=rand.nextInt(65535)%cityNum;
		while(ran1==ran2){
			ran1=rand.nextInt(65535)%cityNum;
		}
		//exchange the different city,get another path
		temp=tempPath[ran1];
		tempPath[ran1]=tempPath[ran2];
		tempPath[ran2]=temp;
	}
	public void solve(){
		initPath();
		copyPath(Path,bestPath);
		bestEvaluation=evaluate(Path);
		PathEvaluation=bestEvaluation;
		int k=0;
		int n=0;
		float t=t0;
		float r=0.0f;
		while(k<T){
		n=0;
		while(n<N){
			neighbor(Path,tempPath);//get random neighbor
			tempEvaluation=evaluate(tempPath);
			if(tempEvaluation<bestEvaluation){
			
				copyPath(tempPath,bestPath);
				bestT=k;
				bestEvaluation=tempEvaluation;
			}
			r=rand.nextFloat();
			if(tempEvaluation<PathEvaluation || Math.exp((PathEvaluation-tempEvaluation)/t)>r){
				copyPath(tempPath,Path);
				PathEvaluation=tempEvaluation;
			}
			n++;
			}
		t*=delta;
		k++;
		}
		System.out.println("最佳迭代次数： ");
		System.out.println(bestT);
		System.out.println("最佳路径长度： ");
		System.out.println(bestEvaluation);
		System.out.println("最佳路径： ");
		for(int i=0;i<cityNum;i++){
			
			if(i%10==0 && i!=0 || i==cityNum-1)
				System.out.println(bestPath[i]);
			else
				System.out.print(bestPath[i]+"-->");
		}
			
		}
	public static void main(String[] args) throws IOException{
		SA Tsp=new SA(48,40,400,250.0f,0.98f);
		Tsp.init("c://data.txt");
		Tsp.solve();
	}
		}
		
	


