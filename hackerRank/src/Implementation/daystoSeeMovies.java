package Implementation;
import java.util.*;

public class daystoSeeMovies {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int  x=sc.nextInt();
		int  y=sc.nextInt();
		int k=sc.nextInt();
		sc.close();
		
		int[] i=new int[8];
		int count=0;
		for(int m=x;m<=y;m++){
			int t=m;
			int p=0;
			while(t!=0){
			i[p++]=m%10;
			t=t/10;
			}
			int q=0;p=p-1;;
			t=0;
			while(p>=0){
				t+=(int) (Math.pow(10,p)*i[q++]);
				p--;
			}
			System.out.println(t);
			
			int tmp=Math.abs(t-m);
			
			if(tmp%k==0)
				count++;
		}		
		
		System.out.println(count);
		
	}
}
