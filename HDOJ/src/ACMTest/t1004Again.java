package ACMTest;
import java.util.*;

public class t1004Again {
	//it is the right one;

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n>0){
			String str=sc.nextLine();
			String[] s=new String[n];
			int max=0;int index=0;
			for(int i=0;i<n;i++){
				s[i]=sc.nextLine();
				int count=0;
			    for(int j=0;j<i;j++){
			    	if(s[i].equals(s[j]))
			    		count++;
			    	if(count>max){
			    		index=i;
			    		max=count;
			    	}
			    }
				
			}
			//System.out.println(Arrays.toString(s));
			System.out.println(s[index]);
			n=sc.nextInt();
		}
		sc.close();
	}
}
