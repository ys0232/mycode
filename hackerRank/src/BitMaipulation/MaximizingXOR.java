package BitMaipulation;
import java.util.*;
import java.math.*;
public class MaximizingXOR {

	static int maxXOR(int l,int r){
		int max=0;
		for(int i=l;i<=r;i++){
			int tmp=0;
			for(int j=l;j<=r;j++){
				int t=i^j;
				if(tmp<t)
					tmp=i^j;
			}
			if(max<tmp)
				max=tmp;
		}
		return max;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int left=Integer.parseInt(sc.nextLine());
		int right=Integer.parseInt(sc.nextLine());
		sc.close();
		int ans=maxXOR(left,right);
		System.out.println(ans);
		
	}
	
}
