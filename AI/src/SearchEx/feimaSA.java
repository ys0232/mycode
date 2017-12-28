package SearchEx;
import java.util.*;
public class feimaSA {

	private int N=1005;
	private static double eps= 1e-8;
	private static float delta=0.98f;
	private static int T0=100;
	private static int[] dx={0,0,-1,1};
	private static int[] dy={-1,1,0,0};//four direction
	private static int dist(Point A,Point B){
		return (int) Math.sqrt((A.x-B.x)*(A.x-B.x)+(A.y-B.y)*(A.y-B.y));
	}
	private static int getSum(Point p[],int n,Point t){
		int ans=0;
		while(n-->0){
			ans+=dist(p[n],t);
		}
		return ans;
	}
	private static double search(Point p[],int n){
		Point s=p[0];
		double t = T0;
		double ans=Integer.MAX_VALUE;
		while(t>eps){
		boolean	flag=true;
			while(flag){
			flag=false;
			for(int i=0;i<4;i++){
				Point z = new Point();
				z.x=(int) (s.x+dx[i]*t);
				z.y=(int) (s.y+dy[i]*t);
				double tp=getSum(p,n,z);
				if(ans>tp){
				ans=tp;
				s=z;
				flag=true;
				}
				
			}
			}
			t*=delta;
		}
		return ans;
	}
	public static void main(String[] args){
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		Point[] p=new Point[n];
		while(sc.hasNext()){
			for(int i=0;i<n;i++){
				p[i]=new Point(sc.nextInt(),sc.nextInt());
				
			}
			System.out.println(search(p,n));
		}
		sc.close();
	}
}
