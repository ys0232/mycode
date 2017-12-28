package Implementation;
import java.util.*;

public class TaumAndBday {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			long b=sc.nextLong();
			long w=sc.nextLong();
			long x=sc.nextLong();
			long y=sc.nextLong();
			long z=sc.nextLong();
			long cost=0;
			if(x+z<y)
				cost=(x+z)*w+x*b;
			else{
				if(y+z<x)
					cost=(y+z)*b+y*w;
				else
					cost=x*b+y*w;
			}
			System.out.println(cost);
				
		}
		sc.close();
	}
}
