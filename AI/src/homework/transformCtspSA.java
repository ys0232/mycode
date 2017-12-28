package homework;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class transformCtspSA {
	
	private static int N=48;//the number of cities
	private static int T=500;//the initial temperature
	private static float eps=Integer.MIN_VALUE;//the final temperature
	private static float delta=0.98f;//the rate of decrease
	private static int Limit=100;//the largest probability of option
	private static int Oloop=100;//the number of out loop
	private static int Iloop=100;//the number of in loop
	private static int nCase;//the number of test
	private static Point[] p;//the position of every city
	private static Path path;//the best path
	private static double[][] w=new double[N][N];//the distance of every two cities
	private static BufferedReader data;

	private class Point{
		double x,y;
		Point(){}
		Point(double x,double y){
			this.x=x;
			this.y=y;
		}	
	}
	private class Path{
	 int[] city;
	 double len;
	Path(){
		this.city=new int[N];
		this.len=0;
	}
	Path(int[] c,double l){
		this.city=c;
		this.len=l;
	}
	}
	
	private static double dist(Point A,Point B){
		return Math.sqrt((A.x-B.x)*(A.x-B.x)+(A.y-B.y)*(A.y-B.y));
		
	}
	private static void GetDist(Point[] p,int n){
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				w[i][j]=dist(p[i],p[j]);
			    w[j][i]=dist(p[i],p[j]);
			}
		}
	}
	private static void input(String filename) throws Exception{

		String strbuff;
		data = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		for(int i=0;i<N;i++){
			strbuff=data.readLine();
			String[] strcol=strbuff.split(" ");
			p[i].x=Double.valueOf(strcol[1]);
			p[i].y=Double.valueOf(strcol[2]);
		}
		}
	private static void init(int n){
		nCase=0;
		path.len=0.0;
		for(int i=0;i<n;i++){
			path.city[i]=i;
			if(i!=n-1){
				System.out.print(i+"--->");
				path.len+=w[i][i+1];
			}
			else
				System.out.println(i);
		}
		System.out.println("Init path length is : "+path.len);
	}
	private static void Print(Path t,int n){
		System.out.println("path is : ");
		for(int i=0;i<n;i++){
			if(i!=n-1){
				System.out.print(t.city[i]+"--->");
			}
			else
				System.out.println(t.city[i]);
		}
		System.out.println("The path length is : "+t.len);
	}
	private static Path getNext(Path p,int n){
		Path ans=p;
		Random rand=new Random();
		int x=rand.nextInt(N+1);
		int y=rand.nextInt(N+1);
		while(x==y){
			 x=rand.nextInt(N+1);
			 y=rand.nextInt(N+1);
		}
		ans.len=0;
		for(int i=0;i<n-1;i++)
			ans.len+=w[ans.city[i]][ans.city[i+1]];
			System.out.println("nCase = ");
			Print(ans,n);
			nCase++;
			return ans;
		
	}
		private static void SA(int n){
			double t=T;
			Path curPath=path;
			Path newPath=path;
			int p_L=0;
			int p_F=0;
			while(true){
				for(int i=0;i<Iloop;i++){
					newPath=getNext(curPath,n);
					double de=newPath.len-curPath.len;
					if(de<0){
						curPath=newPath;
						p_L=0;
						p_F=0;
					}
					else{
						Random ra=new Random();
						double rd=ra.nextDouble();
						if(Math.exp(de/t)>rd && Math.exp(de/t)<1)
							curPath=newPath;
							p_L++;
						}
						if(p_L>Limit){
							p_F++;break;
						}
					}
					if(curPath.len<newPath.len)
						path=curPath;
					if(p_F>Oloop || t<eps)
						break;
					t*=delta;
				
			}
		}
		public static void main(String[] args) throws Exception{
			input("c://data.txt");
			GetDist(p,N);
			init(N);
			SA(N);
			Print(path,N);
			
		}
		
	}

